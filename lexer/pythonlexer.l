%{
    #include <stdio.h>
    #include<ctype.h>
    #include<string.h>
    
    const char* KEYWORD="keyword";
    const char* INDENT="indent";
    const char* DEDENT="dedent";
    const char* NEWLINE="newline";
    const char* NUMBER="number";
    const char* COMMENT="comment";
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
    const char* BACKSLASH_LOGICAL_LINE="\\n";
    const char* STRING="string";
    const char* IDENTIFIER="identifier";
    const char* WHITE_SPACE="whitespace";
    const char* ILLEGAL="illegal";
    
    
    int indentCounter=0;
    FILE* inputFile=NULL, *outputFile=NULL;
    void handleToken(const char* type, const char* literal);
%}

keyword  "import"|"nonlocal"|"continue"|"None"|"global"|"in"|"return"|"False"|"True"|"and"|"or"|"not"|"def"|"if"|"else"|"elif"|"for"|"while"|"break"|"pass"|"lambda"

identifier [_a-zA-Z][_a-zA-Z0-9]*

dent [\n]+[\t]*

comment #[^\n]*

 //number [1-9]([0-9]*|[0-9]*\.[0-9+])
number ([1-9][0-9_]*)?([0-9]\.?|\.[0-9]+)

escape \\.

stringcharsingle [^\\\n\']
stringchardouble [^\\\n\"]

stringitemsingle {stringcharsingle}|{escape}
stringitemdouble {stringchardouble}|{escape}

stringsingle \'{stringitemsingle}*\'
stringdouble \"{stringitemdouble}*\"


%%

{keyword} {handleToken(KEYWORD,yytext);}

{dent} {
    int len=0;
    for(int i=0;i<strlen(yytext);++i){
        if(yytext[i]=='\t') len++;
    }

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
        //REPORT AN ERROR AND EXIT?
    }else{
        handleToken(NEWLINE,"");
    }
}

\n\r|\r\n|\n|\r {
                 handleToken(NEWLINE,"");  
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

"\\n"      {handleToken(BACKSLASH_LOGICAL_LINE,yytext);}

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
    printf("Token Type = %s, Token Value = %s\n",type,literal);
    char buffer[128];
    sprintf(buffer,"Token Type = %s, Token Value = %s\n",type,literal);
    fputs(buffer,outputFile);  
}
