package compiler.lexer.test;

import compiler.lexer.Token;

public record Unit(String input, Token[] expected) {

    public static final Unit GHOST_TEST = new Unit(
            "for\na",
            new Token[]{buildToken("FOR", "for", 1, 1),
            buildToken("NEWLINE","",1,4),
            buildToken("IDENTIFIER","a",1,5)} //TODO make tokens types consts
    );

    public static Token buildToken(String type, String literal, int lineNum, int colNum) {
        return new Token(type, literal, lineNum, colNum);
    }
}
