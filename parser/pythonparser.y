%language "Java"
%skeleton "./lalr1-patched.java"

%define api.package {compiler.parser}

%define api.parser.class {Parser}
%define api.parser.public

%code imports {
  import compiler.lexer.Lexer;
  import compiler.lexer.Token;
  import compiler.lexer.Tokens;
}

%lex-param {compiler.lexer.Lexer lexer}

%code lexer {
  private compiler.lexer.Lexer lexer;

  public YYLexer(compiler.lexer.Lexer lexer){
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
      case Tokens.STRING:
          yylval=token.getLiteral();
          return STRING;
      case Tokens.IF:
          return IF;
      case Tokens.INDENT:
          return INDENT;
      case Tokens.DEDENT:
          return DEDENT;
      case Tokens.IDENTIFIER:
          if(token.getLiteral().equals("range"))
            return RANGE;
          else
            return IDENTIFIER;
      default:
          return token.getType();
    }
  }
}

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
%token <Object> RANGE
%type <Object> exp
%type <Boolean> if_pred

%nonassoc '='
%left OR
%left AND
%precedence NOT 
%left EQUAL NOT_EQUAL NOT_EQUAL_2 '<' '>' GREATER_THAN_OR_EQUAL LESS_THAN_OR_EQUAL
%left '+' '-'
%left '*' '/'
%precedence NEG
%right '^'

%%
prog:
%empty
| statements
;

statements:
statement
|statement statements
;

statement:
'\n'
| exp '\n' {System.out.println($1.toString());}
| if_statement
| IDENTIFIER '=' exp '\n' {System.out.println("assignment statement detected, assigned expression evaluated to "+$3.toString());}
| for_statement
;


for_statement:
FOR IDENTIFIER IN RANGE '('exp','exp')' ':' block {System.out.println("FOR LOOP detected with range params "
  + $6.toString() + ", " + $8.toString());}
;



if_statement:
IF if_pred ':' block {System.out.println("IF statement detected, condition evaluated to "+ $2.toString());}
| IF if_pred ':' block ELSE ':' block {System.out.println("IF ELSE statement detected, condition evaluated to "+ $2.toString());}
| IF if_pred ':' block else_if_blocks {System.out.println("IF ELIF statement detected, condition evaluated to "+ $2.toString());}
| IF if_pred ':' block else_if_blocks ELSE ':' block {System.out.println("IF ELIF ELSE statement detected, condition evaluated to "+ $2.toString());}
;

else_if_blocks:
ELIF if_pred ':' block {System.out.println("ELIF condition evaluated to "+$2.toString());}
| ELIF if_pred ':' block else_if_blocks {System.out.println("ELIF condition evaluated to "+$2.toString());}
;

block:
'\n' INDENT statements DEDENT {System.out.println("block detected");}
;

exp:
IDENTIFIER {
	$$=3.0; //JUST FOR TESTING REASONS, WE DO NOT HAVE SYMBOLS YET
}
| TRUE_TOK {$$=(Boolean)true;}
| FALSE_TOK {$$=(Boolean)false;}
| NUMBER {$$=(Double)$1;}
| exp AND exp {$$=(Boolean)((Boolean)($1)&&(Boolean)($3));}
| exp OR exp {$$=(Boolean)((Boolean)($1)||(Boolean)($3));}
| exp EQUAL exp {if(($1 instanceof Boolean)&&($3 instanceof Boolean)){
                    $$=(Boolean)((Boolean)($1)==(Boolean)($3));
                  }
                if(($1 instanceof Double)&&($3 instanceof Double)){
                    $$=(((Double)$1).compareTo((Double)$3)==0);
                  }
                }
| exp NOT_EQUAL exp {if(($1 instanceof Boolean)&&($3 instanceof Boolean)){
                    $$=(Boolean)((Boolean)($1)!=(Boolean)($3));
                  }
                if(($1 instanceof Double)&&($3 instanceof Double)){
                    $$=(((Double)$1).compareTo((Double)$3)!=0);
                  }}
| exp NOT_EQUAL_2 exp {if(($1 instanceof Boolean)&&($3 instanceof Boolean)){
                    $$=(Boolean)((Boolean)($1)!=(Boolean)($3));
                  }
                if(($1 instanceof Double)&&($3 instanceof Double)){
                    $$=(((Double)$1).compareTo((Double)$3)!=0);
                  }}
| NOT exp {
  if($2 instanceof Boolean){
    $$=!(Boolean)$2;
  }
  if($2 instanceof Double){
    if(((Double)$2)==0){
      $$=true;
    }else{
      $$=false;
    }
  }
  }
| exp GREATER_THAN_OR_EQUAL exp {$$=((Double)$1).compareTo((Double)$3)>=0;}
| exp LESS_THAN_OR_EQUAL exp {$$=((Double)$1).compareTo((Double)$3)<=0;}
| exp '<' exp {$$=((Double)$1).compareTo((Double)$3)<0;}
| exp '>' exp {$$=((Double)$1).compareTo((Double)$3)>0;}
| exp '+' exp {$$=(Double)$1+(Double)$3;}
| exp '-' exp {$$=(Double)$1-(Double)$3;}
| exp '*' exp {$$=(Double)$1*(Double)$3;}
| exp '/' exp {$$=(Double)$1/(Double)$3;}
| '-' exp %prec NEG {$$=-(Double)$2;}
| '(' exp ')' {$$=$2;}
;

if_pred:
exp {$$=(Boolean)$1;}
;
%%
