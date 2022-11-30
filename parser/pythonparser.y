%language "Java"
% code imports{
    import java.io.IOException;
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


%
