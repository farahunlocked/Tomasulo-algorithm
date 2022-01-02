package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.GUI;

public class Main implements ActionListener {

	GUI gui;
	FP_Registers fp;
	InstructionTable instructionTable;
	StoreBuffer storeBuffer;
	LoadBuffer loadBuffer;
	ReservationStations mulStations;
	ReservationStations addStations;
	GP_Registers gp;

	public static int addLatency;
	public static int subLatency;
	public static int mulLatency;
	public static int divLatency;
	public static int loadLatency;
	public static int storeLatency;

	int cycle = 1;

	public Main() {

		storeBuffer = new StoreBuffer(5);
		loadBuffer = new LoadBuffer(5);
		fp = FP_Registers.getInstance();
		gp = new GP_Registers();
		mulStations = new ReservationStations(2, 'M');
		addStations = new ReservationStations(3, 'A');

		gui = new GUI();
		gui.getSimulateButton().addActionListener(this);

	}

	public void display() {
        System.out.println("Cycle " + cycle + '\n');
		instructionTable.printContent();
		mulStations.printContent();
		addStations.printContent();
		loadBuffer.printContent();
		storeBuffer.printContent();
		fp.printContent();
		gp.printContent();

	}

	public void init() throws Exception {

		// initializing the latency values taken from the gui
		addLatency = Integer.parseInt(gui.getAddLatency());
		subLatency = Integer.parseInt(gui.getSubLatency());
		mulLatency = Integer.parseInt(gui.getMulLatency());
		divLatency = Integer.parseInt(gui.getDivLatency());
		loadLatency = Integer.parseInt(gui.getLdLatency());
		storeLatency = Integer.parseInt(gui.getStLatency());

		// Getting the code
		String code = gui.getCodeText();
		String[] codeLines = code.split("\n");
		instructionTable = new InstructionTable(codeLines);
		
		run();
	}

	private boolean issue(Instruction ins) throws Exception {
		switch (ins.getIns()) {
		case "ADD.D":
			;
		case "ADD":
			;
		case "SUB.D":
			;
		case "SUB":
			if (!addStations.isFull()) {
				// updating station
				String qi = addStations.issue(ins);
				// update fp reg file
				fp.setQi(qi, ins.getReg1());
				// update instruction table
				ins.setIssue(cycle);
				return true;
			}
			break;
		case "MUL.D":
			;
		case "MUL":
			;
		case "DIV.D":
			;
		case "DIV":
			if (!mulStations.isFull()) {
				// updating station
				String qi = mulStations.issue(ins);
				// update fp reg file
				fp.setQi(qi, ins.getReg1());
				// update instruction table
				ins.setIssue(cycle);
				return true;
			}

			break;
		case "L.D":
			;
		case "L":
			if (!loadBuffer.isFull()) {
				// updating load station
				String qi = loadBuffer.issue(ins);
				// updating fp reg fil
				fp.setQi(qi, ins.getReg1());
				// updating instruction table
				ins.setIssue(cycle);
				return true;
			}
			break;
		case "S.D":
			;
		case "S":
			if (!storeBuffer.isFull()) {
				// updating store station
				storeBuffer.issue(ins);
				// updating instruction table
				ins.setIssue(cycle);
				return true;
			}

			break;

		default:
			throw new Exception("Invalid Instruction");
		}

		return false;
	}

	private void checkStart() {

		addStations.checkStart(cycle);
		mulStations.checkStart(cycle);
		loadBuffer.checkStart(cycle);
		storeBuffer.checkStart(cycle);
		
	}

	private void checkFinish() {
		
		addStations.checkFinish(cycle);
		mulStations.checkFinish(cycle);
		loadBuffer.checkFinish(cycle);
		storeBuffer.checkFinish(cycle);

	}

	public void run() throws Exception {
		System.out.println("=========================INITIAL========================");
		boolean finished = false;
		while(!finished) {
			
			if(instructionTable.hasNext()) {
				Instruction ins = instructionTable.getNext();
				if (issue(ins)) {
					instructionTable.onIssue();
				}
			}
			checkStart();
			checkFinish();
			display();
			cycle++;
			
			finished = instructionTable.isFinished();
		}

	}

	public static void main(String[] args) throws Exception {
		Main controller = new Main();


	}

	@Override
	public void actionPerformed(ActionEvent e) { // when user submits all the info
		try {
			init();
		} catch (Exception e1) {
			e1.printStackTrace();
		} // initialize the objects using the input information

	}

}
