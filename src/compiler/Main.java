package compiler;

import compiler.lexer.Lexer;
import compiler.parser.LexerHelper;
import compiler.parser.Parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static Lexer lexer;

    private static final String PROMPT=">>>";

    public static void main(String[] args) throws IOException {
        lexer=new Lexer();
        if(args.length==0){
            runInteractive();
            return;
        }

        lexer.run(Paths.get(args[0]));

        lexer.printAllTokens();

        LexerHelper lexerHelper=new LexerHelper(lexer);
        Parser parser=new Parser(lexerHelper);
        parser.parse();
    }

    private static void runInteractive() throws IOException {
        Scanner scanner=new Scanner(System.in);
        String line;
        System.out.print(PROMPT);
        while((line=scanner.nextLine())!=null){
            line+="\n";
            lexer.run(line);
            lexer.printAllTokens(); //TODO if faced an INDENT don't parse until it DEDENTs?
            LexerHelper lexerHelper=new LexerHelper(lexer);
            Parser parser=new Parser(lexerHelper);
            parser.parse();
            System.out.print(PROMPT);
        }
    }
}
