#pragma once

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <iomanip>
#include <algorithm>

#include "antlr4-runtime.h"
#include "CSubsetParser.h"
#include "CSubsetLexer.h"
#include "CSubsetBaseVisitor.h"
#include "2205006_symbol_table.h"

class CSubsetVisitorImpl : public CSubsetBaseVisitor {
private:
    antlr4::TokenStream* tokenStream = nullptr;

    std::ofstream logFile;
    std::ofstream errorFile;

    SymbolTable symbolTable;

    std::string currentType;

    long long totalLines = 0;
    int errorCount = 0;

    std::string currentFunctionReturnType;
	std::string currentFunctionName;

    std::vector<std::string> currentParamTypes;
    std::vector<std::string> currentParamNames;

    bool insertingFunctionParameters = false;
	bool currentFunctionIsDefinition = false;

    void insertVariable(const std::string& name,const std::string& type,antlr4::ParserRuleContext* ctx) {

        if (type == "void") {
            return;
        }

        SymbolInfo* symbol = symbolTable.insert(name, type);

        if (symbol == nullptr) {
            logError(ctx, "Multiple declaration of " + name);
        }
    }

    void insertFunction(
        const std::string& name,
        const std::string& returnType,
        const std::vector<std::string>& paramTypes,
        bool isDefined,
        antlr4::ParserRuleContext* ctx
    ) {
        SymbolInfo* symbol = symbolTable.lookupCurrentScopeOnly(name);

        if (symbol == nullptr) {
            symbol = symbolTable.insert(name, returnType);

            if (symbol == nullptr) {
                std::cerr << "Error: could not insert function "
                          << name << std::endl;
                return;
            }

            symbol->isFunction = true;
            symbol->functionInfo = new FunctionInfo();

            symbol->functionInfo->returnType = returnType;
            symbol->functionInfo->paramTypes = paramTypes;
            symbol->functionInfo->isDefined = isDefined;

            return;
        }

        if (!symbol->isFunction) {
            logError(ctx, "Multiple declaration of " + name);
            return;
        }

        if (symbol->functionInfo->returnType != returnType) {

            logError(ctx, "Return type mismatch with function declaration in function " + name);

            return;
        }

        if (symbol->functionInfo->paramTypes.size() != paramTypes.size()) {

            logError(ctx, "Total number of arguments mismatch with declaration in function " + name);

            return;
        }
        for(size_t i=0;i<paramTypes.size();i++){
            if(symbol->functionInfo->paramTypes[i] != paramTypes[i]){
                logError(ctx, std::to_string(i + 1) + "th parameter mismatch in function " + name);
                return;
            }
        }

        if (isDefined && symbol->functionInfo->isDefined) {
            
            logError(ctx, "Function " + name + " already defined");
            return;
        }

        if (isDefined) {
            symbol->functionInfo->isDefined = true;
        }
    }

    void openLogFile() {
        if (!logFile.is_open()) {
            logFile.open("log.txt", std::ios::out);
        }
    }

    void logRule(antlr4::ParserRuleContext* ctx, const std::string& ruleText,
			 antlr4::ParserRuleContext* lineSource = nullptr) {

        if (lineSource == nullptr) {
            lineSource = ctx;
        }

        openLogFile();

        logFile << "Line "
                << lineSource->getStart()->getLine()
                << ": "
                << ruleText
                << "\n\n";

        logFile << formatRuleText(ctx)
                << "\n\n";

        logFile.flush();
    }

    bool isWordLike(antlr4::Token* token) const {
        switch (token->getType()) {
            case CSubsetLexer::INT:
            case CSubsetLexer::FLOAT:
            case CSubsetLexer::VOID:
            case CSubsetLexer::IF:
            case CSubsetLexer::ELSE:
            case CSubsetLexer::FOR:
            case CSubsetLexer::WHILE:
            case CSubsetLexer::PRINTLN:
            case CSubsetLexer::RETURN:
            case CSubsetLexer::ID:
            case CSubsetLexer::CONST_INT:
            case CSubsetLexer::CONST_FLOAT:
                return true;
            default:
                return false;
        }
    }

    std::string formatRuleText(antlr4::ParserRuleContext* ctx) const {
        if (tokenStream == nullptr ||
            ctx->getStart() == nullptr ||
            ctx->getStop() == nullptr) {
            return ctx->getText();
        }

        long long startTok = ctx->getStart()->getTokenIndex();
        long long stopTok = ctx->getStop()->getTokenIndex();

        if (startTok < 0 || stopTok < startTok) {
            return "";
        }

        std::string result;
        bool prevWord = false;

        for (long long i = startTok; i <= stopTok; i++) {
            antlr4::Token* token =
                tokenStream->get(static_cast<size_t>(i));

            if (token->getType() == antlr4::Token::EOF) {
                break;
            }

            bool curWord = isWordLike(token);

            if (!result.empty() &&
                result.back() != '\n' &&
                prevWord && curWord) {
                result += ' ';
            }

            if (token->getType() == CSubsetLexer::CONST_FLOAT) {
                std::ostringstream oss;
                oss << std::fixed
                    << std::setprecision(2)
                    << std::stod(token->getText());
                result += oss.str();
            }
            else {
                result += token->getText();
            }

            if (token->getType() == CSubsetLexer::SEMICOLON ||
                token->getType() == CSubsetLexer::LCURL) {
                result += '\n';
            }
            else if (token->getType() == CSubsetLexer::RCURL) {
                result += "\n\n";
            }

            prevWord = curWord;
        }

        while (!result.empty() &&
               (result.back() == '\n' || result.back() == ' ')) {
            result.pop_back();
        }

        return result;
    }

    void openErrorFile() {
        if (!errorFile.is_open()) {
            errorFile.open("error.txt", std::ios::out);
        }
    }

