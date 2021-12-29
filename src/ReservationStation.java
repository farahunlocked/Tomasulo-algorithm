public class ReservationStation {
    public String type; //add nd sub or mult nd divide (general type)
    public boolean busy;
    public String operation;
    public long Vj;
    public long Vk;
    public String Qj;
    public String Qk;
    public long address;
    public long result;



    public ReservationStation(String type){
        this.type = type;
        busy = false;
        operation = null;
        Vj =0;
        Vk =0;
        address = 0;
        Qj = null;
        Qk = null;

    }
    // once done delete instruct from reserv bus
    public void removeInstruction(){
        busy = false;
        operation = null;
        Vj = 0;
        Vk =0;
        address = 0;
        Qj =null;
        Qk = null;

    }


    // checks if the op for the instructi0n are alllll ready and hasnt exec yet
    public boolean ready(){
        return (busy && Qj == null && Qk == null );
    }

    // method for printings
    public void printContent(){

    }


}
