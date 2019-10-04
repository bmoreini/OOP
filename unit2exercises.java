package edu.vtc.oop.bmoreinis;

public class unit2exercises {
	
	public static void main(String[] args) {
		System.out.print(isPrime(7));
	}
	
	public static boolean isPrime(int x){
		// REQUIRES: an integer
		// EFFECTS: If x is an integer greater than 1 and its only prime 
		// factors are itself and 1, returns true; otherwise, returns false.  
		if (x == (int)x && x > 1) {
			for (int i = 2; i <= x/2; i++){
			return (x % i != 0); 
			}
		}
		return false;
	}

}
