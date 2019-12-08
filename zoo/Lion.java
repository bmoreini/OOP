package edu.vtc.cis2260.zoo;

public class Lion extends Cat {
	public Lion(String name) {
		super(name);
	}
	
	@Override
	public boolean rightFood(String food) {
		return food.equals("steak") || food.equals("gazelle");
	}
	
	@Override
	public String getSpecies() {
		return "lion";
	}
	
	public void roar() {
		System.out.println(this.toString() + " says roar!");
	}
}