    void logError(antlr4::ParserRuleContext* ctx,
                  const std::string& message) {

        errorCount++;

        std::string entry =
            "Error at line " +
            std::to_string(ctx->getStart()->getLine()) +
            ": " + message + "\n";

        openErrorFile();
        errorFile << entry << "\n";
        errorFile.flush();

        openLogFile();
        logFile << entry << "\n";
        logFile.flush();
    }

    void enterCompoundScope(antlr4::ParserRuleContext* ctx) {
        symbolTable.enterScope();

        if (insertingFunctionParameters) {

            for (size_t i = 0; i < currentParamNames.size(); i++) {

                symbolTable.insert(
                    currentParamNames[i],
                    currentParamTypes[i]
                );
            }

            insertingFunctionParameters = false;
        }
    }

    void exitCompoundScope() {
        openLogFile();
        symbolTable.exitScope(logFile);
        logFile.flush();
    }

    std::any visitSafe(antlr4::ParserRuleContext* child) {
        if (child == nullptr) {
            return {};
        }
        return visit(child);
    }

    std::string visitType(antlr4::ParserRuleContext* child) {
        std::any value = visitSafe(child);

        if (!value.has_value()) {
            return "undefined";
        }

        try {
            return std::any_cast<std::string>(value);
        }
        catch (const std::bad_any_cast&) {
            return "undefined";
        }
    }

    std::vector<std::string> visitTypes(antlr4::ParserRuleContext* child) {
        std::any value = visitSafe(child);

        if (!value.has_value()) {
            return {};
        }

        try {
            return std::any_cast<std::vector<std::string>>(value);
        }
        catch (const std::bad_any_cast&) {
            return {};
        }
    }

public:
    CSubsetVisitorImpl(antlr4::TokenStream* stream, long long lines)
					: tokenStream(stream), totalLines(lines) {}

    void writeSummary() {
        openLogFile();
        logFile << "\n\nTotal lines: "
                << totalLines
                << "\nTotal errors: "
                << errorCount
                << "\n";
        logFile.flush();
    }

    void logSyntaxError(int line, const std::string& message) {
        errorCount++;

        std::string entry =
            "Error at line " +
            std::to_string(line) +
            ": " + message + "\n";

        openErrorFile();
        errorFile << entry << "\n";
        errorFile.flush();

        openLogFile();
        logFile << entry << "\n";
        logFile.flush();
    }

    void printSymbolTable() {
        openLogFile();
        symbolTable.printCurrentScope(logFile);
        logFile.flush();
    }

    std::any visitStart(CSubsetParser::StartContext* ctx) override {
        visitSafe(ctx->program());

        openLogFile();

        logFile << "\n"
                << "Line "
                << ctx->getStart()->getLine()
                << ": start : program"
                << "\n\n\n";

        logFile.flush();

        return {};
    }

	std::string getUnitText(CSubsetParser::UnitContext* ctx) {//helper
		if (auto* func =
			dynamic_cast<CSubsetParser::UnitFuncDefContext*>(ctx)) {

			return getFuncDefText(func->func_definition());
		}

		return formatRuleText(ctx);
	}

	std::string getProgramText(CSubsetParser::ProgramContext* ctx) {

		if (auto* base =
			dynamic_cast<CSubsetParser::ProgramBaseContext*>(ctx)) {

			return getUnitText(base->unit());
		}

		if (auto* recursive =
			dynamic_cast<CSubsetParser::ProgramRecursiveContext*>(ctx)) {

			return getProgramText(recursive->program())
				+ "\n"
				+ getUnitText(recursive->unit());
		}

		return ctx->getText();
	}

    std::any visitProgramBase(CSubsetParser::ProgramBaseContext* ctx) override {
        visitSafe(ctx->unit());
        openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": program : unit\n\n";

		logFile << getProgramText(ctx)
				<< "\n\n";

		logFile.flush();
        return {};
    }

    std::any visitProgramRecursive(CSubsetParser::ProgramRecursiveContext* ctx) override {
        visitSafe(ctx->program());
        visitSafe(ctx->unit());
        openLogFile();

		logFile << "Line "
				<< ctx->unit()->getStart()->getLine()
				<< ": program : program unit\n\n";

		logFile << getProgramText(ctx)
				<< "\n\n";

		logFile.flush();

        return {};
    }

    std::any visitUnitVarDecl(CSubsetParser::UnitVarDeclContext* ctx) override {
        visitSafe(ctx->var_declaration());
        logRule(ctx, "unit : var_declaration");
        return {};
    }

    std::any visitUnitFuncDecl(CSubsetParser::UnitFuncDeclContext* ctx) override {
        visitSafe(ctx->func_declaration());
        logRule(ctx, "unit : func_declaration");
        return {};
    }

    std::any visitUnitFuncDef(CSubsetParser::UnitFuncDefContext* ctx) override {
        visitSafe(ctx->func_definition());
        openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": unit : func_definition\n\n";

		logFile << getFuncDefText(ctx->func_definition())
				<< "\n\n";

		logFile.flush();
        return {};
    }

    std::any visitFuncDeclWithParams(CSubsetParser::FuncDeclWithParamsContext* ctx) override {
        currentParamTypes.clear();
        currentParamNames.clear();

		currentFunctionIsDefinition = false;
		currentFunctionName =ctx->ID()->getText();

        visitSafe(ctx->type_specifier());
        visitSafe(ctx->parameter_list());
        insertFunction(ctx->ID()->getText(),ctx->type_specifier()->getText(),currentParamTypes,false,ctx);

        symbolTable.enterScope();
        symbolTable.discardScope();

		openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON\n\n";

		logFile << ctx->type_specifier()->getText()
				<< " "
				<< ctx->ID()->getText()
				<< "("
				<< getParameterListText(ctx->parameter_list())
				<< ");\n\n";

		logFile.flush();

        return {};
    }

