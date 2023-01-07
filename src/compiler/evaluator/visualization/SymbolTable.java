package compiler.evaluator.visualization;

import compiler.evaluator.core.Context;

import java.util.ArrayList;

public class SymbolTable {
    private SymbolTable(){}
    private static final SymbolTable symbolTable=new SymbolTable();

    //Contains all scopes in the program
    private final ArrayList<Context> contexts=new ArrayList<>();

    public static SymbolTable instance(){
        return symbolTable;
    }
    public void addContext(Context context){
        contexts.add(context);
    }
    public void removeContext(Context context){
        contexts.remove(context);
    }
    public void print(){
        System.out.println("Symbol Table:");
        System.out.printf("%-5s %-10s %-10s %-5s\n","Scope","Identifier", "Value","Outer");
        for(Context context:contexts){
            //Get all variables in each context
            //k=identifier
            //v=associated PyObject
            context.getVariables().forEach((k,v)->{
                if(context.getParent()!=null){
                    System.out.printf("%-5s %-10s %-10s %-5s\n",context,k,v,context.getParent());
                }else{
                    System.out.printf("%-5s %-10s %-10s %-5s\n",context,k,v,"");
                }
            });

        }
    }
}
