%language "Java"

%define api.parser.class {Calc}
%define api.parser.public

%code imports {
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.Reader;
  import java.io.StreamTokenizer;
}

%code {
  public static void main(String[] args) throws IOException {
    CalcLexer l = new CalcLexer(System.in);
    Calc p = new Calc(l);
    if (!p.parse())
      System.exit(1);
  }
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

statement:
'\n'
| exp '\n' {System.out.println((Double)$1);}
;

statements:
statement
|statements statement
;

block:
INDENT statements DEDENT
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

class CalcLexer implements Calc.Lexer {

  StreamTokenizer st;

  public CalcLexer(InputStream is) {
    st = new StreamTokenizer(new InputStreamReader(is));
    st.resetSyntax();
    st.eolIsSignificant(true);
    st.whitespaceChars('\t', '\t');
    st.whitespaceChars(' ', ' ');
    st.wordChars('0', '9');
  }

  public void yyerror(String s) {
    System.err.println(s);
  }

  Object yylval;

  public Object getLVal() {
    return yylval;
  }

  public int yylex() throws IOException {
    int ttype = st.nextToken();
    switch (ttype) {
    case StreamTokenizer.TT_EOF:
      return YYEOF;
    case StreamTokenizer.TT_EOL:
      return (int) '\n';
    case StreamTokenizer.TT_WORD:
      yylval = Double.parseDouble(st.sval);
      return NUMBER;
    default:
      return ttype;
    }
  }
}