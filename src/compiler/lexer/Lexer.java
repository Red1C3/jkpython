package compiler.lexer;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lexer {
    private static boolean isWindows;
    private final static String SHELL_BUILD = "flex -o lexer/pythonlexer.c ./lexer/pythonlexer.l && gcc -o lexer/pythonlexer lexer/pythonlexer.c";

    private final static String SHELL_RUN = "./lexer/pythonlexer";
    private Token[] tokens;
    private int cur = 0;

    public Lexer() {
        buildLexer();
    }

    public Lexer(String input) {
        buildLexer();
        try {
            run(input);
        } catch (IOException e) {
            System.out.printf("Failed to run lexer with input %s\n", input);
            System.out.println(e);
        }
    }

    private void buildLexer() {
        isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        try {
            Process process;
            if (isWindows) {
                System.out.println("NO WINDOWS COMMAND FOR BUILDING LEXER, PLEASE INSERT ONE");
                //TODO windows command for building the lexer
            } else {
                process = new ProcessBuilder("sh", "-c", SHELL_BUILD).start();
                assertEquals(0, process.waitFor());
            }
        } catch (IOException e) {
            System.out.println("Failed to start process");
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println("Failed to wait for process");
            System.out.println(e);
        }
    }

    public Lexer run(String input) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (isWindows) {
            System.out.println("NO WINDOWS COMMAND FOR RUNNING THE LEXER, PLEASE INSERT ONE");
            return null;
            //TODO windows command for running the lexer
        } else {
            processBuilder.command("sh", "-c", SHELL_RUN);
        }
        Process process = processBuilder.start();
        OutputStream os = process.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(input);
        bw.close();

        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        ArrayList<Token> tokens = new ArrayList<>();

        String line;

        while ((line = br.readLine()) != null) {
            String[] items = line.split("[ \n]+");
            if (items.length == 4) {
                tokens.add(new Token(items[0], items[1], Integer.parseInt(items[2]), Integer.parseInt(items[3])));
            } else if (items[0].equals("WHITESPACE")) {
                tokens.add(new Token(items[0], " ", Integer.parseInt(items[1]), Integer.parseInt(items[2])));
            } else {
                tokens.add(new Token(items[0], "", Integer.parseInt(items[1]), Integer.parseInt(items[2])));
            }
        }

        is.close();
        os.close();

        this.tokens = tokens.toArray(new Token[0]);

        return this;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public Token nextToken() {
        if (cur >= tokens.length) {
            return null;
        }
        return tokens[cur++];
    }

    public Token peekToken() {
        if (cur + 1 >= tokens.length) {
            return null;
        }
        return tokens[cur + 1];
    }
}
