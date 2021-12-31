package model;

import java.util.Arrays;

public class InstructionTable {
    private Instruction[] instructions;

    public InstructionTable(String[] input){
        
    	//finding the maximum length of the split instruction array ie. ["LD", "F2", "300"]
    	
    	
    	instructions = new Instruction[input.length];
    	
    	//initializing the instructions 2d array
    	for(int i = 0;i<input.length;i++) {
    		
    		instructions[i] = new Instruction(input[i]);
    	}
    	
    }

    public void printContent()
    {
    	for(Instruction ins: instructions) {
    		ins.printContent();
    	}


    }
}
