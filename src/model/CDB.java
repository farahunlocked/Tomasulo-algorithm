package model;

import java.util.ArrayList;

public class CDB {
	
    private ArrayList<BusListener> listeners;
    
    private static CDB cdb;
    
    private CDB() {
    	listeners = new ArrayList<BusListener>();
    }
    
    public static CDB getInstance() {
    	if(cdb == null)
    		cdb = new CDB();
    	return cdb;
    	
    }    
    
    // Notifies all the subscribers to the bus with the data that was written onto it
    public void write(long result, String stationName) {
        for(BusListener l: listeners) {
        	l.onBusWrite(result, stationName);
        }
    }
    
    // method used to add a listener to the list of listeners
    public void addListener(BusListener l) {
    	listeners.add(l);
    }
}