    std::any visitFuncDeclNoParams(CSubsetParser::FuncDeclNoParamsContext* ctx) override {
        currentParamTypes.clear();
		currentFunctionName.clear();

		currentFunctionIsDefinition = false;
		currentFunctionName = ctx->ID()->getText();

        visitSafe(ctx->type_specifier());
        insertFunction(
            ctx->ID()->getText(),
            ctx->type_specifier()->getText(),
            currentParamTypes,
            false,
            ctx
        );

        symbolTable.enterScope();
        symbolTable.discardScope();

        logRule(ctx, "func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON");
        return {};
    }
	std::string getFuncDefNoParamsText(CSubsetParser::FuncDefNoParamsContext* ctx) {
		return ctx->type_specifier()->getText() + " " + ctx->ID()->getText()
			+ "()" + getCompoundStatementText(ctx->compound_statement());
	}

	std::string getParameterListText(CSubsetParser::Parameter_listContext* ctx) {
		if (auto* bad = dynamic_cast<CSubsetParser::ParamListBadNoIdContext*>(ctx)) {

			return bad->type_specifier()->getText();
		}

		if (auto* withId = dynamic_cast<CSubsetParser::ParamListWithIdContext*>(ctx)) {
			return getParameterListText(withId->parameter_list())+ ","+ withId->type_specifier()->getText()
				+ " "+ withId->ID()->getText();
		}

		if (auto* noId = dynamic_cast<CSubsetParser::ParamListNoIdContext*>(ctx)) {
			return getParameterListText(noId->parameter_list())+ ","+ noId->type_specifier()->getText();
		}

		if (auto* single = dynamic_cast<CSubsetParser::ParamListSingleContext*>(ctx)) {
			return single->type_specifier()->getText()
				+ " "
				+ single->ID()->getText();
		}

		if (auto* typeOnly = dynamic_cast<CSubsetParser::ParamListTypeOnlyContext*>(ctx)) {

			return typeOnly->type_specifier()->getText();
		}

		return formatRuleText(ctx);
	}

	std::string getFuncDefText(CSubsetParser::Func_definitionContext* ctx) {
		if (auto* func = dynamic_cast<CSubsetParser::FuncDefNoParamsContext*>(ctx)) {
			return getFuncDefNoParamsText(func);
		}

		if (auto* func = dynamic_cast<CSubsetParser::FuncDefWithParamsContext*>(ctx)) {

			return func->type_specifier()->getText()
				+ " "
				+ func->ID()->getText()
				+ "("
				+ getParameterListText(func->parameter_list())
				+ ")"
				+ getCompoundStatementText(func->compound_statement())
				;
		}

		return formatRuleText(ctx);
	}

    std::any visitFuncDefNoParams(CSubsetParser::FuncDefNoParamsContext* ctx) override {
        currentParamTypes.clear();
        currentParamNames.clear();

        currentFunctionReturnType = ctx->type_specifier()->getText();
		currentFunctionName =ctx->ID()->getText();
		currentFunctionIsDefinition = true;
				
        visitSafe(ctx->type_specifier());

		insertFunction(ctx->ID()->getText(),ctx->type_specifier()->getText(),currentParamTypes,true,ctx);

		visitSafe(ctx->compound_statement());
        openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": func_definition : type_specifier ID LPAREN RPAREN compound_statement\n\n";

		logFile << getFuncDefNoParamsText(ctx)
				<< "\n\n";

		logFile.flush();
        return {};
    }

    std::any visitFuncDefWithParams(CSubsetParser::FuncDefWithParamsContext* ctx) override {
        currentParamTypes.clear();
        currentParamNames.clear();

        currentFunctionReturnType = ctx->type_specifier()->getText();
		currentFunctionName =ctx->ID()->getText();
		currentFunctionIsDefinition = true;

        visitSafe(ctx->type_specifier());
        visitSafe(ctx->parameter_list());

        insertFunction(ctx->ID()->getText(),ctx->type_specifier()->getText(),currentParamTypes,true,ctx);

        insertingFunctionParameters = true;
        visitSafe(ctx->compound_statement());

		openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n\n";

		logFile << getFuncDefText(ctx)
				<< "\n\n";

		logFile.flush();

        return {};
    }

    std::any visitParamListWithId(CSubsetParser::ParamListWithIdContext* ctx) override {
		currentParamTypes.clear();
		currentParamNames.clear();

        visitSafe(ctx->parameter_list());
        visitSafe(ctx->type_specifier());

        currentParamTypes.push_back(ctx->type_specifier()->getText());

        std::string paramName = ctx->ID()->getText();
        bool duplicate = std::find(currentParamNames.begin(), currentParamNames.end(), paramName)
							 != currentParamNames.end();

        currentParamNames.push_back(paramName);

        if (duplicate) {
            logError(ctx, "Multiple declaration of " + paramName + " in parameter");
        }

        logRule(ctx, "parameter_list : parameter_list COMMA type_specifier ID");
        return {};
    }

    std::any visitParamListNoId(CSubsetParser::ParamListNoIdContext* ctx) override {
        visitSafe(ctx->parameter_list());
        visitSafe(ctx->type_specifier());
        currentParamTypes.push_back(ctx->type_specifier()->getText());
        logRule(ctx, "parameter_list : parameter_list COMMA type_specifier");
        return {};
    }

    std::any visitParamListSingle(CSubsetParser::ParamListSingleContext* ctx) override {
        visitSafe(ctx->type_specifier());
        currentParamTypes.push_back(ctx->type_specifier()->getText());
        currentParamNames.push_back(ctx->ID()->getText());
        logRule(ctx, "parameter_list : type_specifier ID");
        return {};
    }

