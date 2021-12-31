package model;

public class ReservationStations implements BusListener{
    public Station[] stations;
    public char type; // type can be 'M' or 'A'
    
    public ReservationStations(int size, char type){
        stations= new Station[size];
        this.type = type;
        
        
        CDB.getInstance().addListener(this);	// making this object listen to the common data bus
    }

    public Station get(int i) {
    	return stations[i];
    }
    
    public void printContent()
    {
    	if(type == 'M')
    		System.out.println("Multiplication/Division Station");
    	else
    		System.out.println("Addition/Subtraction Station");
        for(int i=0; i<stations.length; i++)
        {
            Station slot=stations[i];
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
