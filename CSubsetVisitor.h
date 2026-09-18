
// Generated from CSubset.g4 by ANTLR 4.13.2

#pragma once


#include "antlr4-runtime.h"
#include "CSubsetParser.h"



/**
 * This class defines an abstract visitor for a parse tree
 * produced by CSubsetParser.
 */
class  CSubsetVisitor : public antlr4::tree::AbstractParseTreeVisitor {
public:

  /**
   * Visit parse trees produced by CSubsetParser.
   */
    virtual std::any visitStart(CSubsetParser::StartContext *context) = 0;

    virtual std::any visitProgramBase(CSubsetParser::ProgramBaseContext *context) = 0;

    virtual std::any visitProgramRecursive(CSubsetParser::ProgramRecursiveContext *context) = 0;

    virtual std::any visitUnitVarDecl(CSubsetParser::UnitVarDeclContext *context) = 0;

    virtual std::any visitUnitFuncDecl(CSubsetParser::UnitFuncDeclContext *context) = 0;

    virtual std::any visitUnitFuncDef(CSubsetParser::UnitFuncDefContext *context) = 0;

    virtual std::any visitFuncDeclWithParams(CSubsetParser::FuncDeclWithParamsContext *context) = 0;

    virtual std::any visitFuncDeclNoParams(CSubsetParser::FuncDeclNoParamsContext *context) = 0;

    virtual std::any visitFuncDefWithParams(CSubsetParser::FuncDefWithParamsContext *context) = 0;

    virtual std::any visitFuncDefNoParams(CSubsetParser::FuncDefNoParamsContext *context) = 0;

    virtual std::any visitParamListBadNoId(CSubsetParser::ParamListBadNoIdContext *context) = 0;

    virtual std::any visitParamListWithId(CSubsetParser::ParamListWithIdContext *context) = 0;

    virtual std::any visitParamListTypeOnly(CSubsetParser::ParamListTypeOnlyContext *context) = 0;

    virtual std::any visitParamListSingle(CSubsetParser::ParamListSingleContext *context) = 0;

    virtual std::any visitParamListNoId(CSubsetParser::ParamListNoIdContext *context) = 0;

    virtual std::any visitCompoundWithStatements(CSubsetParser::CompoundWithStatementsContext *context) = 0;

    virtual std::any visitCompoundEmpty(CSubsetParser::CompoundEmptyContext *context) = 0;

    virtual std::any visitVar_declaration(CSubsetParser::Var_declarationContext *context) = 0;

    virtual std::any visitTypeInt(CSubsetParser::TypeIntContext *context) = 0;

    virtual std::any visitTypeFloat(CSubsetParser::TypeFloatContext *context) = 0;

    virtual std::any visitTypeVoid(CSubsetParser::TypeVoidContext *context) = 0;

    virtual std::any visitDeclListSingle(CSubsetParser::DeclListSingleContext *context) = 0;

    virtual std::any visitDeclListBadMinus(CSubsetParser::DeclListBadMinusContext *context) = 0;

    virtual std::any visitDeclListSingleArray(CSubsetParser::DeclListSingleArrayContext *context) = 0;

    virtual std::any visitDeclListMulti(CSubsetParser::DeclListMultiContext *context) = 0;

    virtual std::any visitDeclListMultiArray(CSubsetParser::DeclListMultiArrayContext *context) = 0;

    virtual std::any visitStatementsSingle(CSubsetParser::StatementsSingleContext *context) = 0;

    virtual std::any visitStatementsRecursive(CSubsetParser::StatementsRecursiveContext *context) = 0;

    virtual std::any visitStatementVarDecl(CSubsetParser::StatementVarDeclContext *context) = 0;

    virtual std::any visitStatementExpr(CSubsetParser::StatementExprContext *context) = 0;

    virtual std::any visitStatementCompound(CSubsetParser::StatementCompoundContext *context) = 0;

    virtual std::any visitStatementFor(CSubsetParser::StatementForContext *context) = 0;

    virtual std::any visitStatementIf(CSubsetParser::StatementIfContext *context) = 0;

    virtual std::any visitStatementIfElse(CSubsetParser::StatementIfElseContext *context) = 0;

    virtual std::any visitStatementWhile(CSubsetParser::StatementWhileContext *context) = 0;

    virtual std::any visitStatementPrintln(CSubsetParser::StatementPrintlnContext *context) = 0;

    virtual std::any visitStatementReturn(CSubsetParser::StatementReturnContext *context) = 0;

    virtual std::any visitEmptyExpressionStatement(CSubsetParser::EmptyExpressionStatementContext *context) = 0;

    virtual std::any visitExpressionStatement(CSubsetParser::ExpressionStatementContext *context) = 0;

    virtual std::any visitExpressionStatementMissingSemicolon(CSubsetParser::ExpressionStatementMissingSemicolonContext *context) = 0;

    virtual std::any visitVarSimple(CSubsetParser::VarSimpleContext *context) = 0;

    virtual std::any visitVarArray(CSubsetParser::VarArrayContext *context) = 0;

    virtual std::any visitExpressionLogic(CSubsetParser::ExpressionLogicContext *context) = 0;

    virtual std::any visitExpressionAssign(CSubsetParser::ExpressionAssignContext *context) = 0;

    virtual std::any visitLogicRel(CSubsetParser::LogicRelContext *context) = 0;

    virtual std::any visitLogicBinary(CSubsetParser::LogicBinaryContext *context) = 0;

    virtual std::any visitRelSimple(CSubsetParser::RelSimpleContext *context) = 0;

    virtual std::any visitRelBinary(CSubsetParser::RelBinaryContext *context) = 0;

    virtual std::any visitSimpleTerm(CSubsetParser::SimpleTermContext *context) = 0;

    virtual std::any visitSimpleBinary(CSubsetParser::SimpleBinaryContext *context) = 0;

    virtual std::any visitSimpleBadAssign(CSubsetParser::SimpleBadAssignContext *context) = 0;

    virtual std::any visitTermUnary(CSubsetParser::TermUnaryContext *context) = 0;

    virtual std::any visitTermBinary(CSubsetParser::TermBinaryContext *context) = 0;

    virtual std::any visitUnaryAdd(CSubsetParser::UnaryAddContext *context) = 0;

    virtual std::any visitUnaryNot(CSubsetParser::UnaryNotContext *context) = 0;

    virtual std::any visitUnaryFactor(CSubsetParser::UnaryFactorContext *context) = 0;

    virtual std::any visitFactorVariable(CSubsetParser::FactorVariableContext *context) = 0;

    virtual std::any visitFactorFuncCall(CSubsetParser::FactorFuncCallContext *context) = 0;

    virtual std::any visitFactorParen(CSubsetParser::FactorParenContext *context) = 0;

    virtual std::any visitFactorConstInt(CSubsetParser::FactorConstIntContext *context) = 0;

    virtual std::any visitFactorConstFloat(CSubsetParser::FactorConstFloatContext *context) = 0;

    virtual std::any visitFactorIncr(CSubsetParser::FactorIncrContext *context) = 0;

    virtual std::any visitFactorDecr(CSubsetParser::FactorDecrContext *context) = 0;

    virtual std::any visitArgListNonEmpty(CSubsetParser::ArgListNonEmptyContext *context) = 0;

    virtual std::any visitArgListEmpty(CSubsetParser::ArgListEmptyContext *context) = 0;

    virtual std::any visitArgsMulti(CSubsetParser::ArgsMultiContext *context) = 0;

    virtual std::any visitArgsSingle(CSubsetParser::ArgsSingleContext *context) = 0;


};

