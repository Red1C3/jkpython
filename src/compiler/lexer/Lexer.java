package compiler.lexer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lexer {
    private static boolean isWindows;
    //Run flex and GCC on linux
    private final static String SHELL_BUILD = "flex -o lexer/pythonlexer.c ./lexer/pythonlexer.l && gcc -o lexer/pythonlexer lexer/pythonlexer.c";
    //Run compiled flex file on linux

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

    public void printAllTokens(){
        System.out.printf("%-5s%-10s%-5s%s%n","Type","Literal","Line","Column");
        for (Token token:tokens
             ) {
            System.out.println(token.toString());
        }
        System.out.println("Finished printing tokens");
    }
    //Run flex and GCC on the flex file
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

    public Lexer run(Path path) throws IOException {
        String input = Files.readString(path)+"\n";
        return run(input);
    }
    //Feed *input* into flex stdin and builds Token array out of it and keep it in Lexer class
    public Lexer run(String input) throws IOException {
        cur=0;
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (isWindows) {
//            System.out.println("NO WINDOWS COMMAND FOR RUNNING THE LEXER, PLEASE INSERT ONE");
//            return null;
            processBuilder.command("wsl", "./lexer/pythonlexer");
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

        //Read flex stdout and construct Token array out of it
        while ((line = br.readLine()) != null) {
            String[] items = line.split("[ \n]+");
            if (items.length >= 4) {
                StringBuilder lexeme= new StringBuilder(items[1]);
                //In case a token has a space the regex will split these too, the loop rejoins them
                for (int i=2;i<items.length-2;i++){
                    lexeme.append(" ");
                    lexeme.append(items[i]);
                }
                tokens.add(new Token(Integer.parseInt(items[0]), lexeme.toString(), Integer.parseInt(items[items.length-2]), Integer.parseInt(items[items.length-1])));
            }
            else if (items[0].equals("287")) { //WHITESPACE case
                tokens.add(new Token(Integer.parseInt(items[0]), " ", Integer.parseInt(items[1]), Integer.parseInt(items[2])));
            } else {
                tokens.add(new Token(Integer.parseInt(items[0]), "", Integer.parseInt(items[1]), Integer.parseInt(items[2])));
            }
        }

        is.close();
        os.close();

        this.tokens = tokens.toArray(new Token[0]);

        process.destroy();

        return this;
    }

    public Token[] getTokens() {
        return tokens;
    }
    //Return the next token and advance cur value
    public Token nextToken() {
        if (cur >= tokens.length) {
            return null;
        }
        return tokens[cur++];
    }
    //Return the next token without advancing cur value
    public Token peekToken() {
        if (cur + 1 >= tokens.length) {
            return null;
        }
        return tokens[cur + 1];
    }
}
