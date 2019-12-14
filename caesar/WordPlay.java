package com.bram.caesar;
import java.util.Arrays;
import java.util.List;

/* Coursera Caesar Cipher
 * https://drive.google.com/open?id=1G0JWZ3hy3yJz8pedWHnYD9aTly0MlIV0
 */
public class WordPlay {

	public static void main(String[] args) {
		System.out.println("X is vowel? "+isVowel('x'));
		System.out.println("A is vowel? "+isVowel('a'));
		System.out.println("Cat poop replaceVowel "+replaceVowels("Cat poop", '@'));
		System.out.println("Cat poop emphasize "+emphasize("Cat poop", 'o'));
	}
	
	/* check if character is in array 
	 * see also https://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
	 * List<String> vowelList = Arrays.asList(vowels);
	 * return vowelList.contains(testV);
	 */
	
	public static Boolean isVowel(char ch) {
		String testV = Character.toString(ch);
		boolean vowel = false;
		int vCount = 0;
		while (vowel == false && vCount<5) {
			if (testV == vowels[vCount]) vowel = true;
			vCount ++;
		}
		//return vowel;
		List<String> vowelList = Arrays.asList(vowels);
		return vowelList.contains(testV);
	}
	
	/* Replace vowels with given alt char (e.g. asterisks) 
	 * see https://beginnersbook.com/2014/06/how-to-convert-char-to-string-and-a-string-to-char-in-java/
	 * https://crunchify.com/java-simple-way-to-convert-string-to-char-array/
	 * https://www.geeksforgeeks.org/convert-list-of-characters-to-string-in-java/
	 */
	public static String emphasize (String phrase, char ch) {
		char[] phraseArray = phrase.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<phrase.length();i++) {
			if (phraseArray[i]==ch) {
				if (i%2==0) phraseArray[i] = '*';
				else phraseArray[i]= '+';
			}
			sb.append(phraseArray[i]);
		}
		phrase = sb.toString();
		return phrase;
	}
	
	public static String replaceVowels(String phrase, char ch) {
		char[] phraseArray = phrase.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<phrase.length();i++) {
			if (isVowel((char) phraseArray[i])) {
				phraseArray[i] = ch;
			}
			sb.append(phraseArray[i]);
		}
		phrase = sb.toString();
		return phrase;
	}
	
	private static String[] vowels = {"a", "e", "i", "o", "u"};
}