    std::any visitParamListTypeOnly(CSubsetParser::ParamListTypeOnlyContext* ctx) override {
		currentParamNames.clear();
		currentParamTypes.clear();

        visitSafe(ctx->type_specifier());
        currentParamTypes.push_back(ctx->type_specifier()->getText());

		if (currentFunctionIsDefinition) {

			logSyntaxError(
				static_cast<int>(
					ctx->getStart()->getLine()
				),
				std::to_string(currentParamTypes.size()) +
				"th parameter's name not given in function definition of " +
				currentFunctionName
			);
		}

        logRule(ctx, "parameter_list : type_specifier");
        return {};
    }
	std::any visitParamListBadNoId(CSubsetParser::ParamListBadNoIdContext* ctx) override {
		currentParamNames.clear();
		currentParamTypes.clear();

		visitSafe(ctx->type_specifier());

		currentParamTypes.push_back(ctx->type_specifier()->getText());

		logRule(ctx->type_specifier(), "parameter_list : type_specifier");

		logSyntaxError(
			static_cast<int>(ctx->getStart()->getLine()),"syntax error, unexpected token(s) '" +
			ctx->ADDOP()->getText() +
			"' before ')'"
		);

		if (currentFunctionIsDefinition) {
			logSyntaxError(
				static_cast<int>(ctx->getStart()->getLine()),
				std::to_string(currentParamTypes.size()) +
				"th parameter's name not given in function definition of " +
				currentFunctionName
			);
		}

		return {};
	}

	std::string getCompoundStatementText(CSubsetParser::Compound_statementContext* ctx) {
		if (auto* withStatements = dynamic_cast<CSubsetParser::CompoundWithStatementsContext*>(ctx)) {
			
			return "{\n"+ getStatementsText(withStatements->statements())+ "\n}";
		}
		return "{}";
	}
    std::any visitCompoundWithStatements(CSubsetParser::CompoundWithStatementsContext* ctx) override {
        enterCompoundScope(ctx);
        visitSafe(ctx->statements());
        openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": compound_statement : LCURL statements RCURL\n\n";

		logFile << getCompoundStatementText(ctx)
				<< "\n\n";

		logFile.flush();

		exitCompoundScope();
        return {};
    }

    std::any visitCompoundEmpty(CSubsetParser::CompoundEmptyContext* ctx) override {
        enterCompoundScope(ctx);
        
		openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": compound_statement : LCURL RCURL\n\n";

		logFile << "{}\n\n";

		logFile.flush();
        exitCompoundScope();
        return {};
    }
	std::string formatDeclarationList(CSubsetParser::Declaration_listContext* ctx) const {//helper

		if (auto* bad = dynamic_cast<CSubsetParser::DeclListBadMinusContext*>(ctx)) {
			return formatDeclarationList(bad->declaration_list());
		}

		if (auto* multi = dynamic_cast<CSubsetParser::DeclListMultiContext*>(ctx)) {

			return formatDeclarationList(
					multi->declaration_list()
				)
				+ ","
				+ multi->ID()->getText();
		}

		if (auto* single = dynamic_cast<CSubsetParser::DeclListSingleContext*>(ctx)) {

			return single->ID()->getText();
		}

		return ctx->getText();
	}

    std::any visitVar_declaration(CSubsetParser::Var_declarationContext* ctx) override {
        visitSafe(ctx->type_specifier());
        currentType = ctx->type_specifier()->getText();
        visitSafe(ctx->declaration_list());
		
		if (currentType == "void") {
            logError(ctx, "Variable type cannot be void");
        }
		openLogFile();


		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": var_declaration : type_specifier declaration_list SEMICOLON\n\n";

		logFile << ctx->type_specifier()->getText()
				<< " "
				<< formatDeclarationList(
					ctx->declaration_list()
				)
				<< ";\n\n";

		logFile.flush();
       
        
        return {};
    }

    std::any visitTypeInt(CSubsetParser::TypeIntContext* ctx) override {
        logRule(ctx, "type_specifier : INT");
        return {};
    }

    std::any visitTypeFloat(CSubsetParser::TypeFloatContext* ctx) override {
        logRule(ctx, "type_specifier : FLOAT");
        return {};
    }

    std::any visitTypeVoid(CSubsetParser::TypeVoidContext* ctx) override {
        logRule(ctx, "type_specifier : VOID");
        return {};
    }

	

    std::any visitDeclListMulti(CSubsetParser::DeclListMultiContext* ctx) override {
        visitSafe(ctx->declaration_list());
        insertVariable(ctx->ID()->getText(), currentType,ctx);
		
        auto* prev = dynamic_cast<CSubsetParser::DeclListBadMinusContext*>(ctx->declaration_list());

		if (prev != nullptr) {

			openLogFile();

			logFile << "Line "
					<< ctx->getStart()->getLine()
					<< ": declaration_list : declaration_list COMMA ID\n\n";

			// The recovered valid declaration is the ID before -y. For x-y,z this is x.
			logFile << prev->declaration_list()->getText()
					<< ","
					<< ctx->ID()->getText()
					<< "\n\n";

			logFile.flush();

		} else {

			logRule(ctx, "declaration_list : declaration_list COMMA ID");
		}

		return {};

    }

    std::any visitDeclListMultiArray(CSubsetParser::DeclListMultiArrayContext* ctx) override {
        visitSafe(ctx->declaration_list());
        if (currentType != "void") {
            SymbolInfo* symbol =
                symbolTable.insert(ctx->ID()->getText(), currentType);

            if (symbol == nullptr) {
                logError(ctx, "Multiple declaration of " + ctx->ID()->getText());
            }
            else {
                symbol->isArray = true;
                symbol->arrayInfo = new ArrayInfo();
                symbol->arrayInfo->size =
                    std::stoi(ctx->CONST_INT()->getText());
            }
        }

        logRule(ctx, "declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD");
        return {};
    }

