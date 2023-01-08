%language "Java"
%skeleton "./lalr1-patched.java"

%define api.package {compiler.parser}

%define api.parser.class {Parser}
%define api.parser.public


%code imports {
  import compiler.lexer.Lexer;
  import compiler.lexer.Token;
  import compiler.evaluator.source_tree.Program;
  import compiler.evaluator.source_tree.SourceNode;
  import compiler.evaluator.source_tree.statements.expressions.*;
  import compiler.evaluator.source_tree.statements.*;
  import compiler.evaluator.builtins.types.*;
  import java.util.List;
  import java.util.ArrayList;
  import kotlin.Pair;
  import compiler.evaluator.builtins.constants.*;
}
 // Add a "program" data member to Bison's Parser class
%code {
	public Program program;
}

//Bison's generated Parser class constructor parameter
%lex-param {compiler.lexer.Lexer lexer}

//Bison's generated Lexer class data members and methods (won't be directly used, This class is rather covered
//in Bison's generated Parser class)
%code lexer {
  private compiler.lexer.Lexer lexer;

  public YYLexer(compiler.lexer.Lexer lexer){
    this.lexer=lexer;
  }

  public void yyerror(String s) {
    System.err.println(s);
    System.exit(1);
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
      case NUMBER:
      	  //Return a literal (AST leaf that contains a primitive type) so it gets added to the AST
      	  //Literals are host language variables
          yylval=SourceNode.Companion.addMeta(new Literal(Double.parseDouble(token.getLiteral())),token.lineNum,token.colNum,null);
          return NUMBER;
      case NEWLINE:
          return (int) '\n';
      case STRING:
          String str=token.getLiteral();
          //Remove quotation marks to allow operations on strings
          if(str.startsWith("'''") || str.startsWith("\"\"\""))
          	yylval=SourceNode.Companion.addMeta(new Literal(str.substring(3,str.length()-3)),token.lineNum,token.colNum,null);
          else
          	yylval=SourceNode.Companion.addMeta(new Literal(str.substring(1,str.length()-1)),token.lineNum,token.colNum,null);
          return STRING;
      case IDENTIFIER:
          //AST node that marks an identifier (Also Identifier type is now
          //Identifier (as in the evaluator's))
          yylval=SourceNode.Companion.addMeta(new Identifier(token.getLiteral()),token.lineNum,token.colNum,null);
          return IDENTIFIER;

      case TRUE_TOK:
          yylval=SourceNode.Companion.addMeta(new Literal(true),token.lineNum,token.colNum,null);
          return TRUE_TOK;
      case FALSE_TOK:
      	  yylval=SourceNode.Companion.addMeta(new Literal(false),token.lineNum,token.colNum,null);
      	  return FALSE_TOK;
      case COMMENT:
      	  return (int) '\n'; //FIXME just anything that does nothing
      case NONE:
		   yylval=SourceNode.Companion.addMeta(new Literal(PyNone.INSTANCE),token.lineNum,token.colNum,null);
		   return NONE;
      default:
          return token.getType();
    }
  }
}

