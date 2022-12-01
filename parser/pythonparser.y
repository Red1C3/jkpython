%language "Java"

%define api.parser.class {Parser}
%define api.parser.public

%code imports {
  import compiler.lexer.Lexer;
  import compiler.lexer.Token;
  import compiler.lexer.Tokens;
}

%token <Object> KEYWORD
%token <Object> INDENT
%token <Object> DEDENT
%token <Object> NEWLINE
%token <Double> NUMBER
%token <Object> COMMENT
%token <Boolean> LESS_THAN_OR_EQUAL
%token <Boolean> GREATER_THAN_OR_EQUAL
%token <Boolean> EQUAL
%token <Boolean> NOT_EQUAL
%token <Boolean> NOT_EQUAL_2
%token <Integer> BITWISE_SHIFT_LEFT
%token <Integer> BITWISE_SHIFT_RIGHT
%token <Double> POWER
%token <Double> ADDITION_ASSIGNMENT
%token <Double> SUBSTRACTION_ASSIGNMENT
%token <Double> MULTIPLICATION_ASSIGNMENT
%token <Double> DIVISION_ASSIGNMENT
%token <Double> REMAINDER_ASSIGNMENT
%token <Object> BITWISE_AND_ASSIGNMENT
%token <Object> POWER_ASSIGNMENT
%token <Object> BITWISE_OR_ASSIGNMENT
%token <Object> BITWISE_XOR_ASSIGNMENT
%token <Object> BITWISE_SHIFT_LEFT_ASSIGNMENT
%token <Object> BITWISE_SHIFT_RIGHT_ASSIGNMENT
%token <Object> FLOOR_DIVISION
%token <Object> FLOOR_DIVISION_ASSIGNMENT
%token <Object> BACKSLASH_LOGICAL_LINE
%token <String> STRING
%token <Object> IDENTIFIER
%token <Object> WHITE_SPACE
%token <Object> ILLEGAL
%token <Object> IMPORT
%token <Object> NONLOCAL
%token <Object> CONTINUE
%token <Object> NONE
%token <Object> GLOBAL
%token <Object> IN
%token <Object> RETURN
%token <Boolean> FALSE_TOK
%token <Boolean> TRUE_TOK
%token <Boolean> AND
%token <Boolean> OR
%token <Boolean> NOT
%token <Object> DEF
%token <Object> IF
%token <Object> ELSE
%token <Object> ELIF
%token <Object> FOR
%token <Object> WHILE
%token <Object> BREAK
%token <Object> PASS
%token <Object> LAMBDA
%token <Object> COMMA_LOGICAL_LINE
%type <Object> exp

%left '+' '-'
%left '*' '/'
%precedence NEG
%right '^'

%%
prog: 
%empty
|statement prog
;

simple_statement:
'\n'
| exp '\n' {System.out.println((Double)$1);}
;

compound_statement:
IF exp ':' block
;

statement:
simple_statements
| compound_statement
;

statements:
statement
| statements statement
;


simple_statements:
simple_statement
|simple_statement simple_statements
;

block:
INDENT statements DEDENT {System.out.println("Block handled");}
| simple_statements {System.out.println("Simple statements as block handled");}
;

exp: NUMBER {$$=(Double)$1;}
| exp '+' exp {$$=(Double)$1+(Double)$3;}
| exp '-' exp {$$=(Double)$1-(Double)$3;}
| exp '*' exp {$$=(Double)$1*(Double)$3;}
| exp '/' exp {$$=(Double)$1/(Double)$3;}
| '-' exp %prec NEG {$$=-(Double)$2;}
| '(' exp ')' {$$=$2;}
;
%%

class LexerHelper implements Parser.Lexer {
  private compiler.lexer.Lexer lexer;

  public LexerHelper(compiler.lexer.Lexer lexer){
    this.lexer=lexer;
  }

  public void yyerror(String s) {
    System.err.println(s);
  }

  private Object yylval;

  public Object getLVal() {
    return yylval;
  }

  public int yylex(){
    Token token=lexer.nextToken();
    if(token==null){
        return YYEOF;
    }
    switch(token.getType()){
    case Tokens.NUMBER:
        yylval=Double.parseDouble(token.getLiteral());
        return NUMBER;
    case Tokens.NEWLINE:
        return (int) '\n';
    default:
        return token.getType();
    }
  }
}