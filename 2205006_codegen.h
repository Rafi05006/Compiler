#pragma once

#include <fstream>
#include <string>
#include <vector>
#include <map>
#include <regex>
#include <algorithm>
#include <set>


class CodeGenerator {
public:
    std::vector<std::string> codeLines;
    std::vector<std::string> dataSegLines;

    std::map<std::string, int> varOffset;
    int nextLocalOffset = -4;
    int currentDeclSize  = 0;
    int nextParamOffset  = 8;
    int currentParamCount = 0;
    int totalLocalSize   = 0;

    int labelCount = 0;

    std::string newLabel(){
        return "L" + std::to_string(labelCount++);
    }

    void gen(const std::string& line){
        codeLines.push_back(line);
    }

    void genLabel(const std::string& label){
        gen(label + ":");
    }

    void genComment(const std::string& comment){
        gen("; " + comment);
    }

    void genData(const std::string& line){
        dataSegLines.push_back(line);
    }
    

    void resetFunctionFrame(){
        varOffset.clear();
        nextLocalOffset = -4;
        currentDeclSize = 0;
        nextParamOffset = 8;
        currentParamCount = 0;
        totalLocalSize = 0;
    }

    
    void addPrintProcedure(const std::string& filename)
    {
        std::ifstream file(filename);

        if (!file.is_open()) {
            std::cerr << "Cannot open " << filename << "\n";
            return;
        }

        std::string line;

        while (std::getline(file, line)) {
            codeLines.push_back(line);
        }
    }

    // OPTIMIZATION

    static std::string trim(const std::string& s){
        size_t start = s.find_first_not_of(" \t");
        if(start == std::string::npos) return "";
        size_t end = s.find_last_not_of(" \t");
        return s.substr(start, end - start + 1);
    }

    static bool isLabelOnly(const std::string& line){
        std::string t = trim(line);
        if(t.empty() || t[0] == ';') return false;
        return (t.back() == ':' && t.find_first_of(" \t") == std::string::npos);
    }

    static std::string extractLabel(const std::string& line){
        std::string t = trim(line);
        return t.substr(0, t.size() - 1);
    }

    static bool jumpsToLabel(const std::string& line, const std::string& label){
        std::string t = trim(line);
        
        std::string upper = t;
        std::transform(upper.begin(), upper.end(), upper.begin(), ::toupper);

        // Check if it's a jump instruction
        std::vector<std::string> jumpMnemonics = {
            "JMP","JE","JNE","JZ","JNZ","JL","JLE","JG","JGE",
            "JB","JBE","JA","JAE","JO","JNO","JS","JNS",
            "LOOP","LOOPE","LOOPNE","CALL"
        };
        for(auto& m : jumpMnemonics){
            if(upper.substr(0, m.size()) == m){
                std::string rest = trim(t.substr(m.size()));
                // rest should be the label
                size_t semi = rest.find(';');
                if(semi != std::string::npos) rest = trim(rest.substr(0, semi));
                return (rest == label);
            }
        }
        return false;
    }

    static std::string replaceLabelInJump(const std::string& line,
                                           const std::string& oldLabel,
                                           const std::string& newLabel){
        std::string t = trim(line);
      
        size_t pos = t.find(oldLabel);
        if(pos != std::string::npos){
            t.replace(pos, oldLabel.size(), newLabel);
        }
        return t;
    }

  
    static std::pair<std::string,std::string> parseInstr(const std::string& line){
        std::string t = trim(line);
        if(t.empty() || t[0] == ';'){
            return {"",""};
        }
        // Remove trailing comment
        size_t semi = t.find(';');
        if(semi != std::string::npos){
            t = trim(t.substr(0, semi));
        }
        // Split first word
        size_t sp = t.find_first_of(" \t");
        if(sp == std::string::npos) return {t, ""};
        std::string op = t.substr(0, sp);
        std::string operands = trim(t.substr(sp));
        // Uppercase the opcode
        std::transform(op.begin(), op.end(), op.begin(), ::toupper);
        return {op, operands};
    }

    // normalize register name
    static std::string normReg(const std::string& r){
        std::string s = trim(r);
        std::transform(s.begin(), s.end(), s.begin(), ::toupper);
        return s;
    }

