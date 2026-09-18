// Generated from c:/Users/sadma/Downloads/2205006 (1)/Compiler/CSubset.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSubsetParser}.
 */
public interface CSubsetListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CSubsetParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CSubsetParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSubsetParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CSubsetParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProgramBase}
	 * labeled alternative in {@link CSubsetParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramBase(CSubsetParser.ProgramBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramBase}
	 * labeled alternative in {@link CSubsetParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramBase(CSubsetParser.ProgramBaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProgramRecursive}
	 * labeled alternative in {@link CSubsetParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramRecursive(CSubsetParser.ProgramRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramRecursive}
	 * labeled alternative in {@link CSubsetParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramRecursive(CSubsetParser.ProgramRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnitVarDecl}
	 * labeled alternative in {@link CSubsetParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitVarDecl(CSubsetParser.UnitVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnitVarDecl}
	 * labeled alternative in {@link CSubsetParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitVarDecl(CSubsetParser.UnitVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnitFuncDecl}
	 * labeled alternative in {@link CSubsetParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitFuncDecl(CSubsetParser.UnitFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnitFuncDecl}
	 * labeled alternative in {@link CSubsetParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitFuncDecl(CSubsetParser.UnitFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnitFuncDef}
	 * labeled alternative in {@link CSubsetParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitFuncDef(CSubsetParser.UnitFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnitFuncDef}
	 * labeled alternative in {@link CSubsetParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitFuncDef(CSubsetParser.UnitFuncDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDeclWithParams}
	 * labeled alternative in {@link CSubsetParser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclWithParams(CSubsetParser.FuncDeclWithParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDeclWithParams}
	 * labeled alternative in {@link CSubsetParser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclWithParams(CSubsetParser.FuncDeclWithParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDeclNoParams}
	 * labeled alternative in {@link CSubsetParser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclNoParams(CSubsetParser.FuncDeclNoParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDeclNoParams}
	 * labeled alternative in {@link CSubsetParser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclNoParams(CSubsetParser.FuncDeclNoParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDefWithParams}
	 * labeled alternative in {@link CSubsetParser#func_definition}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefWithParams(CSubsetParser.FuncDefWithParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDefWithParams}
	 * labeled alternative in {@link CSubsetParser#func_definition}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefWithParams(CSubsetParser.FuncDefWithParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDefNoParams}
	 * labeled alternative in {@link CSubsetParser#func_definition}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefNoParams(CSubsetParser.FuncDefNoParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDefNoParams}
	 * labeled alternative in {@link CSubsetParser#func_definition}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefNoParams(CSubsetParser.FuncDefNoParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamListBadNoId}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParamListBadNoId(CSubsetParser.ParamListBadNoIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamListBadNoId}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParamListBadNoId(CSubsetParser.ParamListBadNoIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamListWithId}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParamListWithId(CSubsetParser.ParamListWithIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamListWithId}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParamListWithId(CSubsetParser.ParamListWithIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamListTypeOnly}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParamListTypeOnly(CSubsetParser.ParamListTypeOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamListTypeOnly}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParamListTypeOnly(CSubsetParser.ParamListTypeOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamListSingle}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParamListSingle(CSubsetParser.ParamListSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamListSingle}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParamListSingle(CSubsetParser.ParamListSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamListNoId}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParamListNoId(CSubsetParser.ParamListNoIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamListNoId}
	 * labeled alternative in {@link CSubsetParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParamListNoId(CSubsetParser.ParamListNoIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundWithStatements}
	 * labeled alternative in {@link CSubsetParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundWithStatements(CSubsetParser.CompoundWithStatementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundWithStatements}
	 * labeled alternative in {@link CSubsetParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundWithStatements(CSubsetParser.CompoundWithStatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundEmpty}
	 * labeled alternative in {@link CSubsetParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundEmpty(CSubsetParser.CompoundEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundEmpty}
	 * labeled alternative in {@link CSubsetParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundEmpty(CSubsetParser.CompoundEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSubsetParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(CSubsetParser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSubsetParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(CSubsetParser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link CSubsetParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(CSubsetParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link CSubsetParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(CSubsetParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeFloat}
	 * labeled alternative in {@link CSubsetParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeFloat(CSubsetParser.TypeFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeFloat}
	 * labeled alternative in {@link CSubsetParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeFloat(CSubsetParser.TypeFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeVoid}
	 * labeled alternative in {@link CSubsetParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeVoid(CSubsetParser.TypeVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeVoid}
	 * labeled alternative in {@link CSubsetParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeVoid(CSubsetParser.TypeVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclListSingle}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclListSingle(CSubsetParser.DeclListSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclListSingle}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclListSingle(CSubsetParser.DeclListSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclListBadMinus}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclListBadMinus(CSubsetParser.DeclListBadMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclListBadMinus}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclListBadMinus(CSubsetParser.DeclListBadMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclListSingleArray}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclListSingleArray(CSubsetParser.DeclListSingleArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclListSingleArray}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclListSingleArray(CSubsetParser.DeclListSingleArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclListMulti}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclListMulti(CSubsetParser.DeclListMultiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclListMulti}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclListMulti(CSubsetParser.DeclListMultiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclListMultiArray}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclListMultiArray(CSubsetParser.DeclListMultiArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclListMultiArray}
	 * labeled alternative in {@link CSubsetParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclListMultiArray(CSubsetParser.DeclListMultiArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementsSingle}
	 * labeled alternative in {@link CSubsetParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatementsSingle(CSubsetParser.StatementsSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementsSingle}
	 * labeled alternative in {@link CSubsetParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatementsSingle(CSubsetParser.StatementsSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementsRecursive}
	 * labeled alternative in {@link CSubsetParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatementsRecursive(CSubsetParser.StatementsRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementsRecursive}
	 * labeled alternative in {@link CSubsetParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatementsRecursive(CSubsetParser.StatementsRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementVarDecl}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementVarDecl(CSubsetParser.StatementVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementVarDecl}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementVarDecl(CSubsetParser.StatementVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpr}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpr(CSubsetParser.StatementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpr}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpr(CSubsetParser.StatementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementCompound}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementCompound(CSubsetParser.StatementCompoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementCompound}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementCompound(CSubsetParser.StatementCompoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementFor(CSubsetParser.StatementForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementFor(CSubsetParser.StatementForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIf(CSubsetParser.StatementIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIf(CSubsetParser.StatementIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIfElse}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIfElse(CSubsetParser.StatementIfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIfElse}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIfElse(CSubsetParser.StatementIfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhile(CSubsetParser.StatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhile(CSubsetParser.StatementWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementPrintln}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementPrintln(CSubsetParser.StatementPrintlnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementPrintln}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementPrintln(CSubsetParser.StatementPrintlnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementReturn(CSubsetParser.StatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link CSubsetParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementReturn(CSubsetParser.StatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyExpressionStatement}
	 * labeled alternative in {@link CSubsetParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyExpressionStatement(CSubsetParser.EmptyExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyExpressionStatement}
	 * labeled alternative in {@link CSubsetParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyExpressionStatement(CSubsetParser.EmptyExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link CSubsetParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CSubsetParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link CSubsetParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CSubsetParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStatementMissingSemicolon}
	 * labeled alternative in {@link CSubsetParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatementMissingSemicolon(CSubsetParser.ExpressionStatementMissingSemicolonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStatementMissingSemicolon}
	 * labeled alternative in {@link CSubsetParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatementMissingSemicolon(CSubsetParser.ExpressionStatementMissingSemicolonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarSimple}
	 * labeled alternative in {@link CSubsetParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVarSimple(CSubsetParser.VarSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarSimple}
	 * labeled alternative in {@link CSubsetParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVarSimple(CSubsetParser.VarSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarArray}
	 * labeled alternative in {@link CSubsetParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVarArray(CSubsetParser.VarArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarArray}
	 * labeled alternative in {@link CSubsetParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVarArray(CSubsetParser.VarArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionLogic}
	 * labeled alternative in {@link CSubsetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionLogic(CSubsetParser.ExpressionLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionLogic}
	 * labeled alternative in {@link CSubsetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionLogic(CSubsetParser.ExpressionLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssign}
	 * labeled alternative in {@link CSubsetParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssign(CSubsetParser.ExpressionAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssign}
	 * labeled alternative in {@link CSubsetParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssign(CSubsetParser.ExpressionAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicRel}
	 * labeled alternative in {@link CSubsetParser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicRel(CSubsetParser.LogicRelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicRel}
	 * labeled alternative in {@link CSubsetParser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicRel(CSubsetParser.LogicRelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicBinary}
	 * labeled alternative in {@link CSubsetParser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicBinary(CSubsetParser.LogicBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicBinary}
	 * labeled alternative in {@link CSubsetParser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicBinary(CSubsetParser.LogicBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelSimple}
	 * labeled alternative in {@link CSubsetParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelSimple(CSubsetParser.RelSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelSimple}
	 * labeled alternative in {@link CSubsetParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelSimple(CSubsetParser.RelSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelBinary}
	 * labeled alternative in {@link CSubsetParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelBinary(CSubsetParser.RelBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelBinary}
	 * labeled alternative in {@link CSubsetParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelBinary(CSubsetParser.RelBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleTerm}
	 * labeled alternative in {@link CSubsetParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTerm(CSubsetParser.SimpleTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleTerm}
	 * labeled alternative in {@link CSubsetParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTerm(CSubsetParser.SimpleTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleBinary}
	 * labeled alternative in {@link CSubsetParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleBinary(CSubsetParser.SimpleBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleBinary}
	 * labeled alternative in {@link CSubsetParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleBinary(CSubsetParser.SimpleBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleBadAssign}
	 * labeled alternative in {@link CSubsetParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleBadAssign(CSubsetParser.SimpleBadAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleBadAssign}
	 * labeled alternative in {@link CSubsetParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleBadAssign(CSubsetParser.SimpleBadAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermUnary}
	 * labeled alternative in {@link CSubsetParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermUnary(CSubsetParser.TermUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermUnary}
	 * labeled alternative in {@link CSubsetParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermUnary(CSubsetParser.TermUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermBinary}
	 * labeled alternative in {@link CSubsetParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermBinary(CSubsetParser.TermBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermBinary}
	 * labeled alternative in {@link CSubsetParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermBinary(CSubsetParser.TermBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryAdd}
	 * labeled alternative in {@link CSubsetParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAdd(CSubsetParser.UnaryAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryAdd}
	 * labeled alternative in {@link CSubsetParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAdd(CSubsetParser.UnaryAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryNot}
	 * labeled alternative in {@link CSubsetParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNot(CSubsetParser.UnaryNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryNot}
	 * labeled alternative in {@link CSubsetParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNot(CSubsetParser.UnaryNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryFactor}
	 * labeled alternative in {@link CSubsetParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryFactor(CSubsetParser.UnaryFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryFactor}
	 * labeled alternative in {@link CSubsetParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryFactor(CSubsetParser.UnaryFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorVariable}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorVariable(CSubsetParser.FactorVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorVariable}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorVariable(CSubsetParser.FactorVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorFuncCall}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorFuncCall(CSubsetParser.FactorFuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorFuncCall}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorFuncCall(CSubsetParser.FactorFuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorParen}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorParen(CSubsetParser.FactorParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorParen}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorParen(CSubsetParser.FactorParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorConstInt}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorConstInt(CSubsetParser.FactorConstIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorConstInt}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorConstInt(CSubsetParser.FactorConstIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorConstFloat}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorConstFloat(CSubsetParser.FactorConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorConstFloat}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorConstFloat(CSubsetParser.FactorConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorIncr}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorIncr(CSubsetParser.FactorIncrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorIncr}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorIncr(CSubsetParser.FactorIncrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorDecr}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorDecr(CSubsetParser.FactorDecrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorDecr}
	 * labeled alternative in {@link CSubsetParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorDecr(CSubsetParser.FactorDecrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgListNonEmpty}
	 * labeled alternative in {@link CSubsetParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgListNonEmpty(CSubsetParser.ArgListNonEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgListNonEmpty}
	 * labeled alternative in {@link CSubsetParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgListNonEmpty(CSubsetParser.ArgListNonEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgListEmpty}
	 * labeled alternative in {@link CSubsetParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgListEmpty(CSubsetParser.ArgListEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgListEmpty}
	 * labeled alternative in {@link CSubsetParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgListEmpty(CSubsetParser.ArgListEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgsMulti}
	 * labeled alternative in {@link CSubsetParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArgsMulti(CSubsetParser.ArgsMultiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgsMulti}
	 * labeled alternative in {@link CSubsetParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArgsMulti(CSubsetParser.ArgsMultiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgsSingle}
	 * labeled alternative in {@link CSubsetParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArgsSingle(CSubsetParser.ArgsSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgsSingle}
	 * labeled alternative in {@link CSubsetParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArgsSingle(CSubsetParser.ArgsSingleContext ctx);
}