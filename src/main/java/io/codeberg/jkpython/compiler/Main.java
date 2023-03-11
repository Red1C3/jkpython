package io.codeberg.jkpython.compiler;

import io.codeberg.jkpython.compiler.evaluator.core.BuiltinsContext;
import io.codeberg.jkpython.compiler.lexer.Lexer;
import io.codeberg.jkpython.compiler.parser.Parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static Lexer lexer;

    private static final String PROMPT = ">>>";

    public static void main(String[] args) {
        lexer = new Lexer();
        if (args.length == 0) {
            System.out.println("Interactive mode is broken atm");
            runInteractive();
            return;
        }
        try {
            //Run flex on the input file
            lexer.run(Paths.get(args[0]));

            //Uncomment to print lexer output
            //lexer.printAllTokens();

            Parser parser = new Parser(lexer);
            parser.parse();

            //Uncomment to print AST tree
            //AST.instance().outputGraph();

            //Some global identifiers container
            BuiltinsContext context=new BuiltinsContext();

            parser.program.loadSymbolsTable(context);
            System.out.println(parser.program);

            //program.run evaluates the AST stored in program
            parser.program.run(context);

        } catch (IOException e) {
            System.out.println("Failed to handle file " + args[0] + "\nError:" + e);
        }
    }

    private static void runInteractive() {
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.print(PROMPT);

        //Some global identifiers container, outside the loop to preserve symbols
        BuiltinsContext context=new BuiltinsContext();

        while ((line = scanner.nextLine()) != null) {
            //Run the interpreting process line by line
            try {
                line += "\n";
                lexer.run(line);
                //Uncomment to print lexer output
                //lexer.printAllTokens(); //TODO if faced an INDENT don't parse until it DEDENTs?
                Parser parser = new Parser(lexer);
                parser.parse();

                //program.run evaluates the AST stored in program
                parser.program.run(context);
            } catch (IOException e) {
                System.out.println("Failed to handle line: " + line + "\nError:" + e);
            }
            System.out.print(PROMPT);
        }
        scanner.close();
    }
}
