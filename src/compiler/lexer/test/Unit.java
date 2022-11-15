package compiler.lexer.test;

public class Unit {
    private final String input,expected;
    public Unit(String input,String expected){
        this.input=input;
        this.expected=expected;
    }

    public static final Unit GHOST_TEST=new Unit("for",
            buildToken("FOR","for",1,1,true) //TODO make tokens types constss
    );

    public static String buildToken(String type,String literal,int lineNum, int colNum,boolean last){
        if(last){
            return String.format("%-15s%-20s%-5d%d",type,literal,lineNum,colNum);
        }else{
            return String.format("%-15s%-20s%-5d%d\n",type,literal,lineNum,colNum);
        }
    }

    public String getInput(){
        return input;
    }
    public String getExpected(){
        return expected;
    }
}
