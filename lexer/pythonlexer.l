%{
    #include <stdio.h>
    #include<ctype.h>
    #include<string.h>
    int indentCounter=0;
%}

keyword  "import"|"nonlocal"|"continue"|"None"|"global"|"in"|"return"|"False"|"True"|"and"|"or"|"not"|"def"|"if"|"else"|"elif"|"for"|"while"|"break"|"pass"|"lambda"

identifier [_a-zA-Z][_a-zA-Z0-9]*

dent [\n]+[\t]*

comment [#][a-zA-Z0-9_]*



number [1-9]([0-9]*|[0-9]*\.[0-9+])


escape \\.

stringcharsingle [^\\\n\']
stringchardouble [^\\\n\"]

stringitemsingle {stringcharsingle}|{escape}
stringitemdouble {stringchardouble}|{escape}

stringsingle \'{stringitemsingle}*\'
stringdouble \"{stringitemdouble}*\"


%%

{keyword} {printf("keyword =%s\n",yytext);}

{dent} {
    int len=0;
    for(int i=0;i<strlen(yytext);++i){
        if(yytext[i]=='\t') len++;
    }

    if (len<indentCounter){
        int tokensCount=indentCounter-len;
        indentCounter=len;
        printf("An dedent was detected with len %d",len);

    }else if (len==indentCounter+1){
        indentCounter=len;
        printf("An indent was detected with len %d",len);
      
    }else if (len!=indentCounter){
      
    }
    printf("indent counter = %d",indentCounter);
    }

\n\r|\r\n|\n|\r {
                 printf("WS\n");  
                }

{comment} {
            printf("comment= %s\n",yytext);
         }

{number} {printf(" Number token = %s\n",yytext);}

"(" {printf("token = %s\n",yytext);} 
")" {printf("token = %s\n",yytext);} 
"{" {printf("token = %s\n",yytext);}
"}" {printf("token = %s\n",yytext);}
"[" {printf("token = %s\n",yytext);}
"]" {printf("token = %s\n",yytext);}
         
":"        { printf(" Column token: %s\n",yytext); }
","        { printf(" Comma token:  %s\n",yytext);}
";"        { printf(" SemiColon token: %s\n",yytext);}

"+"        { printf(" token: %s\n",yytext);}
"-"        { printf(" token: %s\n",yytext);}
"*"        { printf(" token: %s\n",yytext);}
"/"        { printf(" token: %s\n",yytext);}

"<"        { printf(" Less than token: %s\n",yytext);}
">"        { printf(" Greater than token: %s\n",yytext);}
"="        { printf(" Assignment token: %s\n",yytext);}

"."        { printf(" Dot token: %s\n",yytext);}
"%"        { printf(" Percent token: %s\n",yytext);}
"`"        { printf(" Tick token: %s\n",yytext);}

"=="       { printf(" Equal token: %s\n",yytext);}
"!="       { printf(" Not Equal token: %s\n",yytext);}
"<="       { printf(" Less than or equal to token: %s\n",yytext);}
">="       { printf(" Greater than or equal token: %s\n",yytext);} 
"<>"       { printf(" Not equal token: %s\n",yytext);} 
"~"        { printf(" Tilda token: %s\n",yytext);} 

"^"        { printf(" Bitwise XORtoken: %s\n",yytext);}
"<<"       { printf(" Bitwise Shift Left token: %s\n",yytext);}
">>"       { printf(" Bitwise Shift Right token: %s\n",yytext);}

""       { printf(" Power token: %s\n",yytext);}

"+="       { printf(" Addition Assignment token: %s\n",yytext);} 
"-="       { printf(" Subtraction Assignment token: %s\n",yytext);}
"*="       { printf(" Multiplication Assignment token: %s\n",yytext);}
"/="       { printf(" Division Assignment token: %s\n",yytext);}
"%="       { printf(" Remainder Assignment token: %s\n",yytext);}
"&="       { printf(" Bitwise AND Assignment token: %s\n",yytext);}
"&"        { printf(" Bitwise AND token: %s\n",yytext);}
"|"        { printf(" Bitwise OR token: %s\n",yytext);}
"|="       { printf(" Bitwise OR Assignment token: %s\n",yytext);}
"^="       { printf(" Bitwise XOR Assignment token: %s\n",yytext);}
"<<="      { printf(" Bitwise Left Shift Assignment token: %s\n",yytext);}
">>="      { printf(" Bitwise Right Shift Assignment token: %s\n",yytext);}
"**="      { printf(" Power Assignment token: %s\n",yytext);}
"//"       { printf(" Floor Division token: %s\n",yytext);}
"//="      { printf(" Floor Division Assignment token: %s\n",yytext);}

"\\n"      {printf(" Backslash Logical Line token\n");}

{stringsingle} {printf(" Single Quotation String = %s\n",yytext);}
{stringdouble} {printf(" Double Quotation String = %s\n",yytext);}

{identifier} {printf(" Identifier token=%s\n",yytext);} 

. {printf("unknown token = %s\n",yytext);}

%%
int yywrap(){}

int main(){
    yyin=stdin;
    yylex(); 
}