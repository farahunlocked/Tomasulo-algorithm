package model;

public class FP_Registers implements BusListener {
	private double[] FP_Registers; // indexed by register number and contains reg value
	private String[] Qi; // reservation station that the register is waiting for
	private static FP_Registers regs;

	// construct initializes size of arrays (we have 32 FP regs)
	private FP_Registers() {
		FP_Registers = new double[32];
		Qi = new String[32];

		for (int i = 0; i < 32; i++) {
			FP_Registers[i] = i * 10;
		}

		CDB.getInstance().addListener(this); // making this object listen to the common data bus

	}

	public static FP_Registers getInstance() {

		if (regs == null) {
			regs = new FP_Registers();
		}
		return regs;
	}
	// --------------------------------------------------setters

	public void setRegister(int regNum, double value) {

		FP_Registers[regNum] = value;
	}

	public void setQi(String stationName, int regNum) {
		Qi[regNum] = stationName;
	}

	public void clearQi(int regNum) {
		Qi[regNum] = null;
	}

	// ---------------------------------------------------------getters
	public double getReg(int regNum) {

		return FP_Registers[regNum];
	}

	public String getQi(int regNum) {
		return Qi[regNum];
	}

	public void printContent() {

		System.out.println("Floating Point Registers");

		for (int i = 0; i < 32; i++) {
			System.out.println("F" + i + " : " + FP_Registers[i] + '\t' + "Qi: " + Qi[i]);
		}

		System.out.println('\n');
	}

	@Override
	public void onBusWrite(double result, String tag) {
		for(int i = 0;i<Qi.length;i++) {
			String qi = Qi[i];
			if(qi == tag) {
				Qi[i] = null;
				FP_Registers[i] = result;
			}
		}
	}
}
