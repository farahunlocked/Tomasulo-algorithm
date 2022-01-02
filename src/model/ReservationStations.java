package model;

import controller.Main;

public class ReservationStations implements BusListener {
	public Station[] stations;
	public char type; // type can be 'M' or 'A'

	public ReservationStations(int size, char type) {
		stations = new Station[size];
		this.type = type;

		for (int i = 0; i < stations.length; i++) {
			stations[i] = new Station(type + "" + (i+1) );
		}

		CDB.getInstance().addListener(this); // making this object listen to the common data bus
	}

	public Station get(int i) {
		return stations[i];
	}

	public boolean isFull() {
		boolean isfull = true;
		for (Station s : stations) {
			if (!s.isBusy()) {
				isfull = false;
				break;
			}
		}
		return isfull;
	}

	public String issue(Instruction ins) {
		// finding empty station
		Station s = null;
		for (int i = 0;i<stations.length;i++) {
			Station st = stations[stations.length-1-i];
			if (!st.isBusy())
				s = st;
		}

		FP_Registers fp = FP_Registers.getInstance();
		int reg2 = ins.getReg2();
		int reg3 = ins.getReg3();

		// Setting station attributes
		s.setBusy(true);
		s.setOperation(ins.getIns());
		if (fp.getQi(reg2) != null) {
			s.setQj(fp.getQi(reg2));
		} else {
			s.setVj(fp.getReg(reg2));
		}
		if (fp.getQi(reg3) != null) {
			s.setQk(fp.getQi(reg3));
		} else {
			s.setVk(fp.getReg(reg3));
		}
		s.setIns(ins);

		return s.getTag();

	}

	public void checkStart(int currentCycle) {
		
		for(int i = 0;i<stations.length;i++) {
			Station st = stations[i];
			// if it's ready and hasn't started before
			if (st.isReady(currentCycle) && st.getIns().getStart()==-1) {
				st.getIns().setStart(currentCycle);
			}
		}
	}
	
	public void checkFinish(int currentCycle) {
		for(Station st: stations) {
			Instruction ins = st.getIns();
			
			if(ins == null)
				continue;
			if(ins.getStart()==-1) // if instruction hasn't started yet, skip it
				continue;
			if(ins.getWrite()!=-1) // if the instruction has already finished, skip it
				continue;
			
			switch(st.getOperation()) {
				
			case "ADD.D":
				;
			case "ADD":
				// if add finished executing
				if(ins.getStart()+Main.addLatency-1== currentCycle) {
					ins.setFinish(currentCycle);
				}
				// if add is writing onto bus
				else if (ins.getStart()+Main.addLatency == currentCycle) {
					double ans = st.getVj()+st.getVk();
					ins.setWrite(currentCycle);
					CDB.getInstance().write(ans, st.getTag());
					st.removeInstruction();
				}
				break;
			case "SUB.D":
				;
			case "SUB":
				//if sub finished executing
				if(ins.getStart()+Main.subLatency-1== currentCycle) {
					ins.setFinish(currentCycle);
				}
				//if sub is writing onto bus
				else if (ins.getStart()+Main.subLatency == currentCycle) {
					double ans = st.getVj()-st.getVk();
					ins.setWrite(currentCycle);
					CDB.getInstance().write(ans, st.getTag());
					st.removeInstruction();
				}
				break;
			case "MUL.D":
				;
			case "MUL":
				// if mul finished executing
				if(ins.getStart()+Main.mulLatency-1== currentCycle) {
					ins.setFinish(currentCycle);
				}
				// if mul is writing onto bus
				else if (ins.getStart()+Main.mulLatency == currentCycle) {
					double ans = st.getVj()*st.getVk();
					ins.setWrite(currentCycle);
					CDB.getInstance().write(ans, st.getTag());
					st.removeInstruction();
				}
				break;
				
			case "DIV.D":
				;
			case "DIV":
				// if div finished executing
				if(ins.getStart()+Main.divLatency-1== currentCycle) {
					ins.setFinish(currentCycle);
				}
				// if div is writing onto bus
				else if (ins.getStart()+Main.divLatency == currentCycle) {
					double ans = st.getVj()/st.getVk();
					ins.setWrite(currentCycle);
					CDB.getInstance().write(ans, st.getTag());
					st.removeInstruction();
				}
				break;
			
			default: System.out.println("how did you even get here lmao");
			}
			
		}
	}

	public void printContent() {
		if (type == 'M')
			System.out.println("Multiplication/Division Station");
		else
			System.out.println("Addition/Subtraction Station");
		for (int i = 0; i < stations.length; i++) {
			Station slot = stations[i];
			String qj = slot.getQj();
			String vj = "" + slot.getVj();
			String qk = slot.getQk();
			String vk = "" + slot.getVk();
			boolean busy = slot.isBusy();
			if (!busy) {
				vj = "---";
				qj = "---";
				qk = "---";
				vk = "---";

			} else if (qj!= null)
				vj = "---";
			else if (qk!=null)
				vk = "---";

			System.out.println("Tag: " + (i+1) + '\t' + "Op: " + slot.getOperation() + '\t' + "Busy: " + busy + '\t'
					+ "Vj: " + vj + '\t' + "Vk: " + vk + '\t' + "Qj: " + qj + '\t' + "Qk: " + qk + '\t');

		}
		System.out.println('\n');

	}

	@Override
	public void onBusWrite(double result, String tag) {
		for(Station st: stations) {
			if(st.getQj()==tag) {
				st.setQj(null);
				st.setVj(result);
			}
			if(st.getQk() == tag) {
				st.setQk(null);
				st.setVk(result);
			}
		}
 	}
  }
