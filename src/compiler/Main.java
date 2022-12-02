package compiler;

import compiler.lexer.Lexer;
import compiler.parser.Parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    private static Lexer lexer;

    private static final String PROMPT = ">>>";

    public static void main(String[] args) {
        lexer = new Lexer();
        if (args.length == 0) {
            runInteractive();
            return;
        }
        try {
            lexer.run(Paths.get(args[0]));

            lexer.printAllTokens();

            Parser parser = new Parser(lexer);
            parser.parse();
        } catch (IOException e) {
            System.out.println("Failed to handle file " + args[0] + "\nError:" + e);
        }
    }

    private static void runInteractive() {
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.print(PROMPT);
        while ((line = scanner.nextLine()) != null) {
            try {
                line += "\n";
                lexer.run(line);
                lexer.printAllTokens(); //TODO if faced an INDENT don't parse until it DEDENTs?
                Parser parser = new Parser(lexer);
                parser.parse();
            } catch (IOException e) {
                System.out.println("Failed to handle line: " + line + "\nError:" + e);
            }
            System.out.print(PROMPT);
        }
        scanner.close();
    }
}
