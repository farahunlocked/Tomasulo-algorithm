package model;

public class LoadBuffer {

     static LoadStation[] loadSlots;



    private LoadBuffer (int size)
    {

        loadSlots =new LoadStation[size];
    }



    public static void printContent()
    {
        System.out.println("Load Buffer");



        for(int i=0; i<loadSlots.length; i++)
        {
            LoadStation slot = loadSlots[i];

            boolean busy = slot.isBusy();
            String address = slot.getAddress() + "";
            if(!busy)
                address = "---";

            System.out.println("Tag: " + slot.getTag() + '\t' + "Busy: " + slot.isBusy() + '\t' + "Address: " + address);
        }

        System.out.println('\n');
    }


}

