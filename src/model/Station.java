package model;

public class Station {

	private boolean busy;
	private String operation;
	private double Vj;
	private double Vk;
	private String Qj;
	private String Qk;
	private double result;
	private String tag;
	private Instruction ins;

	// ------------------------------------------------------getters
	public boolean isBusy() {
		return busy;
	}

	public String getOperation() {
		return operation;
	}

	public double getVj() {
		return Vj;
	}

	public double getVk() {
		return Vk;
	}

	public String getQj() {
		return Qj;
	}

	public String getQk() {
		return Qk;
	}

	public double getResult() {
		return result;
	}

	public String getTag() {
		return tag;
	}
	
	public Instruction getIns() {
		return ins;
	}

	// ---------------------------------------------------------------------setters

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setVj(double vj) {
		Vj = vj;
	}

	public void setVk(double vk) {
		Vk = vk;
	}

	public void setQj(String qj) {
		Qj = qj;
	}

	public void setQk(String qk) {
		Qk = qk;
	}
	
	public void setIns(Instruction ins) {
		this.ins = ins;
	}

	public void setResult(double result) {
		this.result = result;
	}
	// ------------------------------------------------------------------------------------------------

	public Station(String tag) {
		busy = false;
		operation = null;
		Vj = 0;
		Vk = 0;
		Qj = null;
		Qk = null;
		this.tag = tag;
		ins = null;

	}

	// once done delete instruct from reserv bus
	public void removeInstruction() {
		busy = false;
		operation = null;
		Vj = 0;
		Vk = 0;
		Qj = null;
		Qk = null;
		ins = null;
	}

	// checks if the op for the instructi0n are alllll ready and hasnt exec yet
	public boolean isReady(int currentCycle) {
		return (busy && Qj == null && Qk == null && ins.getIssue()<currentCycle);
	}

}
