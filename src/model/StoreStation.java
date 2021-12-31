package model;

public class StoreStation {

    private String tag;
    private boolean busy;
    private double vj;
    private String qj;
    private int address;
    private static int number = 1;


    public StoreStation()
    {
        this.tag = "S" + number;
        this.busy = false;
        this.qj = "0";
        number++;
    }

    //--------------------------------------------------Getters----------------------------------------------------------------------

    public double getVj()
    {
        return this.vj;
    }

    public String getQj()
    {
        return this.qj;
    }

    public int getAddress()
    {
        return this.address;
    }

    public boolean isBusy()
    {
        return this.busy;
    }

    public String getTag()
    {
        return this.tag;
    }

    //------------------------------------------------------------------------------------------------------------------------------


   // if the register is not available
    public void makeBusy(String tag, int address)
    {
        this.busy = true;
        this.qj = tag;
        this.address = address;
    }

    // if register is available
    public void makeBusy(double data, int address)
    {
        this.busy = true;
        this.vj = data;
        this.qj = "0";
        this.address = address;
    }

    // not ready is now ready so we update
    public void updateSlot(double data)
    {
        this.vj = data;
        this.qj = "0";
    }

    // erases store instruction
    public void free()
    {
        this.busy = false;
        this.vj = 0.0;
        this.qj = "0";
        this.address = 0;
    }
}
