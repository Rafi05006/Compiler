grammar CSubset;
import Lexer;

start
    : program
    ;

program
    : program unit
    #ProgramRecursive
    | unit
    #ProgramBase
    ;

unit
    : var_declaration
    #UnitVarDecl

    | func_declaration
    #UnitFuncDecl

    | func_definition
    #UnitFuncDef
    ;

func_declaration
    : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON
    #FuncDeclWithParams

    | type_specifier ID LPAREN RPAREN SEMICOLON
    #FuncDeclNoParams
    ;

func_definition
    : type_specifier ID LPAREN parameter_list RPAREN compound_statement
    #FuncDefWithParams
    | type_specifier ID LPAREN RPAREN compound_statement
    #FuncDefNoParams
    ;

parameter_list
    : parameter_list COMMA type_specifier ID
    #ParamListWithId

    | parameter_list COMMA type_specifier
    #ParamListNoId

    | type_specifier ID
    #ParamListSingle

    | type_specifier
    #ParamListTypeOnly

    | type_specifier ADDOP
    #ParamListBadNoId
    ;

compound_statement
    : LCURL statements RCURL
    #CompoundWithStatements

    | LCURL RCURL
    #CompoundEmpty
    ;

var_declaration
    : type_specifier declaration_list SEMICOLON
    ;

type_specifier
    : INT
    #TypeInt

    | FLOAT
    #TypeFloat

    | VOID
    #TypeVoid
    ;

declaration_list
    : declaration_list COMMA ID
    #DeclListMulti

    | declaration_list COMMA ID LTHIRD CONST_INT RTHIRD
    #DeclListMultiArray

    | ID
    #DeclListSingle

    | ID LTHIRD CONST_INT RTHIRD
    #DeclListSingleArray

    | declaration_list ADDOP ID
    #DeclListBadMinus
    ;

statements
    :statement
    #StatementsSingle
    
    | statements statement
    #StatementsRecursive
    ;

statement
    : var_declaration
    #StatementVarDecl

    | expression_statement
    #StatementExpr

    | compound_statement
    #StatementCompound

    | FOR LPAREN expression_statement expression_statement expression RPAREN statement
    #StatementFor

    | IF LPAREN expression RPAREN statement
    #StatementIf

    | IF LPAREN expression RPAREN statement ELSE statement
    #StatementIfElse

    | WHILE LPAREN expression RPAREN statement
    #StatementWhile

    | PRINTLN LPAREN ID RPAREN SEMICOLON
    #StatementPrintln

    | RETURN expression SEMICOLON
    #StatementReturn
    ;

expression_statement
    : SEMICOLON
    #EmptyExpressionStatement

    | expression SEMICOLON
    #ExpressionStatement

    | expression
    #ExpressionStatementMissingSemicolon
    ;

variable
    : ID
    #VarSimple

    | ID LTHIRD expression RTHIRD
    #VarArray
    ;

expression
    : logic_expression
    #ExpressionLogic

    | variable ASSIGNOP logic_expression
    #ExpressionAssign
    ;

logic_expression
    : rel_expression
    #LogicRel

    | rel_expression LOGICOP rel_expression
    #LogicBinary
    ;

rel_expression
    : simple_expression
    #RelSimple

    | simple_expression RELOP simple_expression
    #RelBinary
    ;

simple_expression
    : term
    #SimpleTerm

    | simple_expression ADDOP term
    #SimpleBinary

    | simple_expression ADDOP ASSIGNOP
    #SimpleBadAssign
    ;

term
    : unary_expression
    #TermUnary

    | term MULOP unary_expression
    #TermBinary
    ;

unary_expression
    : ADDOP unary_expression
    #UnaryAdd

    | NOT unary_expression
    #UnaryNot

    | factor
    #UnaryFactor
    ;

factor
    : variable
    #FactorVariable

    | ID LPAREN argument_list RPAREN
    #FactorFuncCall

    | LPAREN expression RPAREN
    #FactorParen

    | CONST_INT
    #FactorConstInt

    | CONST_FLOAT
    #FactorConstFloat

    | variable INCOP
    #FactorIncr

    | variable DECOP
    #FactorDecr
    ;

argument_list
    : arguments
    #ArgListNonEmpty

    |
    #ArgListEmpty
    ;

arguments
    : arguments COMMA logic_expression
    #ArgsMulti

    | logic_expression
    #ArgsSingle
    ;
