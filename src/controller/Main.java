package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.InstructionTable;
import view.GUI;

public class Main implements ActionListener{
	
	GUI gui;
	InstructionTable instructionTable;
	
	public Main() {
		
		gui = new GUI();
		gui.getSimulateButton().addActionListener(this);
		
	}
	
	public void init() {
		
		/*Getting the code and putting it in format: 	[
		 * 													["LD", "F3", "100"],
		 * 													["ADD", "F2", "F4", "F5"]
		 * 												]
		 */
		String code = gui.getCodeText();
		
		String[] codeLines = code.split("\n");
		String codeArr[][] = new String[codeLines.length][];
		
		for(int i = 0;i<codeLines.length;i++) {
			codeArr[i] = codeLines[i].split(" ");
		}
		
		instructionTable = new InstructionTable(codeArr);
		instructionTable.printContent();
	}
	
	public static void main(String[]args)
	{
		Main controller = new Main();
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	//when user submits all the info
		init(); // initialize the objects using the input information
		
	}

}
