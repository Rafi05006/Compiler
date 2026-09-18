#pragma once

#include <string>
#include <vector>

#include "antlr4-runtime.h"
#include "CSubsetParser.h"
#include "CSubsetBaseVisitor.h"
#include "2205006_codegen.h"


class CSubsetCodeGenVisitor : public CSubsetBaseVisitor {
private:
    CodeGenerator codegen;
    antlr4::TokenStream* tokens; 
    bool isGlobalScope = true;

    std::string currentFunctionName;
    std::string currentFunctionExitLabel;   // RETURN jumps here

    void visitSafe(antlr4::ParserRuleContext* child){
        if(child != nullptr){
            visit(child);
        }
    }

    static std::string offsetStr(int off){
        return off < 0 ? std::to_string(off):("+" + std::to_string(off));
    }


    void genLoad(const std::string& name){
        auto i = codegen.varOffset.find(name);
        if(i != codegen.varOffset.end()){
            codegen.gen("MOV EAX, [EBP" + offsetStr(i->second) + "]");
        }else{
            codegen.gen("MOV EAX, [" + name + "]");
        }
    }

    void genStore(const std::string& name){
        auto i = codegen.varOffset.find(name);
        if(i != codegen.varOffset.end()){
            codegen.gen("MOV [EBP" + offsetStr(i->second) + "], EAX");
        }else{
            codegen.gen("MOV [" + name + "], EAX");
        }
    }
    void genLine(antlr4::ParserRuleContext* ctx){
        codegen.genComment("line " + std::to_string(ctx->getStart()->getLine()));
    }

    void assignScalarOffset(const std::string& name){
        if(isGlobalScope){
            codegen.genData(name + " dd 0");
        }else{
            codegen.varOffset[name] = codegen.nextLocalOffset;
            codegen.nextLocalOffset -= 4;
            codegen.currentDeclSize += 4;
            codegen.totalLocalSize += 4;
        }
    }

    void assignParamOffset(const std::string& name){
        codegen.varOffset[name] = codegen.nextParamOffset;
        codegen.nextParamOffset += 4;
        codegen.currentParamCount++;
    }

    void assignArrayOffset(const std::string& name, int size){
        if(isGlobalScope){
            codegen.genData(name + " dd " + std::to_string(size) + " dup (0)");
        }else{
            codegen.varOffset[name] = codegen.nextLocalOffset;   // arr[0] lands here
            int bytes = size * 4;
            codegen.nextLocalOffset -= bytes;
            codegen.currentDeclSize += bytes;
            codegen.totalLocalSize += bytes;
        }
    }

    void postincdec(CSubsetParser::VarArrayContext* ctx, const std::string& name, bool isIncr){
        visitSafe(ctx->expression());            // index -> EAX
        codegen.gen("MOV  EBX, 4");
        codegen.gen("MUL  EBX");                 // EAX = index * 4

        auto i = codegen.varOffset.find(name);
        if(i != codegen.varOffset.end()){
            int base = std::abs(i->second);
            codegen.gen("MOV  EBX, " + std::to_string(base));
            codegen.gen("ADD  EAX, EBX");
            codegen.gen("NEG  EAX");             // EAX = displacement (negative)
        }
        codegen.gen("MOV  EBX, EAX");            // target offset / displacement

        if(i != codegen.varOffset.end()){
            codegen.gen("MOV  EAX, [EBP + EBX]");    // old value
            codegen.gen("MOV  EDX, EAX");
            codegen.gen(isIncr ? "ADD  EDX, 1" : "SUB  EDX, 1");
            codegen.gen("MOV  [EBP + EBX], EDX");    // store new value
        }else{
            codegen.gen("MOV  EAX, [" + name + " + EBX]");
            codegen.gen("MOV  EDX, EAX");
            codegen.gen(isIncr ? "ADD  EDX, 1" : "SUB  EDX, 1");
            codegen.gen("MOV  [" + name + " + EBX], EDX");
        }
    }

public:
    CSubsetCodeGenVisitor(antlr4::TokenStream* ts) : tokens(ts) {} 

