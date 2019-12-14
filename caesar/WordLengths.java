package com.bram.caesar;
import java.util.Arrays;
import edu.duke.FileResource;

/* Coursera Caesar Cipher
 * 
 */

public class WordLengths {
	

    /**
     * Read in the words from resource and count the number of words of each
     * length,  storing these counts in the array counts
     * @param   resource    FileResource to be processed
     * @param   counts      integer array for storing counts of word lenghts
     */
	
	public static void countWordLengths(FileResource resource, int[] counts){		
		for(String word : resource.words()){
			int indexCount = Math.min(wordLength(word), counts.length);
			counts[indexCount]++;
		}
	}

    /**
     * Helper function for counting word length, ignoring non-letter chars
     * @param   word    string to be counted
     * @return  number of numeric characters in word
     */
	
    private static int wordLength(String word) {
        int len = 0;
        for (char ch : word.toCharArray()) if (Character.isLetter(ch)) len++;
        return len;
    }
    
    /**
     * This method returns the index position of the largest element in values.
     * @param   values  int array to be searched
     * @return  largest value int values array
     */
    public static int indexOfMax(int[] values) {
    	int max = values[0];
    	for (int i=0;i<values.length;i++) {
    		if (values[i]>max) max = values[i];
    	}
    	return max;
    }
	
	/**
     * Testing countWordLengths method.
     */
    public static void testCountWordLengths() {
		int[] counts = new int[31];
    	FileResource resource = new FileResource();
    	countWordLengths(resource, counts);
		for (int i=1; i<counts.length; i++) {
		    System.out.printf("%d:\t%d\n", i, counts[i]);
		}
		System.out.println("Largest value in array: " + counts[indexOfMax(counts)]);
    }
    
	public static void main(String[] args) {
		testCountWordLengths();
	}	
}