%token <Object> INDENT
%token <Object> DEDENT
%token <Object> NEWLINE
%token <Literal> NUMBER
%token <Object> COMMENT
%token <Object> LESS_THAN_OR_EQUAL
%token <Object> GREATER_THAN_OR_EQUAL
%token <Object> EQUAL
%token <Object> NOT_EQUAL
%token <Object> NOT_EQUAL_2
%token <Object> BITWISE_SHIFT_LEFT
%token <Object> BITWISE_SHIFT_RIGHT
%token <Object> POWER
%token <Object> ADDITION_ASSIGNMENT
%token <Object> SUBSTRACTION_ASSIGNMENT
%token <Object> MULTIPLICATION_ASSIGNMENT
%token <Object> DIVISION_ASSIGNMENT
%token <Object> REMAINDER_ASSIGNMENT
%token <Object> BITWISE_AND_ASSIGNMENT
%token <Object> POWER_ASSIGNMENT
%token <Object> BITWISE_OR_ASSIGNMENT
%token <Object> BITWISE_XOR_ASSIGNMENT
%token <Object> BITWISE_SHIFT_LEFT_ASSIGNMENT
%token <Object> BITWISE_SHIFT_RIGHT_ASSIGNMENT
%token <Object> FLOOR_DIVISION
%token <Object> FLOOR_DIVISION_ASSIGNMENT
%token <Object> BACKSLASH_LOGICAL_LINE
%token <Literal> STRING
%token <Identifier> IDENTIFIER
%token <Object> WHITE_SPACE
%token <Object> ILLEGAL
%token <Object> IMPORT
%token <Object> NONLOCAL
%token <ContinueStatement> CONTINUE
%token <Literal> NONE
%token <Object> GLOBAL
%token <Object> IN
%token <Object> RETURN
%token <Literal> FALSE_TOK
%token <Literal> TRUE_TOK
%token <Object> AND
%token <Object> OR
%token <Object> NOT
%token <Object> DEF
%token <Object> IF
%token <Object> ELSE
%token <Object> ELIF
%token <Object> FOR
%token <Object> WHILE
%token <BreakStatement> BREAK
%token <Object> PASS
%token <Object> LAMBDA
%token <Object> COMMA_LOGICAL_LINE
%type <Expression> exp
%type <Expression> if_pred
%type <Statement> statement

 //"statements are not of type "StatementsBlock" because that will
 //make "block" two "StatementsBlock" instead of one
%type <List<Statement>> statements
%type <List<Expression>> exp_list
%type <StatementsBlock> block
%type <List<Identifier>> function_args
%type <FunctionDeclaration> function_statement
%type <ReturnStatement> return_statement
%type <IfStatement> if_statement
%type <List<Pair<Expression,StatementsBlock>>> else_if_blocks
%type <ForStatement> for_statement
%type <WhileStatement> while_statement


%nonassoc ','
%nonassoc '='
%left OR
%left AND
%precedence NOT
%nonassoc EQUAL NOT_EQUAL NOT_EQUAL_2 '<' '>' GREATER_THAN_OR_EQUAL LESS_THAN_OR_EQUAL
%left '+' '-'
%left '*' '/' '%' FLOOR_DIVISION
%precedence NEG
%right POWER

%%
prog:
%empty
| statements {
	//The AST root node
	program = new Program(new StatementsBlock($1.toArray(new Statement[0])));
}
;

statements:
statement {$$=new ArrayList<>(List.of($1));}
|statement statements{
	$$=new ArrayList<>(List.of($1));
	((List)($$)).addAll($2); //Combine all statements together
}
;

statement:
'\n' {}
| exp '\n' {$$=$1;}
| if_statement {$$=$1;}
| for_statement {$$=$1;}
| while_statement {$$=$1;}
| function_statement {$$=$1;}
| return_statement {$$=$1;}
| CONTINUE {$$=new ContinueStatement();}
| BREAK {$$=new BreakStatement();}
;



function_statement:
 DEF IDENTIFIER '('function_args')'':' block {$$=new FunctionDeclaration($2,$4,$7);}
 | DEF IDENTIFIER '('')'':' block {
 	$$=new FunctionDeclaration($2,new ArrayList<Identifier>(),$6); //Declare a function with empty arguments list
 }
 ;


function_args:
IDENTIFIER {$$= new ArrayList<>(List.of($1));}
| IDENTIFIER ',' function_args {
	$$=new ArrayList<>(List.of($1));
    ((List)($$)).addAll($3); //Combine all identifiers together
}
;

for_statement:
FOR IDENTIFIER IN exp ':' block {$$=new ForStatement($2,$4,$6);}
;

while_statement:
WHILE exp ':' block{$$= new WhileStatement($2,$4);}
;

return_statement:
RETURN '\n' {$$=new ReturnStatement();}
|RETURN exp '\n' {$$=new ReturnStatement($2);}
;

if_statement:
IF if_pred ':' block {$$=new IfStatement($2,$4,new ArrayList<Pair<Expression,StatementsBlock>>(),null);}
| IF if_pred ':' block ELSE ':' block {$$=new IfStatement($2,$4,new ArrayList<Pair<Expression,StatementsBlock>>(),$7);}
| IF if_pred ':' block else_if_blocks {$$=new IfStatement($2,$4,$5,null);}
| IF if_pred ':' block else_if_blocks ELSE ':' block {$$=new IfStatement($2,$4,$5,$8);}
;

