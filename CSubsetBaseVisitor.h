
// Generated from CSubset.g4 by ANTLR 4.13.2

#pragma once


#include "antlr4-runtime.h"
#include "CSubsetVisitor.h"


/**
 * This class provides an empty implementation of CSubsetVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class  CSubsetBaseVisitor : public CSubsetVisitor {
public:

  virtual std::any visitStart(CSubsetParser::StartContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitProgramBase(CSubsetParser::ProgramBaseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitProgramRecursive(CSubsetParser::ProgramRecursiveContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnitVarDecl(CSubsetParser::UnitVarDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnitFuncDecl(CSubsetParser::UnitFuncDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnitFuncDef(CSubsetParser::UnitFuncDefContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFuncDeclWithParams(CSubsetParser::FuncDeclWithParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFuncDeclNoParams(CSubsetParser::FuncDeclNoParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFuncDefWithParams(CSubsetParser::FuncDefWithParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFuncDefNoParams(CSubsetParser::FuncDefNoParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamListBadNoId(CSubsetParser::ParamListBadNoIdContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamListWithId(CSubsetParser::ParamListWithIdContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamListTypeOnly(CSubsetParser::ParamListTypeOnlyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamListSingle(CSubsetParser::ParamListSingleContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamListNoId(CSubsetParser::ParamListNoIdContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitCompoundWithStatements(CSubsetParser::CompoundWithStatementsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitCompoundEmpty(CSubsetParser::CompoundEmptyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVar_declaration(CSubsetParser::Var_declarationContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeInt(CSubsetParser::TypeIntContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeFloat(CSubsetParser::TypeFloatContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeVoid(CSubsetParser::TypeVoidContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclListSingle(CSubsetParser::DeclListSingleContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclListBadMinus(CSubsetParser::DeclListBadMinusContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclListSingleArray(CSubsetParser::DeclListSingleArrayContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclListMulti(CSubsetParser::DeclListMultiContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclListMultiArray(CSubsetParser::DeclListMultiArrayContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementsSingle(CSubsetParser::StatementsSingleContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementsRecursive(CSubsetParser::StatementsRecursiveContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementVarDecl(CSubsetParser::StatementVarDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementExpr(CSubsetParser::StatementExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementCompound(CSubsetParser::StatementCompoundContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementFor(CSubsetParser::StatementForContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementIf(CSubsetParser::StatementIfContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementIfElse(CSubsetParser::StatementIfElseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementWhile(CSubsetParser::StatementWhileContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementPrintln(CSubsetParser::StatementPrintlnContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStatementReturn(CSubsetParser::StatementReturnContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitEmptyExpressionStatement(CSubsetParser::EmptyExpressionStatementContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExpressionStatement(CSubsetParser::ExpressionStatementContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExpressionStatementMissingSemicolon(CSubsetParser::ExpressionStatementMissingSemicolonContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarSimple(CSubsetParser::VarSimpleContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarArray(CSubsetParser::VarArrayContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExpressionLogic(CSubsetParser::ExpressionLogicContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExpressionAssign(CSubsetParser::ExpressionAssignContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLogicRel(CSubsetParser::LogicRelContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLogicBinary(CSubsetParser::LogicBinaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitRelSimple(CSubsetParser::RelSimpleContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitRelBinary(CSubsetParser::RelBinaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSimpleTerm(CSubsetParser::SimpleTermContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSimpleBinary(CSubsetParser::SimpleBinaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSimpleBadAssign(CSubsetParser::SimpleBadAssignContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTermUnary(CSubsetParser::TermUnaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTermBinary(CSubsetParser::TermBinaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnaryAdd(CSubsetParser::UnaryAddContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnaryNot(CSubsetParser::UnaryNotContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnaryFactor(CSubsetParser::UnaryFactorContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorVariable(CSubsetParser::FactorVariableContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorFuncCall(CSubsetParser::FactorFuncCallContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorParen(CSubsetParser::FactorParenContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorConstInt(CSubsetParser::FactorConstIntContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorConstFloat(CSubsetParser::FactorConstFloatContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorIncr(CSubsetParser::FactorIncrContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorDecr(CSubsetParser::FactorDecrContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgListNonEmpty(CSubsetParser::ArgListNonEmptyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgListEmpty(CSubsetParser::ArgListEmptyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgsMulti(CSubsetParser::ArgsMultiContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgsSingle(CSubsetParser::ArgsSingleContext *ctx) override {
    return visitChildren(ctx);
  }


};

