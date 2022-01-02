package model;

public class InstructionTable {

	private Instruction[] instructions;
	private int toBeIssued = 0;

	public InstructionTable(String[] input) {

		// initializing the instruction array
		instructions = new Instruction[input.length];
		for (int i = 0; i < input.length; i++) {
			instructions[i] = new Instruction(input[i]);
		}


	}

	public void printContent() {
		for (Instruction ins : instructions) {
			ins.printContent();
		}
		System.out.println();

	}

	public boolean isFinished() {
		boolean res = true;
		for(Instruction i : instructions)
			if(i.getWrite()==-1) {
				res = false;
				break;
			}
		
		return res;
	}
	
	public Instruction getNext() {
		return instructions[toBeIssued];
	}

	public boolean hasNext() {
		return toBeIssued < instructions.length; 
	}

	public void onIssue() {
		toBeIssued++;
	}


}
