package edu.vtc.cis2260.zoo;

public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public abstract boolean rightFood(String food);
	public abstract String getSpecies();
	
	public void feed(String food) {
		// Feeding name of animal 'the' species
		System.out.print("Feeding " + this.toString() + " " + food + "...");
		
		if (rightFood(food)) {
			System.out.println("yum!");
		} else {
			System.out.println("yuck!");
		}
	}
	
	public void pet() {
		System.out.println("Petting " + this.toString());
	}
	
	public void pet(int n) {
		for (int i = 0; i < n; i++) {
			pet();
		}
	}
	
	@Override
	public String toString() {
		return name + " the " + getSpecies();
	}
}