    void optimize(){
        std::map<std::string, std::string> labelRemap;
        bool changed = true;
        while(changed){
            changed = false;
            std::vector<std::string> optimized;

            for(size_t i = 0; i < codeLines.size(); i++){
                std::string curr = codeLines[i];
                std::string t = trim(curr);

                // Skip empty/comment
                if(t.empty() || t[0] == ';'){
                    optimized.push_back(curr);
                    continue;
                }

                // RULE 2: PUSH/POP same register 
                auto [op1, ops1] = parseInstr(curr);
                if(op1 == "PUSH" && i + 1 < codeLines.size()){
                    auto [op2, ops2] = parseInstr(codeLines[i + 1]);
                    if(op2 == "POP" && normReg(ops1) == normReg(ops2)){
                        i++;
                        changed = true;
                        continue;
                    }
                }

                // RULE 1: Redundant MOV load then store back 
                if(op1 == "MOV" && i + 1 < codeLines.size()){
                    auto [op2, ops2] = parseInstr(codeLines[i + 1]);
                    if(op2 == "MOV"){
                        size_t c1 = ops1.find(',');
                        size_t c2 = ops2.find(',');
                        if(c1 != std::string::npos && c2 != std::string::npos){
                            std::string left1  = normReg(ops1.substr(0, c1));
                            std::string right1 = trim(ops1.substr(c1 + 1));
                            std::string left2  = trim(ops2.substr(0, c2));
                            std::string right2 = normReg(ops2.substr(c2 + 1));
                            if(right1 == left2 && left1 == right2){
                                i++;
                                changed = true;
                                continue;
                            }
                        }
                    }
                }

                // RULE 3: Redundant ADD/SUB/MUL with identity
                if(op1 == "ADD" || op1 == "SUB"){
                    size_t c = ops1.find(',');
                    if(c != std::string::npos){
                        std::string secondOp = normReg(ops1.substr(c + 1));
                        if(secondOp == "0"){
                            changed = true;
                            continue;
                        }
                    }
                }
                if(op1 == "MUL" || op1 == "IMUL"){
                    size_t c = ops1.find(',');
                    if(c != std::string::npos){
                        std::string secondOp = normReg(ops1.substr(c + 1));
                        if(secondOp == "1"){
                            changed = true;
                            continue;
                        }
                    }
                }

                // RULE 4: Redundant consecutive labels
                if(isLabelOnly(curr)){
                    std::vector<std::string> consecutiveLabels;
                    size_t j = i;
                    while(j < codeLines.size() && isLabelOnly(codeLines[j])){
                        consecutiveLabels.push_back(extractLabel(codeLines[j]));
                        j++;
                    }
                    if(consecutiveLabels.size() > 1){
                        std::string survivor = consecutiveLabels[0];
                        for(size_t r = 1; r < consecutiveLabels.size(); r++){
                            labelRemap[consecutiveLabels[r]] = survivor;
                        }
                        changed = true;
                    }
                    optimized.push_back(codeLines[i]); // keep first label
                    i = j - 1;
                    continue;
                }

                optimized.push_back(curr);
            }

            codeLines = optimized;
        }

        // rewrite jumps to removed labels
        for(size_t i = 0; i < codeLines.size(); i++){
            for(auto& [oldLabel, newLabel] : labelRemap){
                if(jumpsToLabel(codeLines[i], oldLabel)){
                    codeLines[i] = replaceLabelInJump(
                        codeLines[i], oldLabel, newLabel);
                }
            }
        }
    }

    void writeAsmFile(const std::string& filename){
        std::ofstream asmFile(filename, std::ios::out);

        asmFile << "format ELF executable 3\n";
        asmFile << "entry _start\n\n";
        asmFile << "segment readable writeable\n";

        for (auto& l : dataSegLines) asmFile << l << "\n";

        asmFile << "\nsegment readable executable\n";
        asmFile << "_start:\n";
        asmFile << "    CALL main\n";
        asmFile << "    MOV  EAX, 1\n";
        asmFile << "    XOR  EBX, EBX\n";
        asmFile << "    INT  0x80\n\n";

        for (auto& l : codeLines) asmFile << l << "\n";

        asmFile.close();
    }
};