    void finish(){
        codegen.addPrintProcedure("printProc.lib");
        codegen.writeAsmFile("code.asm");
        codegen.optimize();
        codegen.writeAsmFile("optimized_code.asm");
    }

    std::any visitStart(CSubsetParser::StartContext* ctx) override {
        visitSafe(ctx->program());
        return {};
    }
    

    std::any visitProgramBase(CSubsetParser::ProgramBaseContext* ctx) override {
        visitSafe(ctx->unit());
        return {};
    }

    std::any visitProgramRecursive(CSubsetParser::ProgramRecursiveContext* ctx) override {
        visitSafe(ctx->program());
        visitSafe(ctx->unit());
        return {};
    }

    std::any visitUnitVarDecl(CSubsetParser::UnitVarDeclContext* ctx) override {
        visitSafe(ctx->var_declaration());
        return {};
    }

    std::any visitUnitFuncDecl(CSubsetParser::UnitFuncDeclContext* ctx) override {
        return {};
    }

    std::any visitUnitFuncDef(CSubsetParser::UnitFuncDefContext* ctx) override {
        visitSafe(ctx->func_definition());
        return {};
    }

std::any visitFuncDeclWithParams(CSubsetParser::FuncDeclWithParamsContext* ctx) override {
     
        visitSafe(ctx->type_specifier());
        visitSafe(ctx->parameter_list());


        return {};
    }

    std::any visitFuncDeclNoParams(CSubsetParser::FuncDeclNoParamsContext* ctx) override {

        visitSafe(ctx->type_specifier());
        return {};
    }

    std::any visitFuncDefNoParams(CSubsetParser::FuncDefNoParamsContext* ctx) override {
        isGlobalScope = false;
        currentFunctionName = ctx->ID()->getText();
        currentFunctionExitLabel = currentFunctionName + "_exit";
        codegen.resetFunctionFrame();

        genLine(ctx);
        codegen.genLabel(currentFunctionName);
        codegen.gen("PUSH EBP");
        codegen.gen("MOV  EBP, ESP");

        visitSafe(ctx->compound_statement());

        codegen.genLabel(currentFunctionExitLabel);
        codegen.gen("ADD  ESP, " + std::to_string(codegen.totalLocalSize));
        codegen.gen("POP  EBP");
        codegen.gen("RET");

        isGlobalScope = true;
        return {};
    }
    std::any visitFuncDefWithParams(CSubsetParser::FuncDefWithParamsContext* ctx) override {
        isGlobalScope = false;
        currentFunctionName = ctx->ID()->getText();
        currentFunctionExitLabel = currentFunctionName + "_exit";
        codegen.resetFunctionFrame();

        genLine(ctx);
        codegen.genLabel(currentFunctionName);
        codegen.gen("PUSH EBP");
        codegen.gen("MOV  EBP, ESP");

        visitSafe(ctx->parameter_list());

        visitSafe(ctx->compound_statement());

        codegen.genLabel(currentFunctionExitLabel);
        codegen.gen("ADD  ESP, " + std::to_string(codegen.totalLocalSize));
        codegen.gen("POP  EBP");
        codegen.gen("RET  " + std::to_string(codegen.currentParamCount * 4));

        isGlobalScope = true;
        return {};
    }
    std::any visitParamListWithId(CSubsetParser::ParamListWithIdContext* ctx) override {
        visitSafe(ctx->parameter_list());
        visitSafe(ctx->type_specifier());
        assignParamOffset(ctx->ID()->getText());
        return {};
    }

    std::any visitParamListNoId(CSubsetParser::ParamListNoIdContext* ctx) override {
        visitSafe(ctx->parameter_list());
        visitSafe(ctx->type_specifier());
        return {};
    }
   
