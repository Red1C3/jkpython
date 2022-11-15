package compiler.lexer;

public class Token {
    private final String literal, type;
    public int lineNum, colNum;

    public Token(String type, String literal, int lineNum, int colNum) {
        this.type = type;
        this.literal = literal;
        this.lineNum = lineNum;
        this.colNum = colNum;
    }

    @Override
    public boolean equals(Object obj) {
        Token other = (Token) obj;
        return type.equals(other.type) && literal.equals(other.literal) &&
                lineNum == other.lineNum && colNum == other.colNum;
    }

    @Override
    public String toString() {
        return String.format("\n%-15s%-20s%-5d%d\n",type,literal,lineNum,colNum);
    }
}