    std::any visitDeclListSingle(CSubsetParser::DeclListSingleContext* ctx) override {
        insertVariable(ctx->ID()->getText(), currentType,ctx);
        logRule(ctx, "declaration_list : ID");
        return {};
    }

    std::any visitDeclListSingleArray(CSubsetParser::DeclListSingleArrayContext* ctx) override {
        if (currentType != "void") {
            SymbolInfo* symbol =
                symbolTable.insert(ctx->ID()->getText(), currentType);

            if (symbol == nullptr) {
                logError(ctx, "Multiple declaration of " + ctx->ID()->getText());
            }
            else {
                symbol->isArray = true;
                symbol->arrayInfo = new ArrayInfo();
                symbol->arrayInfo->size =
                    std::stoi(ctx->CONST_INT()->getText());
            }
        }

        logRule(ctx, "declaration_list : ID LTHIRD CONST_INT RTHIRD");
        return {};
    }
	std::any visitDeclListBadMinus(CSubsetParser::DeclListBadMinusContext* ctx) override {

		visitSafe(ctx->declaration_list());

		logSyntaxError(
			static_cast<int>(ctx->getStart()->getLine()),
			"syntax error, unexpected token(s) '" +
			ctx->ADDOP()->getText() + " " +
			ctx->ID()->getText() +
			"' in declaration list"
		);

		return {};
	}
	std::string getStatementText(CSubsetParser::StatementContext* ctx) {
    if (auto* varStmt = dynamic_cast<CSubsetParser::StatementVarDeclContext*>(ctx)) {

        auto* varDecl = varStmt->var_declaration();

        return varDecl->type_specifier()->getText()
             + " "
             + formatDeclarationList(
                   varDecl->declaration_list()
               )
             + ";";
    }

	if (auto* exprStmt = dynamic_cast<CSubsetParser::StatementExprContext*>(ctx)) {
		auto* es = exprStmt->expression_statement();

		if (auto* missing = dynamic_cast<CSubsetParser::ExpressionStatementMissingSemicolonContext*>(es)) {

			return getExpressionText(missing->expression());
		}

		return formatRuleText(es);
	}

    return formatRuleText(ctx);
}
	std::string getStatementsText(CSubsetParser::StatementsContext* ctx) {

		if (auto* single = dynamic_cast<CSubsetParser::StatementsSingleContext*>(ctx)) {

			return getStatementText(
				single->statement()
			);
		}

		if (auto* recursive = dynamic_cast<CSubsetParser::StatementsRecursiveContext*>(ctx)) {

			return getStatementsText(
					recursive->statements()
				)
				+ "\n"
				+ getStatementText(
					recursive->statement()
				);
		}

		return ctx->getText();
	}

    std::any visitStatementsRecursive(CSubsetParser::StatementsRecursiveContext* ctx) override {
        
		visitSafe(ctx->statements());
		visitSafe(ctx->statement());

		openLogFile();

		logFile << "Line "
				<< ctx->statement()->getStart()->getLine()
				<< ": statements : statements statement\n\n";

		logFile << getStatementsText(ctx)
				<< "\n\n";

		logFile.flush();

		return {};
    }

   std::any visitStatementsSingle(CSubsetParser::StatementsSingleContext* ctx) override {

		visitSafe(ctx->statement());

		openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": statements : statement\n\n";

		logFile << getStatementsText(ctx)
				<< "\n\n";

		logFile.flush();

		return {};
	}

    std::any visitStatementVarDecl(CSubsetParser::StatementVarDeclContext* ctx) override {
        visitSafe(ctx->var_declaration());
			
		auto* varDecl = ctx->var_declaration();

		openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": statement : var_declaration\n\n";

		auto* declCtx = varDecl->declaration_list();

		logFile << varDecl->type_specifier()->getText()
				<< " "
				<< formatDeclarationList(declCtx)
				<< ";\n\n";

		logFile.flush();

		return {};
    }

    std::any visitStatementExpr(CSubsetParser::StatementExprContext* ctx) override {
        visitSafe(ctx->expression_statement());
        openLogFile();

        logFile << "Line "
                << ctx->getStart()->getLine()
                << ": statement : expression_statement\n\n";

        logFile << getStatementText(ctx)
                << "\n\n";

        logFile.flush();

        return {};
    }

    std::any visitStatementCompound(CSubsetParser::StatementCompoundContext* ctx) override {
        visitSafe(ctx->compound_statement());
        logRule(ctx, "statement : compound_statement");
        return {};
    }

    std::any visitStatementFor(CSubsetParser::StatementForContext* ctx) override {
        visitSafe(ctx->expression_statement(0));
        visitSafe(ctx->expression_statement(1));
        visitSafe(ctx->expression());
        visitSafe(ctx->statement());
        logRule(ctx, "statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement");
        return {};
    }

    std::any visitStatementIf(CSubsetParser::StatementIfContext* ctx) override {
        visitSafe(ctx->expression());
        visitSafe(ctx->statement());
        logRule(ctx, "statement : IF LPAREN expression RPAREN statement");
        return {};
    }

    std::any visitStatementIfElse(CSubsetParser::StatementIfElseContext* ctx) override {
        visitSafe(ctx->expression());
        visitSafe(ctx->statement(0));
        visitSafe(ctx->statement(1));
        logRule(ctx, "statement : IF LPAREN expression RPAREN statement ELSE statement");
        return {};
    }

    std::any visitStatementWhile(CSubsetParser::StatementWhileContext* ctx) override {
        visitSafe(ctx->expression());
        visitSafe(ctx->statement());
        logRule(ctx, "statement : WHILE LPAREN expression RPAREN statement");
        return {};
    }