else_if_blocks:
ELIF if_pred ':' block {$$= new ArrayList<>(List.of(new Pair<Expression,StatementsBlock>($2,$4)));}
| ELIF if_pred ':' block else_if_blocks {
	$$=new ArrayList<>(List.of(new Pair<Expression,StatementsBlock>($2,$4)));
	((List)($$)).addAll($5); //Combine all else ifs together
}
;

block:
'\n' INDENT statements DEDENT {$$=new StatementsBlock($3.toArray(new Statement[0]));}
;

exp:
IDENTIFIER {
	$$=$1; //Just so types cast
}
| TRUE_TOK {
	$$=$1;
}
| FALSE_TOK {
	$$=$1;
}
| NONE{
	$$=$1;
}
| NUMBER {$$=$1;}
| STRING {$$=$1;}
| COMMENT {}
| '[' exp_list ']' {
	$$=new ListExpression($2); //Create a list in the host language
}
| '[' ']'{
	$$=new ListExpression(new ArrayList<Expression>()); //Empty list
}
| exp AND exp {
	$$=new InfixExpression($1,"&&",$3);
}
| exp OR exp {
	$$=new InfixExpression($1,"||",$3);
}
| exp EQUAL exp {
				$$= new InfixExpression($1,"==",$3);
                }
| exp NOT_EQUAL exp {
				$$=new InfixExpression($1,"!=",$3);
                }
| exp NOT_EQUAL_2 exp {
				$$=new InfixExpression($1,"!=",$3);
                }
| NOT exp {
	$$=new PrefixExpression("!",$2);
}
| exp GREATER_THAN_OR_EQUAL exp {
	$$=new InfixExpression($1,">=",$3);
}
| exp LESS_THAN_OR_EQUAL exp {
	$$=new InfixExpression($1,"<=",$3);
}
| exp '<' exp {
	$$=new InfixExpression($1,"<",$3);
}
| exp '>' exp {
	$$=new InfixExpression($1,">",$3);
}
| exp '+' exp {
	$$=new InfixExpression($1,"+",$3); // An AST node for binary ops
}
| exp '-' exp {
	$$=new InfixExpression($1,"-",$3); // An AST node for binary ops
}
| exp '*' exp {
	$$=new InfixExpression($1,"*",$3); // An AST node for binary ops
}
| exp '/' exp {
	$$=new InfixExpression($1,"/",$3); // An AST node for binary ops
}
| exp '%' exp{
	$$=new InfixExpression($1,"%",$3);
}
| '-' exp %prec NEG {
	$$=new InfixExpression(new Literal(0.0),"-",$2); // An AST node for binary ops
}
| exp POWER exp {
	$$=new InfixExpression($1,"**",$3);
}
| exp FLOOR_DIVISION exp{
	$$=new InfixExpression($1,"//",$3);
}
| '(' exp ')' {
	$$=$2;
}
| IDENTIFIER '[' exp ']' {
	$$=new IndexExpression($1,$3);
}
| IDENTIFIER '=' exp {
	$$=new AssignmentExpression($1,$3,null); //Adds a new symbol to the context
}
| IDENTIFIER '[' exp ']' '=' exp{
	$$=new AssignmentExpression($1,$6,$3); //Assign a list element to a new value
}
| IDENTIFIER '(' exp_list ')' {
	//Define a function call using the identifier and the parameters list
	$$=new FunctionCall($1,$3);
}
| IDENTIFIER '(' ')'{
	//Define a function call using the identifier
    $$=new FunctionCall($1,new ArrayList<Expression>());
}
;

 //Function parameters grammar (only used in function call NOT defination)
 //Used in lists too
exp_list:
exp {$$= new ArrayList<>(List.of($1));}
| exp ',' exp_list {
	$$=new ArrayList<>(List.of($1));
	((List)($$)).addAll($3); //Combine all expressions together
}
;

if_pred:
exp {
//$$=(Boolean)$1;
}
;
%%
