%{
    #include <stdio.h>
    #include<ctype.h>
    #include<string.h>

    enum {
        INDENT=258,
        DEDENT,
        NEWLINE,
        NUMBER,
        COMMENT,
        LESS_THAN_OR_EQUAL,
        GREATER_THAN_OR_EQUAL,
        EQUAL,
        NOT_EQUAL,
        NOT_EQUAL_2,
        BITWISE_SHIFT_LEFT,
        BITWISE_SHIFT_RIGHT,
        POWER,
        ADDITION_ASSIGNMENT,
        SUBSTRACTION_ASSIGNMENT,
        MULTIPLICATION_ASSIGNMENT,
        DIVISION_ASSIGNMENT,
        REMAINDER_ASSIGNMENT,
        BITWISE_AND_ASSIGNMENT,
        POWER_ASSIGNMENT,
        BITWISE_OR_ASSIGNMENT,
        BITWISE_XOR_ASSIGNMENT,
        BITWISE_SHIFT_LEFT_ASSIGNMENT,
        BITWISE_SHIFT_RIGHT_ASSIGNMENT,
        FLOOR_DIVISION,
        FLOOR_DIVISION_ASSIGNMENT,
        BACKSLASH_LOGICAL_LINE,
        STRING,
        IDENTIFIER,
        WHITE_SPACE,
        ILLEGAL,
        IMPORT,
        NONLOCAL,
        CONTINUE,
        NONE,
        GLOBAL,
        IN,
        RETURN,
        FALSE_TOK,
        TRUE_TOK,
        AND,
        OR,
        NOT,
        DEF,
        IF,
        ELSE,
        ELIF,
        FOR,
        WHILE,
        BREAK,
        PASS,
        LAMBDA,
        COMMA_LOGICAL_LINE
    };
    
    const char* OUTPUT_FORMAT="%-15d%-20s%-5d%d\n";
    const int TAB_WIDTH=4;

    int colnum=1;
    int linenum=1;
    int bsLogicalLineSpace=1;
    int commaLogicalLineSpace=1;

    //Keeps track of the current indentation
    int indentCounter=0;

    FILE* inputFile=NULL, *outputFile=NULL;

    //Outputs tokens data (type, lexeme, line number and column number) to stdout and outputFile
    void handleToken(int type, const char* literal);
%}

identifier [_a-zA-Z][_a-zA-Z0-9]*

newline \n|\r|\n\r|\r\n

 //For cases where a line ends in a comma and there is still stuff after the comma, like function parameters
commalogicalline ,{newline}[\t]*

 //A backslash indicates that the current line is not finished yet and will continue in the next line
bslogicalline \\{newline}[\t]*

 //Deals with both indentations and dedentations, consuming all newlines which does not satisfy commalogicalline
 //or bslogicalline in the process
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

 //The next regexes are string-related only covering both normal strings and
 //long ones (strings that span over multiple lines)
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

	//If the newline indents are less than the previous, insert (current line indents - prev line indents) dedents
    if (len<indentCounter){
        int tokensCount=indentCounter-len;
        indentCounter=len;
        for(int i=0;i<tokensCount;++i)
        	handleToken(DEDENT,"");

    }else if (len==indentCounter+1){ //If the newline indents are more than the prev by one, insert a single indent
        indentCounter=len;
        handleToken(INDENT,"");
      
    }else if (len!=indentCounter){ //Otherwise is not valid
    	handleToken(ILLEGAL,yytext);
    }
}


{comment} {
            handleToken(COMMENT,yytext);
         }

{number} {handleToken(NUMBER,yytext);}

"(" {handleToken(yytext[0],yytext);} 
")" {handleToken(yytext[0],yytext);} 
"{" {handleToken(yytext[0],yytext);}
"}" {handleToken(yytext[0],yytext);}
"[" {handleToken(yytext[0],yytext);}
"]" {handleToken(yytext[0],yytext);}
         
":"        { handleToken(yytext[0],yytext);}
","        { handleToken(yytext[0],yytext);}
";"        { handleToken(yytext[0],yytext);}

"+"        { handleToken(yytext[0],yytext);}
"-"        { handleToken(yytext[0],yytext);}
"*"        { handleToken(yytext[0],yytext);}
"/"        { handleToken(yytext[0],yytext);}

"<"        { handleToken(yytext[0],yytext);}
">"        { handleToken(yytext[0],yytext);}
"="        { handleToken(yytext[0],yytext);}

