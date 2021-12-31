package model;

public class ReservationStations {
    public static Station[] mult_div;
    public static Station[] add_sub;

    public ReservationStations(int multSize, int addSize){
        mult_div= new Station[multSize];
        add_sub= new Station[addSize];
    }

    public static void printContent()
    {
        System.out.println("Multiplication/Division Station");
        for(int i=0; i<mult_div.length; i++)
        {
            Station mult_slot=mult_div[i];
            String qj = mult_slot.getQj();
            String vj = "" + mult_slot.getVj();
            String qk = mult_slot.getQk();
            String vk = "" + mult_slot.getVk();
            boolean busy = mult_slot.isBusy();
            if(!busy)
            {
                vj = "---";
                qj = "---";
                qk = "---";
                vk = "---";

            }
            else if(!qj.isEmpty())
                vj = "---";
            else if(!qk.isEmpty())
                vk = "---";

            System.out.println("Tag: " + i + '\t' + "Op: " + mult_slot.getOperation() + '\t' + "Busy: " + busy + '\t' + "Vj: " + vj + '\t' + "Vk: " + vk + '\t'  + "Qj: " + qj + '\t' + "Qk: " + qk + '\t' );

        }
        System.out.println('\n');

        System.out.println("Addition/Subtraction Station");
        for(int i=0; i<add_sub.length; i++)
        {
            Station slot=add_sub[i];
            String qj = slot.getQj();
            String vj = "" + slot.getVj();
            String qk = slot.getQk();
            String vk = "" + slot.getVk();
            boolean busy = slot.isBusy();
            if(!busy)
            {
                vj = "---";
                qj = "---";
                qk = "---";
                vk = "---";

            }
            else if(!qj.isEmpty())
                vj = "---";
            else if(!qk.isEmpty())
                vk = "---";

            System.out.println("Tag: " + i + '\t' + "Op: " + slot.getOperation() + '\t' + "Busy: " + busy + '\t' + "Vj: " + vj + '\t' + "Vk: " + vk + '\t'  + "Qj: " + qj + '\t' + "Qk: " + qk + '\t' );

        }
        System.out.println('\n');


    }
}
