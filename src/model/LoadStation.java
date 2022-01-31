package model;

public class LoadStation {

	private String tag;
	private boolean busy;
	private int address;
	private static int number = 1;
	private Instruction ins;

	public LoadStation() {
		this.tag = "L" + number;
		this.busy = false;
		number++;
	}

	// --------------------------------------------------Getters----------------------------------------------------------------------

	public int getAddress() {
		return this.address;
	}

	public boolean isBusy() {
		return this.busy;
	}

	public String getTag() {
		return this.tag;
	}
	
	public Instruction getIns() {
		return ins;
	}

	//------------------------------setters--------------------------------------------------
	public void setIns(Instruction ins) {
		this.ins = ins;
	}
	// ------------------------------------------------------------------------------------------------------------------------------

	public void makeBusy(int address) {
		this.busy = true;
		this.address = address;
	}

	public void free() {
		this.busy = false;
		this.address = 0;
		ins = null;
	}
	
	public boolean isReady(int currentCycle) {
		return busy && ins.getIssue()<currentCycle;
	}

}
