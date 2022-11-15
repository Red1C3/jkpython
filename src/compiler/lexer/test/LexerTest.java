package compiler.lexer.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

public class LexerTest {
    private static boolean isWindows;
    private final static String SHELL_BUILD = "flex -o lexer/pythonlexer.c ./lexer/pythonlexer.l && gcc -o lexer/pythonlexer lexer/pythonlexer.c";

    private final static String SHELL_RUN="./lexer/pythonlexer";
    @BeforeAll
    public static void buildLexer() {
        isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        try {
            Process process;
            if (isWindows) {
                System.out.println("NO WINDOWS COMMAND FOR BUILDING LEXER, PLEASE INSERT ONE");
                //TODO windows command for building the lexer
            } else {
                process = new ProcessBuilder("sh","-c",SHELL_BUILD).start();
                assertEquals(0,process.waitFor());
            }
        } catch (IOException e) {
            System.out.println("Failed to start process");
            System.out.println(e);
        } catch (InterruptedException e){
            System.out.println("Failed to wait for process");
            System.out.println(e);
        }
    }

    @Test
    public void test() {
        try {
            System.out.println(runLexer("for"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String runLexer(String input) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (isWindows) {
            System.out.println("NO WINDOWS COMMAND FOR RUNNING THE LEXER, PLEASE INSERT ONE");
            return "";
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

        StringBuilder stringBuilder = new StringBuilder();

        String line;

        while ((line = br.readLine()) != null) {
            stringBuilder.append(line);
        }

        is.close();
        os.close();

        return stringBuilder.toString();
    }
}