    std::any visitParamListSingle(CSubsetParser::ParamListSingleContext* ctx) override {
        visitSafe(ctx->type_specifier());
        assignParamOffset(ctx->ID()->getText());
        return {};
    }
    std::any visitParamListTypeOnly(CSubsetParser::ParamListTypeOnlyContext* ctx) override {
        visitSafe(ctx->type_specifier());
        
        return {};
    }
    std::any visitParamListBadNoId(CSubsetParser::ParamListBadNoIdContext* ctx) override {
		visitSafe(ctx->type_specifier());

		return {};
	}

    std::any visitCompoundWithStatements(CSubsetParser::CompoundWithStatementsContext* ctx) override {
        visitSafe(ctx->statements());
        return {};
    }

    std::any visitCompoundEmpty(CSubsetParser::CompoundEmptyContext* ctx) override {
        return {};
    }
    
    std::any visitVar_declaration(CSubsetParser::Var_declarationContext* ctx) override {
        codegen.currentDeclSize = 0;
        visitSafe(ctx->declaration_list());
        if(!isGlobalScope){
            genLine(ctx);
            codegen.gen("SUB ESP, " + std::to_string(codegen.currentDeclSize));
        }
        return {};
    }
    std::any visitTypeInt(CSubsetParser::TypeIntContext* ctx) override {
        return {};
    }

    std::any visitTypeFloat(CSubsetParser::TypeFloatContext* ctx) override {
        return {};
    }

    std::any visitTypeVoid(CSubsetParser::TypeVoidContext* ctx) override {
        return {};
    }

    std::any visitDeclListMulti(CSubsetParser::DeclListMultiContext* ctx) override {
        visitSafe(ctx->declaration_list());
        assignScalarOffset(ctx->ID()->getText());
        return {};
    }
    std::any visitDeclListMultiArray(CSubsetParser::DeclListMultiArrayContext* ctx) override {
        visitSafe(ctx->declaration_list());
        assignArrayOffset(ctx->ID()->getText(), std::stoi(ctx->CONST_INT()->getText()));
        return {};
    }


    std::any visitDeclListSingle(CSubsetParser::DeclListSingleContext* ctx) override {
        assignScalarOffset(ctx->ID()->getText());
        return {};
    }
    std::any visitDeclListSingleArray(CSubsetParser::DeclListSingleArrayContext* ctx) override {
        assignArrayOffset(ctx->ID()->getText(), std::stoi(ctx->CONST_INT()->getText()));
        return {};
    }

    std::any visitDeclListBadMinus(CSubsetParser::DeclListBadMinusContext* ctx) override {
        visitSafe(ctx->declaration_list());
        return {};
    }




    std::any visitStatementsRecursive(CSubsetParser::StatementsRecursiveContext* ctx) override {
        visitSafe(ctx->statements());
        visitSafe(ctx->statement());
        return {};
    }
    std::any visitStatementsSingle(CSubsetParser::StatementsSingleContext* ctx) override {

		visitSafe(ctx->statement());

		return {};
	}


    std::any visitStatementVarDecl(CSubsetParser::StatementVarDeclContext* ctx) override {
        visitSafe(ctx->var_declaration());
        return {};
    }

    std::any visitStatementExpr(CSubsetParser::StatementExprContext* ctx) override {
        genLine(ctx);
        visitSafe(ctx->expression_statement());
        return {};
    }

    std::any visitStatementCompound(CSubsetParser::StatementCompoundContext* ctx) override {
        visitSafe(ctx->compound_statement());
        return {};
    }

    std::any visitStatementFor(CSubsetParser::StatementForContext* ctx) override {
        genLine(ctx);
        visitSafe(ctx->expression_statement(0));   // init

        std::string startLabel = codegen.newLabel();
        std::string endLabel   = codegen.newLabel();

        codegen.genLabel(startLabel);

        // if the condition slot is `;` (empty), treat as infinite loop
        bool condEmpty = dynamic_cast<CSubsetParser::EmptyExpressionStatementContext*>
                            (ctx->expression_statement(1)) != nullptr;

        if(!condEmpty){
            visitSafe(ctx->expression_statement(1));     // condition -> EAX
            codegen.gen("CMP  EAX, 0");
            codegen.gen("JE   " + endLabel);
        }

        visitSafe(ctx->statement());                 // body
        visitSafe(ctx->expression());                // increment
        codegen.gen("JMP  " + startLabel);
        codegen.genLabel(endLabel);
        return {};
    }

