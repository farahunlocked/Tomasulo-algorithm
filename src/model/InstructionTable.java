package model;
import java.util.ArrayList;

public class InstructionTable {
    private static ArrayList<String> instructions;

    public InstructionTable(ArrayList<String> input){
        instructions=input;
    }

    public static void printContent()
    {
        System.out.println("Instruction Table");


    }
}
