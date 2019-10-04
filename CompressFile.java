package edu.vtc.oop.bmoreinis;
import java.io.*;
import java.util.ArrayList;

public class CompressFile {
	
	/**
	 * VTC Java OOP
	 * Exercise 4.1:  Implement a "stand-alone" procedure to read in a file containing words and white space and produce 
	 * a compressed version of the file in an output file. The compressed version should contain all of the words in
	 * the input file and none of the white space, except that it should preserve lines.
	 * 
	 * @author Bram
	 */
	 public static void main(String[] args)throws IOException,FileNotFoundException { 
		 String filePath = "/Users/bram/Desktop/testfile";
		 compressFile(filePath);
		 System.out.println("Compressed version located at "+filePath+"-compressed");
	}
	
	 /**
     * Load un-encrypted characters from file, return compressed version (no spaces, but preserved lines)
     * to same location as original file, but with -compressed added to filename. 
     * throws IOException -- though I confess I don't know whether it's redundant to do that in the main
     * method or here, and if not, where these try catches should be. 
     * 
     * @param   String is file path
     * @return  None (rather than return a file, writes file to disk and reports path) 
     */
	
	 public static void compressFile(String filePath) throws IOException,FileNotFoundException {
		ArrayList<String> lines = new ArrayList<>();	 
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    while (br.ready()) {
		        lines.add(br.readLine().replaceAll(" ",""));
		        
		    }
		}
		catch (FileNotFoundException e) {
			System.out.println("No file found at "+filePath);
		}
		catch (IOException e) {
			System.out.println("File at "+filePath+" cannot be read.");
		}
		String newFilePath = filePath+"-compressed";
		try {
			FileWriter writer = new FileWriter(newFilePath); 
			for(String str: lines) {
				writer.write(str + System.lineSeparator());
				}
			writer.close();
			} 
		catch (IOException e) {
			System.out.println("File at "+filePath+"-compressed cannot be written.");
			e.printStackTrace();
		}
	 }
}