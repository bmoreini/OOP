package edu.vtc.cis2260.vehicles;

public class GasCar implements Vehicle {
	/** Fuel level in tank - never negative */
	double fuelLevel;
	
	/** Fuel efficiency in miles per gallon - must be positive*/
	double fuelEfficiency;
	
	/** Fuel capacity in miles per gallon - must be positive */
	double fuelCapacity;
	
	void repOK() {
		assert(fuelLevel >= 0);
		assert(fuelEfficiency > 0);
		assert(fuelCapacity > 0);
		assert(fuelLevel <= fuelCapacity);
	}
	/** 
	 * Creates a new car with a full tank of gas
	 * @param fuelEfficiency - fuel efficiency in miles per gallon
	 * @param fuelCapacity - gas tank size in gallons
	 */
	public GasCar(double fuelEfficiency, double fuelCapacity) {
		if (fuelEfficiency <=0) {
			throw new IllegalArgumentException("Illegal fuel efficiency given");
		}
		if (fuelCapacity <=0) {
			throw new IllegalArgumentException("Illegal  fuel capacity given");
		}
		this.fuelEfficiency = fuelEfficiency;
		this.fuelCapacity = fuelCapacity;
		this.fuelLevel = fuelCapacity;
		
		repOK(); // must enable assertion errors -ea for run config run argument
	}

	/**
	 * Drives the car a given distance, reducing the car's fuel level accordingly
	 * @param nMiles
	 */
	public void drive (double nMiles) {
		if (nMiles<0) {
			throw new IllegalArgumentException("Cannot drive "+ nMiles + " miles");
		}
		double range = fuelLevel * fuelEfficiency;
		if (nMiles > range) {
			fuelLevel = 0;
		} else {
			double gasBurned = nMiles / fuelEfficiency;
			fuelLevel -= gasBurned;
		}
		repOK(); // because we changed the state of our object
	}
	/**
	 * Increases fuel level to tank capacity
	 */
	public void fillUp () {
		fuelLevel = fuelCapacity;
		repOK(); // because we changed the state of our object
	}
	
	public void fillUp (double gallons) {
		if (gallons<=0) {
			throw new IllegalArgumentException("Cannot fill "+ gallons + " gallons");
		} else if (fuelLevel + gallons > fuelCapacity){
			throw new IllegalArgumentException(gallons + " exceeds current capacity of " + (fuelCapacity - fuelLevel));
		}else {
			fuelLevel += gallons;
		}
		repOK(); // because we changed the state of our object
	}
	
	public String toString() {
		return String.format("Car: fuel level = %.2f, fuel capacity = %.2f, fuel efficiency = %.2f", fuelLevel, fuelCapacity, fuelEfficiency);
	}
	@Override
	public double getRange() {
		return fuelEfficiency * fuelLevel;
	}
}
