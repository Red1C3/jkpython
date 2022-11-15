package compiler.lexer.test;

import compiler.lexer.Token;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.*;
import java.util.ArrayList;

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
    public void testTest() {
        try {
            test(Unit.GHOST_TEST.expected(), runLexer(Unit.GHOST_TEST.input()),false,false);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void test(Token[] expected,Token[] actual,boolean checkLine,boolean checkCol) throws IOException {
        assertEquals(expected.length,actual.length,"Expected and Actual have different lengths");
        for(int i=0;i< expected.length;i++){
            if(!checkCol){
                expected[i].colNum=0;
                actual[i].colNum=0;
            }
            if (!checkLine) {
                expected[i].lineNum=0;
                actual[i].lineNum=0;
            }
        }
        assertArrayEquals(expected,actual);
    }

    private Token[] runLexer(String input) throws IOException {
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

        ArrayList<Token> tokens=new ArrayList<>();

        String line;

        while ((line = br.readLine()) != null) {
            String[] items=line.split("[ \n]+");
            if(items.length==4){
                tokens.add(new Token(items[0],items[1],Integer.parseInt(items[2]),Integer.parseInt(items[3])));
            }else if (items[0].equals("WHITESPACE")){
                tokens.add(new Token(items[0]," ",Integer.parseInt(items[1]),Integer.parseInt(items[2])));
            }else{
                tokens.add(new Token(items[0],"",Integer.parseInt(items[1]),Integer.parseInt(items[2])));
            }
        }

        is.close();
        os.close();

        return tokens.toArray(new Token[0]);
    }
}