    std::any visitStatementPrintln(CSubsetParser::StatementPrintlnContext* ctx) override {
        SymbolInfo* symbol =
            symbolTable.lookup(ctx->ID()->getText());

        if (symbol == nullptr) {
            logError(ctx, "Undeclared variable " + ctx->ID()->getText());
        }
        else if (symbol->isFunction) {
            logError(ctx, "Function " + ctx->ID()->getText() + " cannot be used as variable");
        }
        else if (symbol->isArray) {
            logError(ctx, "Type mismatch, " + ctx->ID()->getText() + " is an array");
        }

        logRule(ctx, "statement : PRINTLN LPAREN ID RPAREN SEMICOLON");
        return {};
    }

    std::any visitStatementReturn(CSubsetParser::StatementReturnContext* ctx) override {
        std::string returnType = visitType(ctx->expression());
        if(currentFunctionReturnType=="int" && returnType=="float"){
            logError(ctx, "Return type mismatch");
        }
        logRule(ctx, "statement : RETURN expression SEMICOLON");
        return {};
    }

	std::string getExpressionText(CSubsetParser::ExpressionContext* ctx) {
		if (auto* logic = dynamic_cast<CSubsetParser::ExpressionLogicContext*>(ctx)) {
			return getLogicExpressionText(
				logic->logic_expression()
			);
		}

		if (auto* assign = dynamic_cast<CSubsetParser::ExpressionAssignContext*>(ctx)) {

			return assign->variable()->getText()
				+ "="
				+ getLogicExpressionText(
					assign->logic_expression()
				);
		}

		return ctx->getText();
	}
	std::string getLogicExpressionText(CSubsetParser::Logic_expressionContext* ctx) {
		if (auto* rel = dynamic_cast<CSubsetParser::LogicRelContext*>(ctx)) {

			return getRelExpressionText(
				rel->rel_expression()
			);
		}

		if (auto* binary = dynamic_cast<CSubsetParser::LogicBinaryContext*>(ctx)) {

			return getRelExpressionText(binary->rel_expression(0))
				+ binary->LOGICOP()->getText()
				+ getRelExpressionText(binary->rel_expression(1));
		}

		return ctx->getText();
	}
	std::string getRelExpressionText(CSubsetParser::Rel_expressionContext* ctx) {
		if (auto* simple = dynamic_cast<CSubsetParser::RelSimpleContext*>(ctx)) {

			return getSimpleExpressionText(simple->simple_expression());
		}

		if (auto* binary =
			dynamic_cast<CSubsetParser::RelBinaryContext*>(ctx)) {

			return getSimpleExpressionText(binary->simple_expression(0))
				+ binary->RELOP()->getText()
				+ getSimpleExpressionText(binary->simple_expression(1));
		}

		return ctx->getText();
	}

	std::string getFactorText(CSubsetParser::FactorContext* ctx) {
		if (auto* constFloat = dynamic_cast<CSubsetParser::FactorConstFloatContext*>(ctx)) {

			std::ostringstream oss;
			oss << std::fixed
				<< std::setprecision(2)
				<< std::stod(constFloat->CONST_FLOAT()->getText());
			return oss.str();
		}

		return ctx->getText();
	}
	std::string getUnaryExpressionText(CSubsetParser::Unary_expressionContext* ctx) {
		if (auto* factor = dynamic_cast<CSubsetParser::UnaryFactorContext*>(ctx)) {
			return getFactorText(factor->factor());
		}

		if (auto* add = dynamic_cast<CSubsetParser::UnaryAddContext*>(ctx)) {

			return add->ADDOP()->getText()
					+ getUnaryExpressionText(
					add->unary_expression()
				);
		}

		if (auto* notExpr = dynamic_cast<CSubsetParser::UnaryNotContext*>(ctx)) {
			return "!"
				+ getUnaryExpressionText(notExpr->unary_expression());
		}

		return ctx->getText();
	}
	std::string getTermText(CSubsetParser::TermContext* ctx) {
		if (auto* unary = dynamic_cast<CSubsetParser::TermUnaryContext*>(ctx)) {
			return getUnaryExpressionText(unary->unary_expression());
		}

		if (auto* binary = dynamic_cast<CSubsetParser::TermBinaryContext*>(ctx)) {

			return getTermText(binary->term())
				+ binary->MULOP()->getText()
				+ getUnaryExpressionText(binary->unary_expression());
		}

		return ctx->getText();
	}
	std::string getSimpleExpressionText(CSubsetParser::Simple_expressionContext* ctx) {
		if (auto* bad = dynamic_cast<CSubsetParser::SimpleBadAssignContext*>(ctx)) {

			return getSimpleExpressionText(bad->simple_expression());
		}

		if (auto* simpleTerm = dynamic_cast<CSubsetParser::SimpleTermContext*>(ctx)) {
			return getTermText(simpleTerm->term());
		}

		if (auto* simpleBinary = dynamic_cast<CSubsetParser::SimpleBinaryContext*>(ctx)) {

			return getSimpleExpressionText(simpleBinary->simple_expression())
				+ simpleBinary->ADDOP()->getText()
				+ getTermText(simpleBinary->term());
		}

		return ctx->getText();
	}
	
    std::any visitEmptyExpressionStatement(CSubsetParser::EmptyExpressionStatementContext* ctx) override {
        logRule(ctx, "expression_statement : SEMICOLON");
        return {};
    }