    std::any visitStatementIf(CSubsetParser::StatementIfContext* ctx) override {
        genLine(ctx);
        visitSafe(ctx->expression());                 // condition -> EAX
        std::string endLabel = codegen.newLabel();
        codegen.gen("CMP  EAX, 0");
        codegen.gen("JE   " + endLabel);
        visitSafe(ctx->statement());                  // body
        codegen.genLabel(endLabel);
        return {};
    }

    std::any visitStatementIfElse(CSubsetParser::StatementIfElseContext* ctx) override {
        genLine(ctx);
        visitSafe(ctx->expression());                 // condition -> EAX
        std::string elseLabel = codegen.newLabel();
        std::string endLabel  = codegen.newLabel();
        codegen.gen("CMP  EAX, 0");
        codegen.gen("JE   " + elseLabel);
        visitSafe(ctx->statement(0));                 // if-body
        codegen.gen("JMP  " + endLabel);
        codegen.genLabel(elseLabel);
        visitSafe(ctx->statement(1));                 // else-body
        codegen.genLabel(endLabel);
        return {};
    }

    std::any visitStatementWhile(CSubsetParser::StatementWhileContext* ctx) override {
        genLine(ctx);
        std::string startLabel = codegen.newLabel();
        std::string endLabel   = codegen.newLabel();

        codegen.genLabel(startLabel);
        visitSafe(ctx->expression());                 // condition -> EAX
        codegen.gen("CMP  EAX, 0");
        codegen.gen("JE   " + endLabel);
        visitSafe(ctx->statement());                  // body
        codegen.gen("JMP  " + startLabel);
        codegen.genLabel(endLabel);
        return {};
    }


    std::any visitStatementPrintln(CSubsetParser::StatementPrintlnContext* ctx) override {
        genLine(ctx);
        genLoad(ctx->ID()->getText());
        codegen.gen("CALL print_number");
        return {};
    }

    std::any visitStatementReturn(CSubsetParser::StatementReturnContext* ctx) override {
        genLine(ctx);
        visitSafe(ctx->expression());          // value -> EAX
        codegen.gen("JMP " + currentFunctionExitLabel);
        return {};
    }
    std::any visitEmptyExpressionStatement(CSubsetParser::EmptyExpressionStatementContext* ctx) override {
        return {};
    }

    std::any visitExpressionStatement(CSubsetParser::ExpressionStatementContext* ctx) override {
        visitSafe(ctx->expression());
        return {};
    }

    std::any visitExpressionStatementMissingSemicolon(CSubsetParser::ExpressionStatementMissingSemicolonContext* ctx) override {
        // error-recovery node
        visitSafe(ctx->expression());
        return {};
    }
    
    std::any visitVarSimple(CSubsetParser::VarSimpleContext* ctx) override {
        genLoad(ctx->ID()->getText());
        return {};
    }
    std::any visitVarArray(CSubsetParser::VarArrayContext* ctx) override {
        std::string name = ctx->ID()->getText();

        // index expression -> EAX, then *4 (element size)
        visitSafe(ctx->expression());               // index -> EAX
        codegen.gen("MOV  EBX, 4");
        codegen.gen("MUL  EBX");                    // EAX = index * 4

        auto i = codegen.varOffset.find(name);
        if(i != codegen.varOffset.end()){
            // local array: displacement from EBP
            int base = std::abs(i->second);         // distance of arr[0] from EBP
            codegen.gen("MOV  EBX, " + std::to_string(base));
            codegen.gen("ADD  EAX, EBX");           // EAX = index*4 + base
            codegen.gen("MOV  ESI, EAX");
            codegen.gen("NEG  ESI");                // ESI = -(index*4 + base)
            codegen.gen("MOV  EAX, [EBP + ESI]");   // load arr[i]
        }else{
            // global array
            codegen.gen("MOV  EBX, EAX");           // EBX = byte offset
            codegen.gen("MOV  EAX, [" + name + " + EBX]");  // load arr[i]
        }
        return {};
    }

