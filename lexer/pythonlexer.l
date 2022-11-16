%{
    #include <stdio.h>
    #include<ctype.h>
    #include<string.h>

    const char* KEYWORD="KEYWORD";
    const char* INDENT="INDENT";
    const char* DEDENT="DEDENT";
    const char* NEWLINE="NEWLINE";
    const char* NUMBER="NUMBER";
    const char* COMMENT="COMMENT";
    const char* LPAREN="(";
    const char* RPAREN=")";
    const char* LBRACE="{";
    const char* RBRACE="}";
    const char* LBRACKET="[";
    const char* RBRACKET="]";
    const char* COLON=":";
    const char* SEMICOLON=";";
    const char* COMMA=",";
    const char* PLUS="+";
    const char* MINUS="-";
    const char* MULTIPLICATION="*";
    const char* DIVISION="/";
    const char* LESS_THAN="<";
    const char* LESS_THAN_OR_EQUAL="<=";
    const char* GREATER_THAN=">";
    const char* GREATER_THAN_OR_EQUAL=">=";
    const char* ASSIGNMENT="=";
    const char* DOT=".";
    const char* REMAINDER="%";
    const char* TICK="`";
    const char* EQUAL="==";
    const char* NOT_EQUAL="!=";
    const char* NOT_EQUAL_2="<>";
    const char* BITWISE_NOT="~";
    const char* BITWISE_XOR="^";
    const char* BITWISE_SHIFT_LEFT="<<";
    const char* BITWISE_SHIFT_RIGHT=">>";
    const char* POWER="**";
    const char* ADDITION_ASSIGNMENT="+=";
    const char* SUBSTRACTION_ASSIGNMENT="-=";
    const char* MULTIPLICATION_ASSIGNMENT="*=";
    const char* DIVISION_ASSIGNMENT="/=";
    const char* REMAINDER_ASSIGNMENT="%=";
    const char* BITWISE_AND_ASSIGNMENT="&=";
    const char* POWER_ASSIGNMENT="**=";
    const char* BITWISE_AND="&";
    const char* BITWISE_OR="|";
    const char* BITWISE_OR_ASSIGNMENT="|=";
    const char* BITWISE_XOR_ASSIGNMENT="^=";
    const char* BITWISE_SHIFT_LEFT_ASSIGNMENT="<<=";
    const char* BITWISE_SHIFT_RIGHT_ASSIGNMENT=">>=";
    const char* FLOOR_DIVISION="//";
    const char* FLOOR_DIVISION_ASSIGNMENT="//=";
    const char* BACKSLASH_LOGICAL_LINE="BS_LOGICAL_LINE";
    const char* STRING="STRING";
    const char* IDENTIFIER="IDENTIFIER";
    const char* WHITE_SPACE="WHITESPACE";
    const char* ILLEGAL="ILLEGAL";
    const char* IMPORT="IMPORT";
    const char* NONLOCAL="NONLOCAL";
    const char* CONTINUE="CONTINUE";
    const char* NONE="NONE";
    const char* GLOBAL="GLOBAL";
    const char* IN="IN";
    const char* RETURN="RETURN";
    const char* FALSE_TOK="FALSE";
    const char* TRUE_TOK="TRUE";
    const char* AND="AND";
    const char* OR="OR";
    const char* NOT="NOT";
    const char* DEF="DEF";
    const char* IF="IF";
    const char* ELSE="ELSE";
    const char* ELIF="ELIF";
    const char* FOR="FOR";
    const char* WHILE="WHILE";
    const char* BREAK="BREAK";
    const char* PASS="PASS";
    const char* LAMBDA="LAMBDA";
    const char* COMMA_LOGICAL_LINE="CM_LOGICAL_LINE";
    
    const char* OUTPUT_FORMAT="%-15s%-20s%-5d%d\n";
    const int TAB_WIDTH=4;

    int colnum=1;
    int linenum=1;
    int bsLogicalLineSpace=1;
    int commaLogicalLineSpace=1;
    
    int indentCounter=0;
    FILE* inputFile=NULL, *outputFile=NULL;
    void handleToken(const char* type, const char* literal);
%}

identifier [_a-zA-Z][_a-zA-Z0-9]*

newline \n|\r|\n\r|\r\n

commalogicalline ,{newline}[\t]*

bslogicalline \\{newline}[\t]*

dent {newline}+[\t]*

