package model;

public class InstructionTable implements BusListener{
	
    private Instruction[] instructions;

    public InstructionTable(String[] input){
        
    	//initializing the instruction array
    	instructions = new Instruction[input.length];
    	for(int i = 0;i<input.length;i++) {
    		instructions[i] = new Instruction(input[i]);
    	}
    	
    	CDB.getInstance().addListener(this);	// making this object listen to the common data bus
    	
    }

    public void printContent()
    {
    	for(Instruction ins: instructions) {
    		ins.printContent();
    	}

    }

    
	
}