    std::any visitExpressionLogic(CSubsetParser::ExpressionLogicContext* ctx) override {
        visitSafe(ctx->logic_expression());
        return {};
    }

    std::any visitExpressionAssign(CSubsetParser::ExpressionAssignContext* ctx) override {
        auto* vs = dynamic_cast<CSubsetParser::VarSimpleContext*>(ctx->variable());
        auto* va = dynamic_cast<CSubsetParser::VarArrayContext*>(ctx->variable());

        if(va){
            // ARRAY assignment
            std::string name = va->ID()->getText();
            visitSafe(va->expression());            // index -> EAX
            codegen.gen("MOV  EBX, 4");
            codegen.gen("MUL  EBX");                // EAX = index * 4

            auto i = codegen.varOffset.find(name);
            if(i != codegen.varOffset.end()){
                int base = std::abs(i->second);     // local: distance of arr[0] from EBP
                codegen.gen("MOV  EBX, " + std::to_string(base));
                codegen.gen("ADD  EAX, EBX");
                codegen.gen("NEG  EAX");            // EAX = displacement (negative)
            }
            codegen.gen("PUSH EAX");
            visitSafe(ctx->logic_expression()); 
            codegen.gen("POP  EBX");                

            if(i != codegen.varOffset.end()){
                codegen.gen("MOV  [EBP + EBX], EAX");
            }else{
                codegen.gen("MOV  [" + name + " + EBX], EAX");
            }
        }
        else if(vs){
            visitSafe(ctx->logic_expression());
            genStore(vs->ID()->getText());
        }

        return {};
    }

    std::any visitLogicRel(CSubsetParser::LogicRelContext* ctx) override {
        visitSafe(ctx->rel_expression());
        return {};
    }

    std::any visitLogicBinary(CSubsetParser::LogicBinaryContext* ctx) override {
        std::string op = ctx->LOGICOP()->getText();
        std::string endLabel = codegen.newLabel();

        visitSafe(ctx->rel_expression(0));

        if(op == "&&"){
            std::string falseLabel = codegen.newLabel();
            codegen.gen("CMP  EAX, 0");
            codegen.gen("JE   " + falseLabel);
            visitSafe(ctx->rel_expression(1));
            codegen.gen("CMP  EAX, 0");
            codegen.gen("JE   " + falseLabel);
            codegen.gen("MOV  EAX, 1");
            codegen.gen("JMP  " + endLabel);
            codegen.genLabel(falseLabel);
            codegen.gen("MOV  EAX, 0");
            codegen.genLabel(endLabel);
        }
        else{ // "||"
            std::string trueLabel = codegen.newLabel();
            codegen.gen("CMP  EAX, 0");
            codegen.gen("JNE  " + trueLabel);
            visitSafe(ctx->rel_expression(1));
            codegen.gen("CMP  EAX, 0");
            codegen.gen("JNE  " + trueLabel);
            codegen.gen("MOV  EAX, 0");
            codegen.gen("JMP  " + endLabel);
            codegen.genLabel(trueLabel);
            codegen.gen("MOV  EAX, 1");
            codegen.genLabel(endLabel);
        }
        return {};
    }

    std::any visitRelSimple(CSubsetParser::RelSimpleContext* ctx) override {
        visitSafe(ctx->simple_expression());
        return {};
    }

