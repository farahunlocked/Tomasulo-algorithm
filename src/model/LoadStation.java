package model;


public class LoadStation {

    private String tag;
    private boolean busy;
    private int address;
    private static int number = 1;

    public LoadStation()
    {
        this.tag = "L" + number;
        this.busy = false;
        number++;
    }


    //--------------------------------------------------Getters----------------------------------------------------------------------


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



    public void makeBusy(int address)
    {
        this.busy = true;
        this.address = address;
    }

    public void free()
    {
        this.busy = false;
        this.address = 0;
    }


}

