package model;

public class Memory {
	private double[] mem;
	private static Memory memory;
	
	private Memory() {
		mem = new double[4096];
		
		for(int i = 0;i<4096;i++) {
			mem[i] = i;
		}
	}
	
	public static Memory getInstance() {
		if(memory == null)
			memory = new Memory();
		return memory;
	}
	
	public double read(int i) {
		return mem[i];
	}
	
	public void write(int i, double val) {
		mem[i] = val;
	}
	
}