    std::any visitRelBinary(CSubsetParser::RelBinaryContext* ctx) override {
        visitSafe(ctx->simple_expression(0));
        codegen.gen("PUSH EAX");
        visitSafe(ctx->simple_expression(1));
        codegen.gen("POP  EBX");

        std::string op = ctx->RELOP()->getText();
        std::string trueLabel = codegen.newLabel();
        std::string endLabel  = codegen.newLabel();

        codegen.gen("CMP  EBX, EAX");
        if      (op == "<")  codegen.gen("JL   " + trueLabel);
        else if (op == ">")  codegen.gen("JG   " + trueLabel);
        else if (op == "<=") codegen.gen("JLE  " + trueLabel);
        else if (op == ">=") codegen.gen("JGE  " + trueLabel);
        else if (op == "==") codegen.gen("JE   " + trueLabel);
        else if (op == "!=") codegen.gen("JNE  " + trueLabel);

        codegen.gen("MOV  EAX, 0");
        codegen.gen("JMP  " + endLabel);
        codegen.genLabel(trueLabel);
        codegen.gen("MOV  EAX, 1");
        codegen.genLabel(endLabel);
        return {};
    }

    std::any visitSimpleTerm(CSubsetParser::SimpleTermContext* ctx) override {
        visitSafe(ctx->term());
        return {};
    }

    std::any visitSimpleBinary(CSubsetParser::SimpleBinaryContext* ctx) override {
        visitSafe(ctx->simple_expression());
        codegen.gen("PUSH EAX");
        visitSafe(ctx->term());
        codegen.gen("POP  EBX");

        if(ctx->ADDOP()->getText() == "+"){
            codegen.gen("ADD  EAX, EBX");
        }else{
            codegen.gen("SUB  EBX, EAX");
            codegen.gen("MOV  EAX, EBX");
        }
        return {};
    }

    std::any visitSimpleBadAssign(CSubsetParser::SimpleBadAssignContext* ctx) override {
        // error-recovery node
        visitSafe(ctx->simple_expression());
        return {};
    }

    std::any visitTermUnary(CSubsetParser::TermUnaryContext* ctx) override {
        visitSafe(ctx->unary_expression());
        return {};
    }

    std::any visitTermBinary(CSubsetParser::TermBinaryContext* ctx) override {
        visitSafe(ctx->term());
        codegen.gen("PUSH EAX");
        visitSafe(ctx->unary_expression());
        codegen.gen("POP  EBX");

        std::string op = ctx->MULOP()->getText();
        if(op == "*"){
            codegen.gen("MUL EBX");
        }
        else if(op == "/"){
            codegen.gen("XCHG EAX, EBX");
            codegen.gen("XOR  EDX, EDX");
            codegen.gen("DIV  EBX");
        }
        else if(op == "%"){
            codegen.gen("XCHG EAX, EBX");
            codegen.gen("XOR  EDX, EDX");
            codegen.gen("DIV  EBX");
            codegen.gen("MOV  EAX, EDX");
        }
        return {};
    }

    std::any visitUnaryAdd(CSubsetParser::UnaryAddContext* ctx) override {
        visitSafe(ctx->unary_expression());
        if(ctx->ADDOP()->getText() == "-"){
            codegen.gen("NEG  EAX");
        }
        return {};
    }

    std::any visitUnaryNot(CSubsetParser::UnaryNotContext* ctx) override {
        visitSafe(ctx->unary_expression());
        std::string falseLabel = codegen.newLabel();
        std::string endLabel   = codegen.newLabel();
        codegen.gen("CMP  EAX, 0");
        codegen.gen("JE   " + falseLabel);
        codegen.gen("MOV  EAX, 0");
        codegen.gen("JMP  " + endLabel);
        codegen.genLabel(falseLabel);
        codegen.gen("MOV  EAX, 1");
        codegen.genLabel(endLabel);
        return {};
    }

    std::any visitUnaryFactor(CSubsetParser::UnaryFactorContext* ctx) override {
        visitSafe(ctx->factor());
        return {};
    }

