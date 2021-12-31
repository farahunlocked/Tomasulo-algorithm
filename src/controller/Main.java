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
		
		//Getting the code and 
		String code = gui.getCodeText();
		String[] codeLines = code.split("\n");
		instructionTable = new InstructionTable(codeLines);
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
