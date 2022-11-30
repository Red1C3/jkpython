package compiler.lexer.test;

import compiler.lexer.Lexer;
import compiler.lexer.Token;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.*;

public class LexerTest {
    private static Lexer lexer;
    @BeforeAll
    public static void buildLexer() {
        lexer=new Lexer();
    }

    @Test
    public void testTest() {
        /*try {
            test(Unit.GHOST_TEST.expected(), lexer.run(Unit.GHOST_TEST.input()).getTokens(),false,false);
        } catch (IOException e) {
            System.out.println(e);
        }*/
    }

    private void test(Token[] expected,Token[] actual,boolean checkLine,boolean checkCol) throws IOException {
        assertEquals(expected.length,actual.length,String.format("Expected length=%d, Actual length=%d",expected.length,actual.length));
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


}