    std::any visitFactorVariable(CSubsetParser::FactorVariableContext* ctx) override {
        visitSafe(ctx->variable());
        return {};
    }

    std::any visitFactorFuncCall(CSubsetParser::FactorFuncCallContext* ctx) override {
        std::string name = ctx->ID()->getText();
        auto argExprs = std::any_cast<std::vector<CSubsetParser::Logic_expressionContext*>>(
                            visit(ctx->argument_list()));

        // push arguments RIGHT-TO-LEFT (first arg lands at EBP+8 in callee)
        for (int i = (int)argExprs.size() - 1; i >= 0; i--) {
            visitSafe(argExprs[i]);          // evaluate arg -> EAX
            codegen.gen("PUSH EAX");
        }

        codegen.gen("CALL " + name);
        // return value is in EAX
        return {};
    }

    std::any visitFactorParen(CSubsetParser::FactorParenContext* ctx) override {
        visitSafe(ctx->expression());
        return {};
    }

    std::any visitFactorConstInt(CSubsetParser::FactorConstIntContext* ctx) override {
        codegen.gen("MOV EAX, " + ctx->CONST_INT()->getText());
        return {};
    }

    std::any visitFactorConstFloat(CSubsetParser::FactorConstFloatContext* ctx) override {
        return {};
    }

    std::any visitFactorIncr(CSubsetParser::FactorIncrContext* ctx) override {
        auto* vs = dynamic_cast<CSubsetParser::VarSimpleContext*>(ctx->variable());
        auto* va = dynamic_cast<CSubsetParser::VarArrayContext*>(ctx->variable());
        if(vs){
            std::string name = vs->ID()->getText();
            genLoad(name);                 // EAX = old value
            codegen.gen("MOV EBX, EAX");
            codegen.gen("ADD EBX, 1");
            auto i = codegen.varOffset.find(name);
            if(i != codegen.varOffset.end()){
                codegen.gen("MOV [EBP" + offsetStr(i->second) + "], EBX");
            }else{
                codegen.gen("MOV [" + name + "], EBX");
            }
        }
        else if(va){
            std::string name = va->ID()->getText();
            postincdec(va, name, true);
        }
        return {};
    }

    std::any visitFactorDecr(CSubsetParser::FactorDecrContext* ctx) override {
        auto* vs = dynamic_cast<CSubsetParser::VarSimpleContext*>(ctx->variable());
        auto* va = dynamic_cast<CSubsetParser::VarArrayContext*>(ctx->variable());
        if(vs){
            std::string name = vs->ID()->getText();
            genLoad(name);
            codegen.gen("MOV EBX, EAX");
            codegen.gen("SUB EBX, 1");
            auto it = codegen.varOffset.find(name);
            if(it != codegen.varOffset.end()){
                codegen.gen("MOV [EBP" + offsetStr(it->second) + "], EBX");
            }else{
                codegen.gen("MOV [" + name + "], EBX");
            }
        }
        else if(va){
            std::string name = va->ID()->getText();
            postincdec(va, name, false);
        }
        return {};
    }
    std::any visitArgListEmpty(CSubsetParser::ArgListEmptyContext* ctx) override {
        return std::vector<CSubsetParser::Logic_expressionContext*>{};
    }

    std::any visitArgListNonEmpty(CSubsetParser::ArgListNonEmptyContext* ctx) override {
        return visit(ctx->arguments());
    }

    std::any visitArgsMulti(CSubsetParser::ArgsMultiContext* ctx) override {
        auto v = std::any_cast<std::vector<CSubsetParser::Logic_expressionContext*>>(
                     visit(ctx->arguments()));
        v.push_back(ctx->logic_expression());
        return v;
    }

    std::any visitArgsSingle(CSubsetParser::ArgsSingleContext* ctx) override {
        std::vector<CSubsetParser::Logic_expressionContext*> v;
        v.push_back(ctx->logic_expression());
        return v;
    }

};