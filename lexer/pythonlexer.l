%{
    #include <stdio.h>
    #include<ctype.h>
%}

keyword  "nonlocal"|"continue"|"None"|"global"|"in"|"return"|"False"|"True"|"and"|"or"|"not"|"def"|"if"|"else"|"elif"|"for"|"while"|"break"|"pass"|"lambda"
            
identifier [_a-zA-Z][_a-zA-Z0-9]*


number [1-9]([0-9]*|[0-9]*\.[0-9+])

 //quote1 "\'"[^'\\']*"\'"  
 //quote2 "\""[^"\\"]*"\""

 // quote3 \"[^\"]*\" 

%%
\n\r|\r\n|\n|\r {
                   
                }
"#"             {
                   
                }

{keyword} { 
          printf("keyword =%s\n",yytext);}

{identifier} {
            printf("identifier token=%s\n",yytext);
            } 

          

"(" {printf("token = %s\n",yytext);}
")" {printf("token = %s\n",yytext);}
"{" {printf("token = %s\n",yytext);}
"}" {printf("token = %s\n",yytext);}
"[" {printf("token = %s\n",yytext);}
"]" {printf("token = %s\n",yytext);}


%%
int yywrap(){}

int main(){
    yyin=stdin;
    yylex(); 
} 