    std::any visitExpressionStatement(CSubsetParser::ExpressionStatementContext* ctx) override {
        visitSafe(ctx->expression());
        logRule(ctx, "expression_statement : expression SEMICOLON");
        return {};
    }
	std::any visitExpressionStatementMissingSemicolon(CSubsetParser::ExpressionStatementMissingSemicolonContext* ctx) override {

		visitSafe(ctx->expression());

		std::string text = getExpressionText(ctx->expression());

		logSyntaxError(
			static_cast<int>(ctx->getStart()->getLine()),
			"syntax error, missing ';' after expression '" +
			text +
			"'"
		);

		openLogFile();

		logFile << "Line "
				<< ctx->getStart()->getLine()
				<< ": expression_statement : expression (missing SEMICOLON)\n\n";

		logFile << text << "\n\n";

		logFile.flush();

		return {};
	}
    std::any visitVarSimple(CSubsetParser::VarSimpleContext* ctx) override {
        std::string type = "undefined";

        SymbolInfo* symbol = symbolTable.lookup(ctx->ID()->getText());

        if (symbol == nullptr) {
            logError(ctx, "Undeclared variable " + ctx->ID()->getText());
        }
        else if(symbol->isFunction){
            logError(ctx, "Function "+ctx->ID()->getText()+" cannot be used as variable");
        }
        else if (symbol->isArray) {
            logError(ctx, "Type mismatch, " + ctx->ID()->getText() + " is an array");
        }
        else {
            type = symbol->getType();
        }

        logRule(ctx, "variable : ID");

        return type;
    }

    std::any visitVarArray(CSubsetParser::VarArrayContext* ctx) override {
        std::string indexType = visitType(ctx->expression());

        if(indexType != "int"){
            logError(ctx, "Expression inside third brackets not an integer");
        }

        std::string type = "undefined";

        SymbolInfo* symbol =
            symbolTable.lookup(ctx->ID()->getText());

        if (symbol == nullptr) {
            logError(ctx, "Undeclared variable " + ctx->ID()->getText());
        }
        else if (!symbol->isArray) {
            logError(ctx, ctx->ID()->getText() + " is not an array");
        }
        else {
            type = symbol->getType();
        }

        logRule(ctx, "variable : ID LTHIRD expression RTHIRD");

        return type;
    }

    std::any visitExpressionLogic(CSubsetParser::ExpressionLogicContext* ctx) override {
        std::string type = visitType(ctx->logic_expression());
        openLogFile();

        logFile << "Line "
                << ctx->getStart()->getLine()
                << ": expression : logic expression\n\n";

        logFile << getLogicExpressionText(ctx->logic_expression())
                << "\n\n";

        logFile.flush();

        return type;
    }

    std::any visitExpressionAssign(CSubsetParser::ExpressionAssignContext* ctx) override {
        std::string left=visitType(ctx->variable());
        std::string right=visitType(ctx->logic_expression());
        if(left == "undefined" || right == "undefined") {
            left = "undefined";
        }

        if (right == "void") {
                logError(ctx, "Void function used in expression");
        }
        if(left != "undefined" && right != "undefined"){
            if(left=="int" && right=="float"){
                logError(ctx, "Type Mismatch");
            }
        }

        openLogFile();

        logFile << "Line "
                << ctx->getStart()->getLine()
                << ": expression : variable ASSIGNOP logic_expression\n\n";

        logFile << getExpressionText(ctx)
                << "\n\n";

        logFile.flush();

        return left;
    }

    std::any visitLogicRel(CSubsetParser::LogicRelContext* ctx) override {
        std::string type = visitType(ctx->rel_expression());
        openLogFile();

        logFile << "Line "
                << ctx->getStart()->getLine()
                << ": logic_expression : rel_expression\n\n";

        logFile << getRelExpressionText(ctx->rel_expression())
                << "\n\n";

        logFile.flush();

        return type;
    }

    std::any visitLogicBinary(CSubsetParser::LogicBinaryContext* ctx) override {
        visitSafe(ctx->rel_expression(0));
        visitSafe(ctx->rel_expression(1));
        logRule(ctx, "logic_expression : rel_expression LOGICOP rel_expression");
        return std::string("int");
    }

    std::any visitRelSimple(CSubsetParser::RelSimpleContext* ctx) override {
        std::string type = visitType(ctx->simple_expression());
        openLogFile();

        logFile << "Line "
                << ctx->getStart()->getLine()
                << ": rel_expression : simple_expression\n\n";

        logFile << getSimpleExpressionText(ctx->simple_expression())
                << "\n\n";

        logFile.flush();

        return type;
    }

    std::any visitRelBinary(CSubsetParser::RelBinaryContext* ctx) override {
        std::string left = visitType(ctx->simple_expression(0));
        std::string right = visitType(ctx->simple_expression(1));
        logRule(ctx, "rel_expression : simple_expression RELOP simple_expression");
        return std::string("int");
    }

    std::any visitSimpleTerm(CSubsetParser::SimpleTermContext* ctx) override {
        std::string type = visitType(ctx->term());
        logRule(ctx, "simple_expression : term");
        return type;
    }

    std::any visitSimpleBinary(CSubsetParser::SimpleBinaryContext* ctx) override {
        std::string left = visitType(ctx->simple_expression());
        std::string right = visitType(ctx->term());
        std::string result;

        if(left=="float" || right=="float"){
            result="float";
        }else{
            result="int";
        }

        logRule(ctx, "simple_expression : simple_expression ADDOP term");
        return result;
    }

	std::any visitSimpleBadAssign(CSubsetParser::SimpleBadAssignContext* ctx) override {

	    std::string leftType = visitType(ctx->simple_expression());

	    logSyntaxError(
	        static_cast<int>(ctx->getStart()->getLine()),
	        "syntax error, invalid operand '=' after '" +
	        ctx->ADDOP()->getText() +
	        "'"
	    );

	    return leftType;
	}
	

    std::any visitTermUnary(CSubsetParser::TermUnaryContext* ctx) override {
        std::string type = visitType(ctx->unary_expression());
        logRule(ctx, "term : unary_expression");
        return type;
    }