comment #.*

 /*
    100.014e+1
    <->|<-><->
     | | |  |
     ⋱-|-|--|-------- Whole Part:  100
       | |  |
       ⋱-|--|----- Decimal Point:  .
         |  |
         ⋱--|----- Fraction Part:  014
            |
            ⋱-- Exponential Part:  e+1
 */

number_whole ([1-9](_?[0-9])*_?)?[0-9]
number_fraction [0-9](_?[0-9])*
number_exponent e[+-]?[0-9](_?[0-9])*

number_full {number_whole}(\.{number_fraction}?{number_exponent}?)?
number_fraction_only \.{number_fraction}{number_exponent}?

number {number_full}|{number_fraction_only}

escape \\.

longstringchar [^\\]
stringcharsingle [^\\\n\r\']
stringchardouble [^\\\n\r\"]

longstringitem {longstringchar}|{escape}
stringitemsingle {stringcharsingle}|{escape}
stringitemdouble {stringchardouble}|{escape}

stringsingle \'{stringitemsingle}*\'
stringdouble \"{stringitemdouble}*\"
longstringsingle   \'\'\'{longstringitem}*\'\'\' 
longstringdouble \"\"\"{longstringitem}*\"\"\"


%%

"import" handleToken(IMPORT,yytext);
"nonlocal" handleToken(NONLOCAL,yytext);
"continue" handleToken(CONTINUE,yytext);
"None" handleToken(NONE,yytext);
"global" handleToken(GLOBAL,yytext);
"in" handleToken(IN,yytext);
"return" handleToken(RETURN,yytext);
"False" handleToken(FALSE_TOK,yytext);
"True" handleToken(TRUE_TOK,yytext);
"and" handleToken(AND,yytext);
"or" handleToken(OR,yytext);
"not" handleToken(NOT,yytext);
"def" handleToken(DEF,yytext);
"if" handleToken(IF,yytext);
"else" handleToken(ELSE,yytext);
"elif" handleToken(ELIF,yytext);
"for" handleToken(FOR,yytext);
"while" handleToken(WHILE,yytext);
"break" handleToken(BREAK,yytext);
"pass" handleToken(PASS,yytext);
"lambda" handleToken(LAMBDA,yytext);

{dent} {
    int len=0,nNewlineCount=0,rNewlineCount=0;
    for(int i=0;i<strlen(yytext);++i){
        if(yytext[i]=='\t') len++;
        if (yytext[i]=='\n') nNewlineCount++;
        if (yytext[i]=='\r') rNewlineCount++;
    }
    
    //Take the longest of both types so it doesn't count double lines in \n\r cases
    for(int i=0;i<((nNewlineCount<=rNewlineCount)?rNewlineCount:nNewlineCount);++i)
        handleToken(NEWLINE,"");

    if (len<indentCounter){
        int tokensCount=indentCounter-len;
        indentCounter=len;
        for(int i=0;i<tokensCount;++i)
        	handleToken(DEDENT,"");

    }else if (len==indentCounter+1){
        indentCounter=len;
        handleToken(INDENT,"");
      
    }else if (len!=indentCounter){
    	handleToken(ILLEGAL,yytext);
    }
}


{comment} {
            handleToken(COMMENT,yytext);
         }

{number} {handleToken(NUMBER,yytext);}

"(" {handleToken(LPAREN,yytext);} 
")" {handleToken(RPAREN,yytext);} 
"{" {handleToken(LBRACE,yytext);}
"}" {handleToken(RBRACE,yytext);}
"[" {handleToken(LBRACKET,yytext);}
"]" {handleToken(RBRACKET,yytext);}
         
":"        { handleToken(COLON,yytext); }
","        { handleToken(COMMA,yytext);}
";"        { handleToken(SEMICOLON,yytext);}

"+"        { handleToken(PLUS,yytext);}
"-"        { handleToken(MINUS,yytext);}
"*"        { handleToken(MULTIPLICATION,yytext);}
"/"        { handleToken(DIVISION,yytext);}

"<"        { handleToken(LESS_THAN,yytext);}
">"        { handleToken(GREATER_THAN,yytext);}
"="        { handleToken(ASSIGNMENT,yytext);}

"."        { handleToken(DOT,yytext);}
"%"        { handleToken(REMAINDER,yytext);}
"`"        { handleToken(TICK,yytext);}

"=="       { handleToken(EQUAL,yytext);}
"!="       { handleToken(NOT_EQUAL,yytext);}
"<="       { handleToken(LESS_THAN_OR_EQUAL,yytext);}
">="       { handleToken(GREATER_THAN_OR_EQUAL,yytext);} 
"<>"       { handleToken(NOT_EQUAL_2,yytext);} 
"~"        { handleToken(BITWISE_NOT,yytext);} 

"^"        { handleToken(BITWISE_XOR,yytext);}
"<<"       { handleToken(BITWISE_SHIFT_LEFT,yytext);}
">>"       { handleToken(BITWISE_SHIFT_RIGHT,yytext);}

"**"       { handleToken(POWER,yytext);}

"+="       { handleToken(ADDITION_ASSIGNMENT,yytext);} 
"-="       { handleToken(SUBSTRACTION_ASSIGNMENT,yytext);}
"*="       { handleToken(MULTIPLICATION_ASSIGNMENT,yytext);}
"/="       { handleToken(DIVISION_ASSIGNMENT,yytext);}
"%="       { handleToken(REMAINDER_ASSIGNMENT,yytext);}
"&="       { handleToken(BITWISE_AND_ASSIGNMENT,yytext);}
"&"        { handleToken(BITWISE_AND,yytext);}
"|"        { handleToken(BITWISE_OR,yytext);}
"|="       { handleToken(BITWISE_OR_ASSIGNMENT,yytext);}
"^="       { handleToken(BITWISE_XOR_ASSIGNMENT,yytext);}
"<<="      { handleToken(BITWISE_SHIFT_LEFT_ASSIGNMENT,yytext);}
">>="      { handleToken(BITWISE_SHIFT_RIGHT_ASSIGNMENT,yytext);}
"**="      { handleToken(POWER_ASSIGNMENT,yytext);}
"//"       { handleToken(FLOOR_DIVISION,yytext);}
"//="      { handleToken(FLOOR_DIVISION_ASSIGNMENT,yytext);}

{commalogicalline} {
                        int tabsCount=0;
                        for(int i=0;i<strlen(yytext);++i){
                            if (yytext[i]=='\t') tabsCount++;
                        }
                        commaLogicalLineSpace=tabsCount;
                        handleToken(COMMA_LOGICAL_LINE,",");
}

{bslogicalline}     {
                        int tabsCount=0;
                        for(int i=0;i<strlen(yytext);++i){
                            if (yytext[i]=='\t') tabsCount++;
                        }
                        bsLogicalLineSpace=tabsCount;
                        handleToken(BACKSLASH_LOGICAL_LINE,"");
                     }

{longstringsingle}   {handleToken(STRING,yytext);}
{longstringdouble}   {handleToken(STRING,yytext);}
{stringsingle} {handleToken(STRING,yytext);}
{stringdouble} {handleToken(STRING,yytext);}

{identifier} {handleToken(IDENTIFIER,yytext);} 

" " {handleToken(WHITE_SPACE,yytext);}

. {handleToken(ILLEGAL,yytext);}

%%
int yywrap(){
	if(inputFile!=NULL)
	    fclose(inputFile);
    fclose(outputFile);
    exit(0);
}

int main(int argc,const char** argv){
    if(argc==1){
        yyin=stdin;
    }else{
        inputFile=fopen(argv[1],"r");
        yyin=inputFile;
    }
    outputFile=fopen("./tokens.txt","w");
    yylex(); 
}

void handleToken(const char* type,const char* literal){
    if(!strcmp(type,NEWLINE)) {
        colnum=1;
        colnum+=(indentCounter*TAB_WIDTH);
        linenum++;
    }

    printf(OUTPUT_FORMAT,type,literal,linenum,colnum);

    char buffer[128];
    sprintf(buffer,OUTPUT_FORMAT,type,literal,linenum,colnum);
    fputs(buffer,outputFile);  
    colnum+=strlen(literal);

    if(!strcmp(type,INDENT) || !strcmp(type,DEDENT)){ // INDENT/DEDENT changes are calculated after emitting
        colnum=1;                                     // NEWLINE token
        colnum+=(indentCounter*4);
    }

    if(!strcmp(type,BACKSLASH_LOGICAL_LINE)){
        colnum=1;
        colnum+=(bsLogicalLineSpace*TAB_WIDTH);
        linenum++;
    }
    if(!strcmp(type,COMMA_LOGICAL_LINE)){
    	colnum=1;
        colnum+=(commaLogicalLineSpace*TAB_WIDTH);
        linenum++;
    }
}
