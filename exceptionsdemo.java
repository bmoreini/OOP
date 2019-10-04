package edu.vtc.oop.bmoreinis;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author bram
 *
 */
public class exceptionsdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		try {
			System.out.print("Enter array size: ");
			int size = console.nextInt();
			int [] a = new int[size];
			
		} catch (NegativeArraySizeException e) {
			System.out.println("Invalid array size.");
		}
		
		try {
			System.out.print("Enter file to open: ");
			String filename = console.nextLine();
			Scanner fileScanner = new Scanner(new File(filename));
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
			

	}
	
	/*
	 * Assigns a new value to array a at position pos
	 * @param a the array
	 * @param pos the position to assign the value
	 * @param value the value to be assigned
	 * throws NullPointerException if a is null 
	 * throws ArrayIndexOutOfBoundsException if pos <0 or pos >a.length
	 */
	
	public static void assign (int [] a, int pos, int value) {
		if (pos==0) throw new NullPointerException("Input parameter was null");
		else if (pos < 0 || pos > a.length) throw new nonFancyArrayException("Unable to assign at index "+pos+" for input array length "+a.length+" this array is not fancy enough.");
		a[pos]=value;
	}
}
