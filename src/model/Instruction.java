package model;

public class Instruction {
	private String ins;
	private int reg1;
	private int reg2;
	private int reg3;
	private int issue;
	private int start;
	private int finish;
	private int write;

	public String getIns() {
		return ins;
	}

	public int getReg1() {
		return reg1;
	}

	public int getReg2() {
		return reg2;
	}

	public int getReg3() {
		return reg3;
	}

	public int getIssue() {
		return issue;
	}

	public int getStart() {
		return start;
	}

	public int getFinish() {
		return finish;
	}

	public int getWrite() {
		return write;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public void setWrite(int write) {
		this.write = write;
	}

	public Instruction(String line) {
		String[] lineArr = line.split(" ");

		ins = lineArr[0];
		reg1 = Integer.parseInt(lineArr[1], 1, lineArr[1].length(), 10);

		// Checking if the instruction is one of [ADD, SUB, MUL, DIV]
		if (lineArr.length == 4) {
			reg2 = Integer.parseInt(lineArr[2], 1, lineArr[2].length(), 10);
			reg3 = Integer.parseInt(lineArr[3], 1, lineArr[3].length(), 10);
		} else {
			reg2 = Integer.parseInt(lineArr[2]);
			reg3 = -1;
		}
		issue = -1;
		start = -1;
		finish = -1;
		write = -1;

	}

	public void printContent() {

		String sIssue = issue < 0 ? "" : "" + issue;
		String sStart = start < 0 ? "" : "" + start;
		String sFinish = finish < 0 ? "" : "" + finish;
		String sWrite = write < 0 ? "" : "" + write;

		System.out.print("Instruction: " + ins);
		System.out.print(" | Reg1: F" + reg1);
		if (reg3 < 0) {
			System.out.print(" | Address: " + reg2);
		} else {
			System.out.print(" | Reg2: F" + reg2);
			System.out.print(" | Reg3: F" + reg3);
		}
		System.out.print(" | Issue: " + sIssue);
		System.out.print(" | Start: " + sStart);
		System.out.print(" | Finish: " + sFinish);
		System.out.print(" | Write: " + sWrite);
		System.out.println();

	}

}
