package io.codeberg.jkpython.compiler.lexer;

public class Token {
    private final String literal;
    private final int type;
    public int lineNum, colNum;

    public Token(int type, String literal, int lineNum, int colNum) {
        this.type = type;
        this.literal = literal;
        this.lineNum = lineNum;
        this.colNum = colNum;
    }

    public int getType() {
        return type;
    }

    public String getLiteral() {
        return literal;
    }

    //Check if two tokens are the same
    @Override
    public boolean equals(Object obj) {
        Token other = (Token) obj;
        return type==other.type && literal.equals(other.literal) &&
                lineNum == other.lineNum && colNum == other.colNum;
    }

    //Format the token to a readable string
    @Override
    public String toString() {
        return String.format("%-5s%-10s%-5d%d",type,literal,lineNum,colNum);
    }
}