"."        { handleToken(yytext[0],yytext);}
"%"        { handleToken(yytext[0],yytext);}
"`"        { handleToken(yytext[0],yytext);}

"=="       { handleToken(EQUAL,yytext);}
"!="       { handleToken(NOT_EQUAL,yytext);}
"<="       { handleToken(LESS_THAN_OR_EQUAL,yytext);}
">="       { handleToken(GREATER_THAN_OR_EQUAL,yytext);} 
"<>"       { handleToken(NOT_EQUAL_2,yytext);} 
"~"        { handleToken(yytext[0],yytext);} 

"^"        { handleToken(yytext[0],yytext);}
"<<"       { handleToken(BITWISE_SHIFT_LEFT,yytext);}
">>"       { handleToken(BITWISE_SHIFT_RIGHT,yytext);}

"**"       { handleToken(POWER,yytext);}

"+="       { handleToken(ADDITION_ASSIGNMENT,yytext);} 
"-="       { handleToken(SUBSTRACTION_ASSIGNMENT,yytext);}
"*="       { handleToken(MULTIPLICATION_ASSIGNMENT,yytext);}
"/="       { handleToken(DIVISION_ASSIGNMENT,yytext);}
"%="       { handleToken(REMAINDER_ASSIGNMENT,yytext);}
"&="       { handleToken(BITWISE_AND_ASSIGNMENT,yytext);}
"&"        { handleToken(yytext[0],yytext);}
"|"        { handleToken(yytext[0],yytext);}
"|="       { handleToken(BITWISE_OR_ASSIGNMENT,yytext);}
"^="       { handleToken(BITWISE_XOR_ASSIGNMENT,yytext);}
"<<="      { handleToken(BITWISE_SHIFT_LEFT_ASSIGNMENT,yytext);}
">>="      { handleToken(BITWISE_SHIFT_RIGHT_ASSIGNMENT,yytext);}
"**="      { handleToken(POWER_ASSIGNMENT,yytext);}
"//"       { handleToken(FLOOR_DIVISION,yytext);}
"//="      { handleToken(FLOOR_DIVISION_ASSIGNMENT,yytext);}

{commalogicalline} {
						//Count the tabs so that the column number stays correct when handling the token
                        int tabsCount=0;
                        for(int i=0;i<strlen(yytext);++i){
                            if (yytext[i]=='\t') tabsCount++;
                        }
                        commaLogicalLineSpace=tabsCount;
                        handleToken(COMMA_LOGICAL_LINE,",");
}

{bslogicalline}     {
						//Count the tabs so that the column number stays correct when handling the token
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

" " {handleToken(WHITE_SPACE," ");}

. {handleToken(ILLEGAL,yytext);}

%%
int yywrap(){
	//yywrap is called when yylex finishes, so it basically closes the opened files and exits the process
	if(inputFile!=NULL)
	    fclose(inputFile);
    fclose(outputFile);
    exit(0);
}

int main(int argc,const char** argv){
	//No argument provided, argc counts the executable as an argument too...
    if(argc==1){
        yyin=stdin;
    } //Input file provided
    else{
        inputFile=fopen(argv[1],"r");
        yyin=inputFile;
    }
    outputFile=fopen("./tokens.txt","w");
    yylex(); 
}

void handleToken(int type,const char* literal){
	//Count white space as a column and emit no token
	if(type == WHITE_SPACE){
		colnum++;
		return;
	}
    if(type == NEWLINE) {
        colnum=1;
        colnum+=(indentCounter*TAB_WIDTH);
        linenum++;
    }

	//Output to stdout
    printf(OUTPUT_FORMAT,type,literal,linenum,colnum);

	//Create a string so it can be output to the outputFile
    char buffer[128];
    sprintf(buffer,OUTPUT_FORMAT,type,literal,linenum,colnum); //Writes the formatted string in buffer
    fputs(buffer,outputFile); //writes the buffer in outputFile
    colnum+=strlen(literal);

    if(type == INDENT || type == DEDENT){ // INDENT/DEDENT changes are calculated after emitting
        colnum=1;                         // NEWLINE token
        colnum+=(indentCounter*4);
    }

    if(type == BACKSLASH_LOGICAL_LINE){
        colnum=1;
        colnum+=(bsLogicalLineSpace*TAB_WIDTH);
        linenum++;
    }
    if(type == COMMA_LOGICAL_LINE){
    	colnum=1;
        colnum+=(commaLogicalLineSpace*TAB_WIDTH);
        linenum++;
    }
}
