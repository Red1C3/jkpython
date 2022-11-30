package compiler.parser;

import compiler.lexer.Token;
import compiler.lexer.Tokens;

public class LexerHelper implements Parser.Lexer {
    private compiler.lexer.Lexer lexer;

    public LexerHelper(compiler.lexer.Lexer lexer) {
        this.lexer = lexer;
    }

    public void yyerror(String s) {
        System.err.println(s);
    }

    private Object yylval;

    public Object getLVal() {
        return yylval;
    }

    public int yylex() {
        Token token = lexer.nextToken();
        if (token == null) {
            return YYEOF;
        }
        switch (token.getType()) {
            case Tokens.NUMBER:
                yylval = Double.parseDouble(token.getLiteral());
                return NUMBER;
            case Tokens.NEWLINE:
                return (int) '\n';
            default:
                return token.getType();
        }
    }
}