    std::any visitTermBinary(CSubsetParser::TermBinaryContext* ctx) override {
        std::string left=visitType(ctx->term());
        std::string right=visitType(ctx->unary_expression());
        
        if(left=="void" || right=="void"){
            logError(ctx, "Void function used in expression");
            logRule(ctx, "term : term MULOP unary_expression");
            return std::string("undefined");
        }
        std::string op=ctx->MULOP()->getText();

        std::string result;

        if(op=="%"){
            if(left!="int" || right!="int"){
                logError(ctx, "Non-Integer operand on modulus operator");
            }
            if (ctx->unary_expression()->getText() == "0") {

                logError(ctx, "Modulus by Zero");
            }
            result = "int";
        }
        
        else
        {
            if(left=="float" || right=="float"){
                result="float";
            }else{
                result="int";
            }
        }    
        logRule(ctx, "term : term MULOP unary_expression");
        return result;
    }

    std::any visitUnaryAdd(CSubsetParser::UnaryAddContext* ctx) override {
        std::string type =visitType(ctx->unary_expression());
        
        logRule(ctx, "unary_expression : ADDOP unary_expression");
        return type;
    }

    std::any visitUnaryNot(CSubsetParser::UnaryNotContext* ctx) override {
        visitSafe(ctx->unary_expression());
        logRule(ctx, "unary_expression : NOT unary expression");
        return std::string("int");
    }

    std::any visitUnaryFactor(CSubsetParser::UnaryFactorContext* ctx) override {
        std::string type = visitType(ctx->factor());
        
        logRule(ctx, "unary_expression : factor");
        return type;
    }

    std::any visitFactorVariable(CSubsetParser::FactorVariableContext* ctx) override {
        std::string type =
            visitType(ctx->variable());
        logRule(ctx, "factor : variable");
        return type;
    }

    std::any visitFactorFuncCall(CSubsetParser::FactorFuncCallContext* ctx) override {
        std::vector<std::string> argTypes=visitTypes(ctx->argument_list());

        std::string name = ctx->ID()->getText();
        std::string type = "undefined";

        SymbolInfo* symbol =
            symbolTable.lookup(name);

        if (symbol == nullptr) {
            logError(ctx, "Undeclared function "+name);
        }
        else if (!symbol->isFunction) {
            logError(ctx, name + " is not a function");
        }
        else {
            type = symbol->functionInfo->returnType;
            std::vector<std::string> paramTypes = symbol->functionInfo->paramTypes; 

            if(argTypes.size() != paramTypes.size()){
                logError(ctx, "Total number of arguments mismatch in function " + name);
            }
            else{
                for(size_t i=0; i<argTypes.size(); i++){
                    if(argTypes[i]=="undefined"){
                        continue;
                    }
                    if(paramTypes[i] =="float" && argTypes[i]=="int"){
                        continue;
                    }

                    if(argTypes[i] != paramTypes[i]){
                        logError(ctx, std::to_string(i + 1) + "th argument mismatch in function " + name);
                    }
                    
                }
            }  
        }

        logRule(ctx, "factor : ID LPAREN argument_list RPAREN");

        return type;
    }

    std::any visitFactorParen(CSubsetParser::FactorParenContext* ctx) override {
        std::string type = visitType(ctx->expression());
        logRule(ctx, "factor : LPAREN expression RPAREN");
        return type;
    }

    std::any visitFactorConstInt(CSubsetParser::FactorConstIntContext* ctx) override {
        logRule(ctx, "factor : CONST_INT");
        return std::string("int");
    }

    std::any visitFactorConstFloat(CSubsetParser::FactorConstFloatContext* ctx) override {
        logRule(ctx, "factor : CONST_FLOAT");
        return std::string("float");
    }

    std::any visitFactorIncr(CSubsetParser::FactorIncrContext* ctx) override {
        std::string type =
            visitType(ctx->variable());
        logRule(ctx, "factor : variable INCOP");
        return type;
    }

    std::any visitFactorDecr(CSubsetParser::FactorDecrContext* ctx) override {
        std::string type =
            visitType(ctx->variable());
        logRule(ctx, "factor : variable DECOP");
        return type;
    }

    std::any visitArgListNonEmpty(CSubsetParser::ArgListNonEmptyContext* ctx) override {
        std::vector<std::string> types=visitTypes(ctx->arguments());
        logRule(ctx, "argument_list : arguments");
        return types;
    }

    std::any visitArgListEmpty(CSubsetParser::ArgListEmptyContext* ctx) override {
        logRule(ctx, "argument_list : ");
        return std::vector<std::string>{};
    }

    std::any visitArgsMulti(CSubsetParser::ArgsMultiContext* ctx) override {
        std::vector<std::string> types=visitTypes(ctx->arguments());
        std::string currentType=visitType(ctx->logic_expression());

        types.push_back(currentType);

        logRule(ctx, "arguments : arguments COMMA logic_expression");
        return types;
    }

    std::any visitArgsSingle(CSubsetParser::ArgsSingleContext* ctx) override {
        std::string type = visitType(ctx->logic_expression());
        std::vector<std::string> types;
        types.push_back(type);

        logRule(ctx, "arguments : logic_expression");
        return types;
    }
};

class CSubsetSyntaxErrorListener : public antlr4::BaseErrorListener {
public:
    CSubsetSyntaxErrorListener(CSubsetVisitorImpl* visitor)
        : visitor(visitor) {}

    void syntaxError(antlr4::Recognizer* /*recognizer*/,
                     antlr4::Token* /*offendingSymbol*/,
                     size_t line,
                     size_t /*charPositionInLine*/,
                     const std::string& msg,
                     std::exception_ptr /*e*/) override {
        if (visitor != nullptr) {
            visitor->logSyntaxError(
                static_cast<int>(line),
                "syntax error, " + msg
            );
        }
    }

private:
    CSubsetVisitorImpl* visitor;
};
