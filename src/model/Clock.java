package model;

public class Clock {
	int cycleTime;
	static Clock currentClock = null;

	private Clock() {
		cycleTime = 0;
	}

	static Clock getInstance() {
		if (currentClock == null)
			currentClock = new Clock();
		return currentClock;
	}

	int getCycleTime() {
		return cycleTime;
	}

	void incrementCycleTime() {
		cycleTime++;
	}
}
