package model;

public class GP_Registers {
	public static int[] GP_registers;

	public GP_Registers() {
		GP_registers = new int[32];
		for (int i = 0; i < 32; i++) {
			GP_registers[i] = i * 10;
		}
	}

	public void printContent() {

		System.out.println("General Purpose Registers");

		for (int i = 0; i < 32; i++) {
			System.out.println("R" + i + " : " + GP_registers[i]);
		}

		System.out.println('\n');

	}

}
