package edu.vtc.cis2260.vehicles;

public class PlugInHybrid extends GasCar {
	/** number of miles car can drive on electric power */
	private double batteryRange;
	
	private double batteryLeft;

	void repOK() {
		super.repOK();
		assert(batteryRange >= 0);
	}
	
	public PlugInHybrid(double fuelEfficiency, double fuelCapacity, double batteryRange) {
		super(fuelEfficiency, fuelCapacity);
		this.batteryRange = batteryRange;
	}
	
	@Override
	public void drive(double nMiles) {
		if (batteryRange > 0) {
			if (batteryRange > nMiles) {
				batteryRange -= nMiles;
				repOK();
				return;
			} else {
				batteryLeft = batteryRange;
				batteryRange = 0;
				super.drive(nMiles-batteryLeft);
			}
		}
		else {
			super.drive(nMiles);
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("Car: fuel level = %.2f, fuel capacity = %.2f, fuel efficiency = %.2f, battery left = %.2f", fuelLevel, fuelCapacity, fuelEfficiency, batteryRange);
	}
	
	public void charge() {
		batteryRange = 100;
	}
	
	public double getRange() {
		return (fuelEfficiency * fuelLevel) + batteryRange;
	}
}
