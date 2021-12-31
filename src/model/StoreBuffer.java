package model;


public class StoreBuffer implements BusListener{

    static StoreStation[] storeSlots ;



    private StoreBuffer(int size){
        storeSlots= new StoreStation[size];
        
        CDB.getInstance().addListener(this);	// making this object listen to the common data bus
    }





    public static void printContent()
    {
        System.out.println("Store Buffer");



        for(int i=0; i< storeSlots.length; i++)
        {
            StoreStation slot = storeSlots[i];

            String qj = slot.getQj();
            String vj = "" + slot.getVj();
            String address  = "";
            boolean busy = slot.isBusy();
            if(!busy)
            {
                vj = "---";
                qj = "---";
                address = "---";
            }
            else if(!qj.equals("0"))
                vj = "---";

            System.out.println("Tag: " + slot.getTag() + '\t' + "Busy: " + busy + '\t' + "Vj: " + vj + '\t' + "Qj: " + qj + '\t' + "Address: " + address);
        }

        System.out.println('\n');
    }


}
