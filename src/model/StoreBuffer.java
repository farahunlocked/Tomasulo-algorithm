package model;

import controller.Main;



public class StoreBuffer implements BusListener {

	private StoreStation[] storeSlots;

	public StoreBuffer(int size) {
		storeSlots = new StoreStation[size];

		for (int i = 0; i < size; i++) {
			storeSlots[i] = new StoreStation();
		}

		CDB.getInstance().addListener(this); // making this object listen to the common data bus
	}

	public StoreStation get(int i) {
		return storeSlots[i];
	}

    public void checkStart(int currentCycle){
		
		for(int i= 0;i<storeSlots.length;i++){
			StoreStation st = storeSlots[i];
			// if it's ready and hasn't started before
			if(st.isReady(currentCycle) && st.getIns().getStart()==-1) {
				st.getIns().setStart(currentCycle);
			}
		}
	}


	public void checkFinish(int currentCycle){

        		for(StoreStation st: storeSlots){
        			Instruction inst= st.getIns();
        			
        			if(inst == null)
        				continue;
        			if(inst.getStart()==-1) // if instruction hasn't started yet, skip it
        				continue;
        			if(inst.getWrite()!=-1) // if the instruction has already finished, skip it
        				continue;
        			
        			// store finihed last exec cycle
        			if(inst.getStart()+Main.storeLatency -1 ==currentCycle){
    					inst.setFinish(currentCycle);
        			}
        			// store is updating el mem
        			else if(inst.getStart()+Main.storeLatency ==currentCycle){
                    Memory mem = Memory.getInstance();
                    mem.write(st.getAddress(),st.getVj());
                inst.setWrite(currentCycle);    
                st.free();    
                    

        			}
        		}
        	}
	public void issue(Instruction ins) {
		StoreStation s = null;

		for(int i = 0;i<storeSlots.length;i++){
			StoreStation st = storeSlots[storeSlots.length-1-i];
			if (!st.isBusy())
				s = st;
		}

		FP_Registers fp = FP_Registers.getInstance();
		int reg1 = ins.getReg1();
		int reg2 = ins.getReg2();
		if (fp.getQi(reg1) != null) {
			s.makeBusy(fp.getQi(reg1), reg2);
		} else {
			s.makeBusy(fp.getReg(reg1), reg2);
		}
		s.setIns(ins);
	}

	public boolean isFull() {
		boolean isfull = true;
		for (StoreStation s : storeSlots) {
			if (!s.isBusy()) {
				isfull = false;
				break;
			}
		}
		return isfull;
	}

	public void printContent() {
		System.out.println("Store Buffer");

		for (int i = 0; i < storeSlots.length; i++) {
			StoreStation slot = storeSlots[i];

			String qj = slot.getQj();
			String vj = "" + slot.getVj();
			String address = "";
			boolean busy = slot.isBusy();
			if (!busy) {
				vj = "---";
				qj = "---";
				address = "---";
			} else if (!qj.equals("0"))
				vj = "---";

			System.out.println("Tag: " + slot.getTag() + '\t' + "Busy: " + busy + '\t' + "Vj: " + vj + '\t' + "Qj: "
					+ qj + '\t' + "Address: " + address);
		}

		System.out.println('\n');
	}

	@Override
	public void onBusWrite(double result, String tag) {

		for(StoreStation st: storeSlots) {
			if(st.getQj()==tag) {
				st.updateSlot(result);
			}
		}

	}

}
