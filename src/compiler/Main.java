package compiler;

import compiler.lexer.Lexer;
import compiler.parser.LexerHelper;
import compiler.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lexer= new Lexer().run("1+1\n");

        lexer.printAllTokens();

        LexerHelper lexerHelper=new LexerHelper(lexer);
        Parser parser=new Parser(lexerHelper);
        parser.parse();
    }
}
