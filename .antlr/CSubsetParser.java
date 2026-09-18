// Generated from c:/Users/sadma/Downloads/2205006 (1)/Compiler/CSubset.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CSubsetParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, ELSE=6, FOR=7, 
		WHILE=8, PRINTLN=9, RETURN=10, INT=11, FLOAT=12, VOID=13, LPAREN=14, RPAREN=15, 
		LCURL=16, RCURL=17, LTHIRD=18, RTHIRD=19, SEMICOLON=20, COMMA=21, ADDOP=22, 
		MULOP=23, INCOP=24, DECOP=25, NOT=26, RELOP=27, LOGICOP=28, ASSIGNOP=29, 
		ID=30, CONST_INT=31, CONST_FLOAT=32;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_type_specifier = 8, RULE_declaration_list = 9, 
		RULE_statements = 10, RULE_statement = 11, RULE_expression_statement = 12, 
		RULE_variable = 13, RULE_expression = 14, RULE_logic_expression = 15, 
		RULE_rel_expression = 16, RULE_simple_expression = 17, RULE_term = 18, 
		RULE_unary_expression = 19, RULE_factor = 20, RULE_argument_list = 21, 
		RULE_arguments = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "type_specifier", "declaration_list", 
			"statements", "statement", "expression_statement", "variable", "expression", 
			"logic_expression", "rel_expression", "simple_expression", "term", "unary_expression", 
			"factor", "argument_list", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'else'", "'for'", "'while'", "'println'", 
			"'return'", "'int'", "'float'", "'void'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "';'", "','", null, null, "'++'", "'--'", "'!'", null, 
			null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"FOR", "WHILE", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "LPAREN", 
			"RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COMMA", 
			"ADDOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", "ASSIGNOP", 
			"ID", "CONST_INT", "CONST_FLOAT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CSubset.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CSubsetParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			program(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramBaseContext extends ProgramContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ProgramBaseContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterProgramBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitProgramBase(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramRecursiveContext extends ProgramContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ProgramRecursiveContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterProgramRecursive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitProgramRecursive(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ProgramBaseContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(49);
			unit();
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramRecursiveContext(new ProgramContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(51);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(52);
					unit();
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitContext extends ParserRuleContext {
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	 
		public UnitContext() { }
		public void copyFrom(UnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnitVarDeclContext extends UnitContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public UnitVarDeclContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterUnitVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitUnitVarDecl(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnitFuncDefContext extends UnitContext {
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public UnitFuncDefContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterUnitFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitUnitFuncDef(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnitFuncDeclContext extends UnitContext {
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public UnitFuncDeclContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterUnitFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitUnitFuncDecl(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unit);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new UnitVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				var_declaration();
				}
				break;
			case 2:
				_localctx = new UnitFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				func_declaration();
				}
				break;
			case 3:
				_localctx = new UnitFuncDefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				func_definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_declarationContext extends ParserRuleContext {
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
	 
		public Func_declarationContext() { }
		public void copyFrom(Func_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclWithParamsContext extends Func_declarationContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public FuncDeclWithParamsContext(Func_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFuncDeclWithParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFuncDeclWithParams(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclNoParamsContext extends Func_declarationContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public FuncDeclNoParamsContext(Func_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFuncDeclNoParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFuncDeclNoParams(this);
		}
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FuncDeclWithParamsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				type_specifier();
				setState(64);
				match(ID);
				setState(65);
				match(LPAREN);
				setState(66);
				parameter_list(0);
				setState(67);
				match(RPAREN);
				setState(68);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new FuncDeclNoParamsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				type_specifier();
				setState(71);
				match(ID);
				setState(72);
				match(LPAREN);
				setState(73);
				match(RPAREN);
				setState(74);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
	 
		public Func_definitionContext() { }
		public void copyFrom(Func_definitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefNoParamsContext extends Func_definitionContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public FuncDefNoParamsContext(Func_definitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFuncDefNoParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFuncDefNoParams(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefWithParamsContext extends Func_definitionContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public FuncDefWithParamsContext(Func_definitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFuncDefWithParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFuncDefWithParams(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new FuncDefWithParamsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				type_specifier();
				setState(79);
				match(ID);
				setState(80);
				match(LPAREN);
				setState(81);
				parameter_list(0);
				setState(82);
				match(RPAREN);
				setState(83);
				compound_statement();
				}
				break;
			case 2:
				_localctx = new FuncDefNoParamsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				type_specifier();
				setState(86);
				match(ID);
				setState(87);
				match(LPAREN);
				setState(88);
				match(RPAREN);
				setState(89);
				compound_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	 
		public Parameter_listContext() { }
		public void copyFrom(Parameter_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListBadNoIdContext extends Parameter_listContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(CSubsetParser.ADDOP, 0); }
		public ParamListBadNoIdContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterParamListBadNoId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitParamListBadNoId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListWithIdContext extends Parameter_listContext {
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CSubsetParser.COMMA, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public ParamListWithIdContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterParamListWithId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitParamListWithId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListTypeOnlyContext extends Parameter_listContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public ParamListTypeOnlyContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterParamListTypeOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitParamListTypeOnly(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListSingleContext extends Parameter_listContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public ParamListSingleContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterParamListSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitParamListSingle(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListNoIdContext extends Parameter_listContext {
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CSubsetParser.COMMA, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public ParamListNoIdContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterParamListNoId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitParamListNoId(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new ParamListSingleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(94);
				type_specifier();
				setState(95);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new ParamListTypeOnlyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				type_specifier();
				}
				break;
			case 3:
				{
				_localctx = new ParamListBadNoIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				type_specifier();
				setState(99);
				match(ADDOP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ParamListWithIdContext(new Parameter_listContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(104);
						match(COMMA);
						setState(105);
						type_specifier();
						setState(106);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new ParamListNoIdContext(new Parameter_listContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(108);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(109);
						match(COMMA);
						setState(110);
						type_specifier();
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_statementContext extends ParserRuleContext {
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	 
		public Compound_statementContext() { }
		public void copyFrom(Compound_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundWithStatementsContext extends Compound_statementContext {
		public TerminalNode LCURL() { return getToken(CSubsetParser.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(CSubsetParser.RCURL, 0); }
		public CompoundWithStatementsContext(Compound_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterCompoundWithStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitCompoundWithStatements(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundEmptyContext extends Compound_statementContext {
		public TerminalNode LCURL() { return getToken(CSubsetParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(CSubsetParser.RCURL, 0); }
		public CompoundEmptyContext(Compound_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterCompoundEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitCompoundEmpty(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new CompoundWithStatementsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(LCURL);
				setState(117);
				statements(0);
				setState(118);
				match(RCURL);
				}
				break;
			case 2:
				_localctx = new CompoundEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(LCURL);
				setState(121);
				match(RCURL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declarationContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterVar_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitVar_declaration(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			type_specifier();
			setState(125);
			declaration_list(0);
			setState(126);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
	 
		public Type_specifierContext() { }
		public void copyFrom(Type_specifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeFloatContext extends Type_specifierContext {
		public TerminalNode FLOAT() { return getToken(CSubsetParser.FLOAT, 0); }
		public TypeFloatContext(Type_specifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterTypeFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitTypeFloat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeVoidContext extends Type_specifierContext {
		public TerminalNode VOID() { return getToken(CSubsetParser.VOID, 0); }
		public TypeVoidContext(Type_specifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterTypeVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitTypeVoid(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeIntContext extends Type_specifierContext {
		public TerminalNode INT() { return getToken(CSubsetParser.INT, 0); }
		public TypeIntContext(Type_specifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitTypeInt(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type_specifier);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new TypeFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(FLOAT);
				}
				break;
			case VOID:
				_localctx = new TypeVoidContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_listContext extends ParserRuleContext {
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
	 
		public Declaration_listContext() { }
		public void copyFrom(Declaration_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclListSingleContext extends Declaration_listContext {
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public DeclListSingleContext(Declaration_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterDeclListSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitDeclListSingle(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclListBadMinusContext extends Declaration_listContext {
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(CSubsetParser.ADDOP, 0); }
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public DeclListBadMinusContext(Declaration_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterDeclListBadMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitDeclListBadMinus(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclListSingleArrayContext extends Declaration_listContext {
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(CSubsetParser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(CSubsetParser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(CSubsetParser.RTHIRD, 0); }
		public DeclListSingleArrayContext(Declaration_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterDeclListSingleArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitDeclListSingleArray(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclListMultiContext extends Declaration_listContext {
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CSubsetParser.COMMA, 0); }
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public DeclListMultiContext(Declaration_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterDeclListMulti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitDeclListMulti(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclListMultiArrayContext extends Declaration_listContext {
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CSubsetParser.COMMA, 0); }
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(CSubsetParser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(CSubsetParser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(CSubsetParser.RTHIRD, 0); }
		public DeclListMultiArrayContext(Declaration_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterDeclListMultiArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitDeclListMultiArray(this);
		}
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new DeclListSingleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new DeclListSingleArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(ID);
				setState(136);
				match(LTHIRD);
				setState(137);
				match(CONST_INT);
				setState(138);
				match(RTHIRD);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new DeclListMultiContext(new Declaration_listContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(141);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(142);
						match(COMMA);
						setState(143);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new DeclListMultiArrayContext(new Declaration_listContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(144);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(145);
						match(COMMA);
						setState(146);
						match(ID);
						setState(147);
						match(LTHIRD);
						setState(148);
						match(CONST_INT);
						setState(149);
						match(RTHIRD);
						}
						break;
					case 3:
						{
						_localctx = new DeclListBadMinusContext(new Declaration_listContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(150);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(151);
						match(ADDOP);
						setState(152);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementsSingleContext extends StatementsContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsSingleContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementsSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementsSingle(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementsRecursiveContext extends StatementsContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsRecursiveContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementsRecursive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementsRecursive(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new StatementsSingleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(159);
			statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsRecursiveContext(new StatementsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(161);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(162);
					statement();
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementIfContext extends StatementContext {
		public TerminalNode IF() { return getToken(CSubsetParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementForContext extends StatementContext {
		public TerminalNode FOR() { return getToken(CSubsetParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementFor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(CSubsetParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementReturn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementExprContext extends StatementContext {
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public StatementExprContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementWhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(CSubsetParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementWhile(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementCompoundContext extends StatementContext {
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public StatementCompoundContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementCompound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementCompound(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementPrintlnContext extends StatementContext {
		public TerminalNode PRINTLN() { return getToken(CSubsetParser.PRINTLN, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public StatementPrintlnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementPrintln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementPrintln(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementVarDeclContext extends StatementContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public StatementVarDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementVarDecl(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementIfElseContext extends StatementContext {
		public TerminalNode IF() { return getToken(CSubsetParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CSubsetParser.ELSE, 0); }
		public StatementIfElseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterStatementIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitStatementIfElse(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new StatementVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				var_declaration();
				}
				break;
			case 2:
				_localctx = new StatementExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				expression_statement();
				}
				break;
			case 3:
				_localctx = new StatementCompoundContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				compound_statement();
				}
				break;
			case 4:
				_localctx = new StatementForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				match(FOR);
				setState(172);
				match(LPAREN);
				setState(173);
				expression_statement();
				setState(174);
				expression_statement();
				setState(175);
				expression();
				setState(176);
				match(RPAREN);
				setState(177);
				statement();
				}
				break;
			case 5:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(IF);
				setState(180);
				match(LPAREN);
				setState(181);
				expression();
				setState(182);
				match(RPAREN);
				setState(183);
				statement();
				}
				break;
			case 6:
				_localctx = new StatementIfElseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				match(IF);
				setState(186);
				match(LPAREN);
				setState(187);
				expression();
				setState(188);
				match(RPAREN);
				setState(189);
				statement();
				setState(190);
				match(ELSE);
				setState(191);
				statement();
				}
				break;
			case 7:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(193);
				match(WHILE);
				setState(194);
				match(LPAREN);
				setState(195);
				expression();
				setState(196);
				match(RPAREN);
				setState(197);
				statement();
				}
				break;
			case 8:
				_localctx = new StatementPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(199);
				match(PRINTLN);
				setState(200);
				match(LPAREN);
				setState(201);
				match(ID);
				setState(202);
				match(RPAREN);
				setState(203);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(204);
				match(RETURN);
				setState(205);
				expression();
				setState(206);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
	 
		public Expression_statementContext() { }
		public void copyFrom(Expression_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyExpressionStatementContext extends Expression_statementContext {
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public EmptyExpressionStatementContext(Expression_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterEmptyExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitEmptyExpressionStatement(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends Expression_statementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CSubsetParser.SEMICOLON, 0); }
		public ExpressionStatementContext(Expression_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitExpressionStatement(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementMissingSemicolonContext extends Expression_statementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementMissingSemicolonContext(Expression_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterExpressionStatementMissingSemicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitExpressionStatementMissingSemicolon(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression_statement);
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new EmptyExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				expression();
				setState(212);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ExpressionStatementMissingSemicolonContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	 
		public VariableContext() { }
		public void copyFrom(VariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarArrayContext extends VariableContext {
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(CSubsetParser.LTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RTHIRD() { return getToken(CSubsetParser.RTHIRD, 0); }
		public VarArrayContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterVarArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitVarArray(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarSimpleContext extends VariableContext {
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public VarSimpleContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterVarSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitVarSimple(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new VarSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(ID);
				}
				break;
			case 2:
				_localctx = new VarArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(ID);
				setState(219);
				match(LTHIRD);
				setState(220);
				expression();
				setState(221);
				match(RTHIRD);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionLogicContext extends ExpressionContext {
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ExpressionLogicContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterExpressionLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitExpressionLogic(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionAssignContext extends ExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(CSubsetParser.ASSIGNOP, 0); }
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ExpressionAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterExpressionAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitExpressionAssign(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression);
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new ExpressionLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				logic_expression();
				}
				break;
			case 2:
				_localctx = new ExpressionAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				variable();
				setState(227);
				match(ASSIGNOP);
				setState(228);
				logic_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_expressionContext extends ParserRuleContext {
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
	 
		public Logic_expressionContext() { }
		public void copyFrom(Logic_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicBinaryContext extends Logic_expressionContext {
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public TerminalNode LOGICOP() { return getToken(CSubsetParser.LOGICOP, 0); }
		public LogicBinaryContext(Logic_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterLogicBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitLogicBinary(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicRelContext extends Logic_expressionContext {
		public Rel_expressionContext rel_expression() {
			return getRuleContext(Rel_expressionContext.class,0);
		}
		public LogicRelContext(Logic_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterLogicRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitLogicRel(this);
		}
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logic_expression);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new LogicRelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				rel_expression();
				}
				break;
			case 2:
				_localctx = new LogicBinaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				rel_expression();
				setState(234);
				match(LOGICOP);
				setState(235);
				rel_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rel_expressionContext extends ParserRuleContext {
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
	 
		public Rel_expressionContext() { }
		public void copyFrom(Rel_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelBinaryContext extends Rel_expressionContext {
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(CSubsetParser.RELOP, 0); }
		public RelBinaryContext(Rel_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterRelBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitRelBinary(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelSimpleContext extends Rel_expressionContext {
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public RelSimpleContext(Rel_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterRelSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitRelSimple(this);
		}
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rel_expression);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new RelSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				simple_expression(0);
				}
				break;
			case 2:
				_localctx = new RelBinaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				simple_expression(0);
				setState(241);
				match(RELOP);
				setState(242);
				simple_expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_expressionContext extends ParserRuleContext {
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
	 
		public Simple_expressionContext() { }
		public void copyFrom(Simple_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTermContext extends Simple_expressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SimpleTermContext(Simple_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterSimpleTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitSimpleTerm(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleBinaryContext extends Simple_expressionContext {
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(CSubsetParser.ADDOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SimpleBinaryContext(Simple_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterSimpleBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitSimpleBinary(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleBadAssignContext extends Simple_expressionContext {
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(CSubsetParser.ADDOP, 0); }
		public TerminalNode ASSIGNOP() { return getToken(CSubsetParser.ASSIGNOP, 0); }
		public SimpleBadAssignContext(Simple_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterSimpleBadAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitSimpleBadAssign(this);
		}
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		return simple_expression(0);
	}

	private Simple_expressionContext simple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, _parentState);
		Simple_expressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(247);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(255);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new SimpleBinaryContext(new Simple_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
						setState(249);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(250);
						match(ADDOP);
						setState(251);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new SimpleBadAssignContext(new Simple_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
						setState(252);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(253);
						match(ADDOP);
						setState(254);
						match(ASSIGNOP);
						}
						break;
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermUnaryContext extends TermContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TermUnaryContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterTermUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitTermUnary(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermBinaryContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(CSubsetParser.MULOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TermBinaryContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterTermBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitTermBinary(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermUnaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(261);
			unary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermBinaryContext(new TermContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(263);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(264);
					match(MULOP);
					setState(265);
					unary_expression();
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	 
		public Unary_expressionContext() { }
		public void copyFrom(Unary_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryNotContext extends Unary_expressionContext {
		public TerminalNode NOT() { return getToken(CSubsetParser.NOT, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public UnaryNotContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterUnaryNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitUnaryNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryFactorContext extends Unary_expressionContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public UnaryFactorContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterUnaryFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitUnaryFactor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryAddContext extends Unary_expressionContext {
		public TerminalNode ADDOP() { return getToken(CSubsetParser.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public UnaryAddContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterUnaryAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitUnaryAdd(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unary_expression);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				_localctx = new UnaryAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				match(ADDOP);
				setState(272);
				unary_expression();
				}
				break;
			case NOT:
				_localctx = new UnaryNotContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(NOT);
				setState(274);
				unary_expression();
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				_localctx = new UnaryFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorFuncCallContext extends FactorContext {
		public TerminalNode ID() { return getToken(CSubsetParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public FactorFuncCallContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorFuncCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorConstFloatContext extends FactorContext {
		public TerminalNode CONST_FLOAT() { return getToken(CSubsetParser.CONST_FLOAT, 0); }
		public FactorConstFloatContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorConstFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorConstFloat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorVariableContext extends FactorContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FactorVariableContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorVariable(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorDecrContext extends FactorContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode DECOP() { return getToken(CSubsetParser.DECOP, 0); }
		public FactorDecrContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorDecr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorDecr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorParenContext extends FactorContext {
		public TerminalNode LPAREN() { return getToken(CSubsetParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CSubsetParser.RPAREN, 0); }
		public FactorParenContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorParen(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorConstIntContext extends FactorContext {
		public TerminalNode CONST_INT() { return getToken(CSubsetParser.CONST_INT, 0); }
		public FactorConstIntContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorConstInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorConstInt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorIncrContext extends FactorContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode INCOP() { return getToken(CSubsetParser.INCOP, 0); }
		public FactorIncrContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterFactorIncr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitFactorIncr(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_factor);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new FactorVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				variable();
				}
				break;
			case 2:
				_localctx = new FactorFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(ID);
				setState(280);
				match(LPAREN);
				setState(281);
				argument_list();
				setState(282);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new FactorParenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(LPAREN);
				setState(285);
				expression();
				setState(286);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new FactorConstIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				match(CONST_INT);
				}
				break;
			case 5:
				_localctx = new FactorConstFloatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(289);
				match(CONST_FLOAT);
				}
				break;
			case 6:
				_localctx = new FactorIncrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(290);
				variable();
				setState(291);
				match(INCOP);
				}
				break;
			case 7:
				_localctx = new FactorDecrContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(293);
				variable();
				setState(294);
				match(DECOP);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_listContext extends ParserRuleContext {
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
	 
		public Argument_listContext() { }
		public void copyFrom(Argument_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgListEmptyContext extends Argument_listContext {
		public ArgListEmptyContext(Argument_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterArgListEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitArgListEmpty(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgListNonEmptyContext extends Argument_listContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArgListNonEmptyContext(Argument_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterArgListNonEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitArgListNonEmpty(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_argument_list);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				_localctx = new ArgListNonEmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				arguments(0);
				}
				break;
			case RPAREN:
				_localctx = new ArgListEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgsMultiContext extends ArgumentsContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CSubsetParser.COMMA, 0); }
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ArgsMultiContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterArgsMulti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitArgsMulti(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgsSingleContext extends ArgumentsContext {
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ArgsSingleContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).enterArgsSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSubsetListener ) ((CSubsetListener)listener).exitArgsSingle(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArgsSingleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(303);
			logic_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsMultiContext(new ArgumentsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(305);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(306);
					match(COMMA);
					setState(307);
					logic_expression();
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 5:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 9:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 10:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 17:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 18:
			return term_sempred((TermContext)_localctx, predIndex);
		case 22:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u013a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u0001"+
		"9\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003M\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005f\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005p\b\u0005\n\u0005\f\u0005s\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006{\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u0084\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008c"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u009a\b\t\n\t\f\t\u009d\t\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a4\b\n\n\n\f\n\u00a7\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d1\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d8\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e0\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00e7\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00ee\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00f5"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0100\b\u0011\n"+
		"\u0011\f\u0011\u0103\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u010b\b\u0012\n\u0012\f\u0012"+
		"\u010e\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0115\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u0129\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u012d\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u0135\b\u0016\n\u0016\f\u0016\u0138"+
		"\t\u0016\u0001\u0016\u0000\u0007\u0002\n\u0012\u0014\"$,\u0017\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,\u0000\u0000\u014e\u0000.\u0001\u0000\u0000\u0000\u00020\u0001"+
		"\u0000\u0000\u0000\u0004=\u0001\u0000\u0000\u0000\u0006L\u0001\u0000\u0000"+
		"\u0000\b[\u0001\u0000\u0000\u0000\ne\u0001\u0000\u0000\u0000\fz\u0001"+
		"\u0000\u0000\u0000\u000e|\u0001\u0000\u0000\u0000\u0010\u0083\u0001\u0000"+
		"\u0000\u0000\u0012\u008b\u0001\u0000\u0000\u0000\u0014\u009e\u0001\u0000"+
		"\u0000\u0000\u0016\u00d0\u0001\u0000\u0000\u0000\u0018\u00d7\u0001\u0000"+
		"\u0000\u0000\u001a\u00df\u0001\u0000\u0000\u0000\u001c\u00e6\u0001\u0000"+
		"\u0000\u0000\u001e\u00ed\u0001\u0000\u0000\u0000 \u00f4\u0001\u0000\u0000"+
		"\u0000\"\u00f6\u0001\u0000\u0000\u0000$\u0104\u0001\u0000\u0000\u0000"+
		"&\u0114\u0001\u0000\u0000\u0000(\u0128\u0001\u0000\u0000\u0000*\u012c"+
		"\u0001\u0000\u0000\u0000,\u012e\u0001\u0000\u0000\u0000./\u0003\u0002"+
		"\u0001\u0000/\u0001\u0001\u0000\u0000\u000001\u0006\u0001\uffff\uffff"+
		"\u000012\u0003\u0004\u0002\u000027\u0001\u0000\u0000\u000034\n\u0002\u0000"+
		"\u000046\u0003\u0004\u0002\u000053\u0001\u0000\u0000\u000069\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u0003"+
		"\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:>\u0003\u000e\u0007"+
		"\u0000;>\u0003\u0006\u0003\u0000<>\u0003\b\u0004\u0000=:\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>\u0005\u0001"+
		"\u0000\u0000\u0000?@\u0003\u0010\b\u0000@A\u0005\u001e\u0000\u0000AB\u0005"+
		"\u000e\u0000\u0000BC\u0003\n\u0005\u0000CD\u0005\u000f\u0000\u0000DE\u0005"+
		"\u0014\u0000\u0000EM\u0001\u0000\u0000\u0000FG\u0003\u0010\b\u0000GH\u0005"+
		"\u001e\u0000\u0000HI\u0005\u000e\u0000\u0000IJ\u0005\u000f\u0000\u0000"+
		"JK\u0005\u0014\u0000\u0000KM\u0001\u0000\u0000\u0000L?\u0001\u0000\u0000"+
		"\u0000LF\u0001\u0000\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0003"+
		"\u0010\b\u0000OP\u0005\u001e\u0000\u0000PQ\u0005\u000e\u0000\u0000QR\u0003"+
		"\n\u0005\u0000RS\u0005\u000f\u0000\u0000ST\u0003\f\u0006\u0000T\\\u0001"+
		"\u0000\u0000\u0000UV\u0003\u0010\b\u0000VW\u0005\u001e\u0000\u0000WX\u0005"+
		"\u000e\u0000\u0000XY\u0005\u000f\u0000\u0000YZ\u0003\f\u0006\u0000Z\\"+
		"\u0001\u0000\u0000\u0000[N\u0001\u0000\u0000\u0000[U\u0001\u0000\u0000"+
		"\u0000\\\t\u0001\u0000\u0000\u0000]^\u0006\u0005\uffff\uffff\u0000^_\u0003"+
		"\u0010\b\u0000_`\u0005\u001e\u0000\u0000`f\u0001\u0000\u0000\u0000af\u0003"+
		"\u0010\b\u0000bc\u0003\u0010\b\u0000cd\u0005\u0016\u0000\u0000df\u0001"+
		"\u0000\u0000\u0000e]\u0001\u0000\u0000\u0000ea\u0001\u0000\u0000\u0000"+
		"eb\u0001\u0000\u0000\u0000fq\u0001\u0000\u0000\u0000gh\n\u0005\u0000\u0000"+
		"hi\u0005\u0015\u0000\u0000ij\u0003\u0010\b\u0000jk\u0005\u001e\u0000\u0000"+
		"kp\u0001\u0000\u0000\u0000lm\n\u0004\u0000\u0000mn\u0005\u0015\u0000\u0000"+
		"np\u0003\u0010\b\u0000og\u0001\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000"+
		"ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000r\u000b\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005"+
		"\u0010\u0000\u0000uv\u0003\u0014\n\u0000vw\u0005\u0011\u0000\u0000w{\u0001"+
		"\u0000\u0000\u0000xy\u0005\u0010\u0000\u0000y{\u0005\u0011\u0000\u0000"+
		"zt\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{\r\u0001\u0000\u0000"+
		"\u0000|}\u0003\u0010\b\u0000}~\u0003\u0012\t\u0000~\u007f\u0005\u0014"+
		"\u0000\u0000\u007f\u000f\u0001\u0000\u0000\u0000\u0080\u0084\u0005\u000b"+
		"\u0000\u0000\u0081\u0084\u0005\f\u0000\u0000\u0082\u0084\u0005\r\u0000"+
		"\u0000\u0083\u0080\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000"+
		"\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0011\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0006\t\uffff\uffff\u0000\u0086\u008c\u0005\u001e\u0000"+
		"\u0000\u0087\u0088\u0005\u001e\u0000\u0000\u0088\u0089\u0005\u0012\u0000"+
		"\u0000\u0089\u008a\u0005\u001f\u0000\u0000\u008a\u008c\u0005\u0013\u0000"+
		"\u0000\u008b\u0085\u0001\u0000\u0000\u0000\u008b\u0087\u0001\u0000\u0000"+
		"\u0000\u008c\u009b\u0001\u0000\u0000\u0000\u008d\u008e\n\u0005\u0000\u0000"+
		"\u008e\u008f\u0005\u0015\u0000\u0000\u008f\u009a\u0005\u001e\u0000\u0000"+
		"\u0090\u0091\n\u0004\u0000\u0000\u0091\u0092\u0005\u0015\u0000\u0000\u0092"+
		"\u0093\u0005\u001e\u0000\u0000\u0093\u0094\u0005\u0012\u0000\u0000\u0094"+
		"\u0095\u0005\u001f\u0000\u0000\u0095\u009a\u0005\u0013\u0000\u0000\u0096"+
		"\u0097\n\u0001\u0000\u0000\u0097\u0098\u0005\u0016\u0000\u0000\u0098\u009a"+
		"\u0005\u001e\u0000\u0000\u0099\u008d\u0001\u0000\u0000\u0000\u0099\u0090"+
		"\u0001\u0000\u0000\u0000\u0099\u0096\u0001\u0000\u0000\u0000\u009a\u009d"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u0013\u0001\u0000\u0000\u0000\u009d\u009b"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0006\n\uffff\uffff\u0000\u009f\u00a0"+
		"\u0003\u0016\u000b\u0000\u00a0\u00a5\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\n\u0001\u0000\u0000\u00a2\u00a4\u0003\u0016\u000b\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u0015\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00d1\u0003"+
		"\u000e\u0007\u0000\u00a9\u00d1\u0003\u0018\f\u0000\u00aa\u00d1\u0003\f"+
		"\u0006\u0000\u00ab\u00ac\u0005\u0007\u0000\u0000\u00ac\u00ad\u0005\u000e"+
		"\u0000\u0000\u00ad\u00ae\u0003\u0018\f\u0000\u00ae\u00af\u0003\u0018\f"+
		"\u0000\u00af\u00b0\u0003\u001c\u000e\u0000\u00b0\u00b1\u0005\u000f\u0000"+
		"\u0000\u00b1\u00b2\u0003\u0016\u000b\u0000\u00b2\u00d1\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0005\u0005\u0000\u0000\u00b4\u00b5\u0005\u000e\u0000"+
		"\u0000\u00b5\u00b6\u0003\u001c\u000e\u0000\u00b6\u00b7\u0005\u000f\u0000"+
		"\u0000\u00b7\u00b8\u0003\u0016\u000b\u0000\u00b8\u00d1\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0005\u0005\u0000\u0000\u00ba\u00bb\u0005\u000e\u0000"+
		"\u0000\u00bb\u00bc\u0003\u001c\u000e\u0000\u00bc\u00bd\u0005\u000f\u0000"+
		"\u0000\u00bd\u00be\u0003\u0016\u000b\u0000\u00be\u00bf\u0005\u0006\u0000"+
		"\u0000\u00bf\u00c0\u0003\u0016\u000b\u0000\u00c0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0005\b\u0000\u0000\u00c2\u00c3\u0005\u000e\u0000\u0000"+
		"\u00c3\u00c4\u0003\u001c\u000e\u0000\u00c4\u00c5\u0005\u000f\u0000\u0000"+
		"\u00c5\u00c6\u0003\u0016\u000b\u0000\u00c6\u00d1\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0005\t\u0000\u0000\u00c8\u00c9\u0005\u000e\u0000\u0000\u00c9"+
		"\u00ca\u0005\u001e\u0000\u0000\u00ca\u00cb\u0005\u000f\u0000\u0000\u00cb"+
		"\u00d1\u0005\u0014\u0000\u0000\u00cc\u00cd\u0005\n\u0000\u0000\u00cd\u00ce"+
		"\u0003\u001c\u000e\u0000\u00ce\u00cf\u0005\u0014\u0000\u0000\u00cf\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d0\u00a8\u0001\u0000\u0000\u0000\u00d0\u00a9"+
		"\u0001\u0000\u0000\u0000\u00d0\u00aa\u0001\u0000\u0000\u0000\u00d0\u00ab"+
		"\u0001\u0000\u0000\u0000\u00d0\u00b3\u0001\u0000\u0000\u0000\u00d0\u00b9"+
		"\u0001\u0000\u0000\u0000\u00d0\u00c1\u0001\u0000\u0000\u0000\u00d0\u00c7"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cc\u0001\u0000\u0000\u0000\u00d1\u0017"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d8\u0005\u0014\u0000\u0000\u00d3\u00d4"+
		"\u0003\u001c\u000e\u0000\u00d4\u00d5\u0005\u0014\u0000\u0000\u00d5\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d8\u0003\u001c\u000e\u0000\u00d7\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d3\u0001\u0000\u0000\u0000\u00d7\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u0019\u0001\u0000\u0000\u0000\u00d9\u00e0"+
		"\u0005\u001e\u0000\u0000\u00da\u00db\u0005\u001e\u0000\u0000\u00db\u00dc"+
		"\u0005\u0012\u0000\u0000\u00dc\u00dd\u0003\u001c\u000e\u0000\u00dd\u00de"+
		"\u0005\u0013\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00d9"+
		"\u0001\u0000\u0000\u0000\u00df\u00da\u0001\u0000\u0000\u0000\u00e0\u001b"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e7\u0003\u001e\u000f\u0000\u00e2\u00e3"+
		"\u0003\u001a\r\u0000\u00e3\u00e4\u0005\u001d\u0000\u0000\u00e4\u00e5\u0003"+
		"\u001e\u000f\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e2\u0001\u0000\u0000\u0000\u00e7\u001d\u0001"+
		"\u0000\u0000\u0000\u00e8\u00ee\u0003 \u0010\u0000\u00e9\u00ea\u0003 \u0010"+
		"\u0000\u00ea\u00eb\u0005\u001c\u0000\u0000\u00eb\u00ec\u0003 \u0010\u0000"+
		"\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ee\u001f\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f5\u0003\"\u0011\u0000\u00f0\u00f1\u0003\"\u0011\u0000\u00f1"+
		"\u00f2\u0005\u001b\u0000\u0000\u00f2\u00f3\u0003\"\u0011\u0000\u00f3\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f4\u00ef\u0001\u0000\u0000\u0000\u00f4\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f5!\u0001\u0000\u0000\u0000\u00f6\u00f7\u0006"+
		"\u0011\uffff\uffff\u0000\u00f7\u00f8\u0003$\u0012\u0000\u00f8\u0101\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\n\u0002\u0000\u0000\u00fa\u00fb\u0005\u0016"+
		"\u0000\u0000\u00fb\u0100\u0003$\u0012\u0000\u00fc\u00fd\n\u0001\u0000"+
		"\u0000\u00fd\u00fe\u0005\u0016\u0000\u0000\u00fe\u0100\u0005\u001d\u0000"+
		"\u0000\u00ff\u00f9\u0001\u0000\u0000\u0000\u00ff\u00fc\u0001\u0000\u0000"+
		"\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102#\u0001\u0000\u0000\u0000"+
		"\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0105\u0006\u0012\uffff\uffff"+
		"\u0000\u0105\u0106\u0003&\u0013\u0000\u0106\u010c\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\n\u0001\u0000\u0000\u0108\u0109\u0005\u0017\u0000\u0000\u0109"+
		"\u010b\u0003&\u0013\u0000\u010a\u0107\u0001\u0000\u0000\u0000\u010b\u010e"+
		"\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d%\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0005\u0016\u0000\u0000\u0110\u0115\u0003"+
		"&\u0013\u0000\u0111\u0112\u0005\u001a\u0000\u0000\u0112\u0115\u0003&\u0013"+
		"\u0000\u0113\u0115\u0003(\u0014\u0000\u0114\u010f\u0001\u0000\u0000\u0000"+
		"\u0114\u0111\u0001\u0000\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\'\u0001\u0000\u0000\u0000\u0116\u0129\u0003\u001a\r\u0000\u0117"+
		"\u0118\u0005\u001e\u0000\u0000\u0118\u0119\u0005\u000e\u0000\u0000\u0119"+
		"\u011a\u0003*\u0015\u0000\u011a\u011b\u0005\u000f\u0000\u0000\u011b\u0129"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u000e\u0000\u0000\u011d\u011e"+
		"\u0003\u001c\u000e\u0000\u011e\u011f\u0005\u000f\u0000\u0000\u011f\u0129"+
		"\u0001\u0000\u0000\u0000\u0120\u0129\u0005\u001f\u0000\u0000\u0121\u0129"+
		"\u0005 \u0000\u0000\u0122\u0123\u0003\u001a\r\u0000\u0123\u0124\u0005"+
		"\u0018\u0000\u0000\u0124\u0129\u0001\u0000\u0000\u0000\u0125\u0126\u0003"+
		"\u001a\r\u0000\u0126\u0127\u0005\u0019\u0000\u0000\u0127\u0129\u0001\u0000"+
		"\u0000\u0000\u0128\u0116\u0001\u0000\u0000\u0000\u0128\u0117\u0001\u0000"+
		"\u0000\u0000\u0128\u011c\u0001\u0000\u0000\u0000\u0128\u0120\u0001\u0000"+
		"\u0000\u0000\u0128\u0121\u0001\u0000\u0000\u0000\u0128\u0122\u0001\u0000"+
		"\u0000\u0000\u0128\u0125\u0001\u0000\u0000\u0000\u0129)\u0001\u0000\u0000"+
		"\u0000\u012a\u012d\u0003,\u0016\u0000\u012b\u012d\u0001\u0000\u0000\u0000"+
		"\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012b\u0001\u0000\u0000\u0000"+
		"\u012d+\u0001\u0000\u0000\u0000\u012e\u012f\u0006\u0016\uffff\uffff\u0000"+
		"\u012f\u0130\u0003\u001e\u000f\u0000\u0130\u0136\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\n\u0002\u0000\u0000\u0132\u0133\u0005\u0015\u0000\u0000\u0133"+
		"\u0135\u0003\u001e\u000f\u0000\u0134\u0131\u0001\u0000\u0000\u0000\u0135"+
		"\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137-\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u001a7=L[eoqz\u0083\u008b\u0099\u009b\u00a5\u00d0"+
		"\u00d7\u00df\u00e6\u00ed\u00f4\u00ff\u0101\u010c\u0114\u0128\u012c\u0136";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}