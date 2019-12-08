package edu.vtc.cis2260.zoo;

public class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}

	@Override
	public boolean rightFood(String food) {
		return food.equals("kibble") || food.equals("tuna");
	}

	@Override
	public String getSpecies() {
		return "cat";
	}
	
	public void purr() {
		System.out.println(this.toString() + " purrs");
	}
}
