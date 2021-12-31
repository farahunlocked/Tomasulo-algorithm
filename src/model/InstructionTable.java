package model;

import java.util.Arrays;

public class InstructionTable {
    private String[][] instructions;

    public InstructionTable(String[][] input){
        
    	//finding the maximum length of the split instruction array ie. ["LD", "F2", "300"]
    	int maxLength = 3;
    	for(String[] line: input) {
    		if(line.length==4);
    		maxLength = 4;
    		break;
    	}
    	
    	instructions = new String[input.length][maxLength+4];
    	
    	//initializing the instructions 2d array
    	for(int i = 0;i<input.length;i++) {
    		
    		for(int j = 0;j<3;j++) {
    			instructions[i][j] = input[i][j];
    		}
    		if(input[i].length>3) {
    			instructions[i][3] = input[i][3];
    		}
    		else
    			instructions[i][3] = "";
    		for(int j = 4; j<maxLength+4;j++) {
    			instructions[i][j] = "";
    		}
    	}
    	
    }
    
    public void printContent() {
    	System.out.println(Arrays.deepToString(instructions));
    }


}
