package model;
import controller.Main;

public class LoadBuffer {

	private LoadStation[] loadSlots;

	public LoadBuffer(int size) {

		loadSlots = new LoadStation[size];

		for (int i = 0; i < size; i++) {
			loadSlots[i] = new LoadStation();
		}
	}

	public boolean isFull() {
		boolean isfull = true;
		for (LoadStation s : loadSlots) {
			if (!s.isBusy()) {
				isfull = false;
				break;
			}
		}
		return isfull;
	}
	
	public void checkStart(int currentCycle){
		
		for(int i = 0;i<loadSlots.length;i++){
			LoadStation st = loadSlots[i];
			// if it's ready and hasn't started before
			if(st.isReady(currentCycle) && st.getIns().getStart()==-1) {
				st.getIns().setStart(currentCycle);
			}
		}
	}

	public void checkFinish(int currentCycle){

    		for(LoadStation st: loadSlots){
    			Instruction inst= st.getIns();
    			
    			if(inst == null)
    				continue;
    			if(inst.getStart()==-1) // if instruction hasn't started yet, skip it
    				continue;
    			if(inst.getWrite()!=-1) // if the instruction has already finished, skip it
    				continue;
    			
    			// load finihed last exec cycle
    			if(inst.getStart()+Main.loadLatency -1 ==currentCycle){
					inst.setFinish(currentCycle);
    			}
    			// load is writing onto the bus 
    			else if(inst.getStart() + Main.loadLatency ==currentCycle){
					Memory mem = Memory.getInstance();
					double ans= mem.read(st.getAddress());
					inst.setWrite(currentCycle);
					CDB.getInstance().write(ans, st.getTag());
					st.free();
                
                
    			}
    		}
    	}

	public String issue(Instruction ins) {

		LoadStation s = null;
		for(int i = 0;i<loadSlots.length;i++){
			LoadStation st = loadSlots[loadSlots.length-1-i];
			if (!st.isBusy())
				s = st;
		}

		int reg2 = ins.getReg2();

		s.makeBusy(reg2);
		s.setIns(ins);

		return s.getTag();
	}

	public void printContent() {
		System.out.println("Load Buffer");

		for (int i = 0; i < loadSlots.length; i++) {
			LoadStation slot = loadSlots[i];

			boolean busy = slot.isBusy();
			String address = slot.getAddress() + "";
			if (!busy)
				address = "---";

			System.out
					.println("Tag: " + slot.getTag() + '\t' + "Busy: " + slot.isBusy() + '\t' + "Address: " + address);
		}

		System.out.println('\n');
	}

}
