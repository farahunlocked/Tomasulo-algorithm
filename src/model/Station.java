package model;

public class Station {

    public boolean busy;
    public String operation;
    public long Vj;
    public long Vk;
    public String Qj;
    public String Qk;
    public long result;

    //------------------------------------------------------getters
    public boolean isBusy() {
        return busy;
    }

    public String getOperation() {
        return operation;
    }

    public long getVj() {
        return Vj;
    }

    public long getVk() {
        return Vk;
    }

    public String getQj() {
        return Qj;
    }

    public String getQk() {
        return Qk;
    }

    public long getResult() {
        return result;
    }


    //---------------------------------------------------------------------setters


    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setVj(long vj) {
        Vj = vj;
    }

    public void setVk(long vk) {
        Vk = vk;
    }

    public void setQj(String qj) {
        Qj = qj;
    }

    public void setQk(String qk) {
        Qk = qk;
    }

    public void setResult(long result) {
        this.result = result;
    }
    //------------------------------------------------------------------------------------------------

    public Station(){
        busy = false;
        operation = null;
        Vj =0;
        Vk =0;
        Qj = null;
        Qk = null;

    }
    // once done delete instruct from reserv bus
    public void removeInstruction(){
        busy = false;
        operation = null;
        Vj = 0;
        Vk =0;
        Qj =null;
        Qk = null;

    }




    // checks if the op for the instructi0n are alllll ready and hasnt exec yet
    public boolean ready(){
        return (busy && Qj == null && Qk == null );
    }




}

