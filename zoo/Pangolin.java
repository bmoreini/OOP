package edu.vtc.cis2260.zoo;

public class Pangolin extends Animal {

	public Pangolin(String name) {
		super(name);
	}
	
	@Override
	public boolean rightFood(String food) {
		return food.equals("bugs");
	}
	
	@Override
	public String getSpecies() {
		return "pangolin";
	}
	
}
