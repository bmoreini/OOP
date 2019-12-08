package edu.vtc.cis2260.zoo;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Zoo {
	public static void main(String[] args) {
		Cat athena = new Cat("Athena");
		Cat benjamin = new Cat("Benjamin");
		
		athena.feed("kibble");
		benjamin.feed("lard");
		
		Lion leo = new Lion("Leo");
		Cat larry = new Lion("Larry");
		Animal louis = new Lion("Louis");
		
		leo.feed("steak");
		larry.feed("kibble");
		louis.feed("gazelle");
		
		Set<Animal> zoo = new HashSet<>();
		Collection<Animal> animals = new LinkedList<>();
		zoo.add(leo);
		zoo.add(larry);
		zoo.add(louis);
		
		leo.roar();
		//larry can't roar because he is typed as a cat.  To the outside, he can cat; but to inside, he can lion.
		larry.purr();
		//louis is typed as an animal so he can only eat. 
		
		Lion lawson = new Lion("Larry");
		Lion lewis = new Lion("Louis");
		
		Pangolin pete = new Pangolin("Pete");
		zoo.add(pete);
		feed(zoo,"steak");
		
		Set<Lion> lions = new HashSet<>();
		lions.add(leo);
		lions.add(lawson);
		lions.add(lewis);
		
		System.out.println("Feeding just the lions now ....");
		feed(lions,"gazelle");
		
		addLions(lions, new String[] {"leroy","liz","lance"});
		
		Set<Pangolin>pangos = new HashSet<>();
		pangos.add(pete);
		pangos.add(new Pangolin("Polly"));
		
		//addLions(pangos, new String[] {"scar","nala","simba"});
		specialPrint(pangos);
		
	}
	/**
	 * This is Upper Bounding: using a regular expression based on the superclass
	 * Use this for accessing elements in the collection
	 * This is polymorhpism because it pulls the pangolin-specific toString. 
	 * @param animals
	 * @param food
	 */
	public static void feed(Collection<? extends Animal> animals, String food) {
		for (Animal a : animals) {
			a.feed(food);
		}
	}
	/**
	 * This is Lower Bounding. We use it to modify the collection based on elements 
	 * @param animals
	 * @param names
	 */
	public static void addLions(Collection<? super Lion> animals, String[] names) {
		for (String name : names) {
			animals.add(new Lion(name));
		}
	}
	
	/**
	 * This allows only operations on all Objects. Equals, getclass, toString
	 * @param anything
	 * 
	 */
	public static void specialPrint(Collection<?> anything) {
		for (Object o: anything) {
			System.out.println("Very Special printing .... " + o.toString());
		}
	}
}
