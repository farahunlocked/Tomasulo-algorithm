package model;

public class StoreStation {

	private String tag;
	private boolean busy;
	private double vj;
	private String qj;
	private int address;
	private static int number = 1;
	private Instruction ins;

	public StoreStation() {
		this.tag = "S" + number;
		this.busy = false;
		this.qj = null;
		number++;
	}

	// --------------------------------------------------Getters----------------------------------------------------------------------

	public double getVj() {
		return this.vj;
	}

	public String getQj() {
		return this.qj;
	}

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
	// ------------------------------------------------------------------------------------------------------------------------------

	// if the register is not available
	public void makeBusy(String tag, int address) {
		this.busy = true;
		this.qj = tag;
		this.address = address;
	}

	// if register is available
	public void makeBusy(double data, int address) {
		this.busy = true;
		this.vj = data;
		this.qj = null;
		this.address = address;
	}

	// not ready is now ready so we update
	public void updateSlot(double data) {
		this.vj = data;
		this.qj = null;
	}

	// erases store instruction
	public void free() {
		this.busy = false;
		this.vj = 0.0;
		this.qj = null;
		this.address = 0;
		this.ins = null;
	}
	
	public void setIns(Instruction ins) {
		this.ins = ins;
	}
	
	public boolean isReady(int currentCycle) {
		return busy && ins.getIssue()<currentCycle && qj == null;
	}
}
