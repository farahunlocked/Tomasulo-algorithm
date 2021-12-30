package model;
public class FP_Registers {
    private static double[] FP_Registers ; // indexed by register number and contains reg value
    public static String[] Qi; // reservation station that the register is waiting for

    // construct initializes size of arrays (we have 32 FP regs)
    public FP_Registers(){
        FP_Registers = new double[32];
        Qi = new String[32];

        for(int i=0 ; i<32 ;i++){
            FP_Registers[i]=i*10;
        }

    }
    // --------------------------------------------------setters

    public void setRegister(int regNum, long value){

        FP_Registers[regNum] = value;
    }

    public void setQi(String stationName, int regNum){
        Qi[regNum] = stationName;
    }

    //---------------------------------------------------------getters
    public double getReg(int regNum){

        return FP_Registers[regNum];
    }

    public String getQi(int regNum){
        return Qi[regNum];
    }


    public static void printContent(){

    System.out.println("Floating Point Registers");



        for(int i=0; i<32; i++)
    {
        System.out.println("F" + i + " : " + FP_Registers[i] + '\t' + "Qi: " + Qi[i]);
    }

        System.out.println('\n');
    }
}
