package com.bram.caesar;
import java.util.ArrayList;
import java.util.List;

import edu.duke.FileResource;


public class CaesarCipher {
	
    public static void main(String[] args) {
        System.out.println("Encrypt twokeys: \n"+encryptTwoKeys("First Legion",23,17));
    	int key = 3;
    	uppers.clear();
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println("decrypted value is "+decrypted);
    }
    
    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        checkUppers(encrypted);
        String lowerEncrypted = String.valueOf(encrypted).toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for(int i = 0; i < lowerEncrypted.length(); ++i) {
            char curChar = lowerEncrypted.charAt(i);
            int idx = alphabet.indexOf(curChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return toUpper(encrypted).toString();
    }
    
    public static String encryptTwoKeys(String input, int key1, int key2) {
		String key1string = encrypt(input,key1);
		String key2string = encrypt(input,key2);
		String[] inputArray1 = key1string.split("");
		String[] inputArray2 = key2string.split("");
		StringBuilder sb = new StringBuilder();
    	for (int i = 0;i<input.length();i++) {
    		if (i%2 ==0) {
    			sb.append(inputArray1[i]);
    		}
    		else {
    			sb.append(inputArray2[i]);
    		}
    	}
		return sb.toString();
    }

    public static StringBuilder toUpper(StringBuilder encrypted){
        for(int i = 0; i < encrypted.length(); ++i) {
            for (int num : uppers) {
                if (i == num) {
                    encrypted.setCharAt(i, Character.toUpperCase(encrypted.charAt(i)));
                }
            }
        }
        return encrypted;
    }

    public static void checkUppers(StringBuilder encrypted) {
        for (int i=0;i<encrypted.length();i++){
            if (Character.isUpperCase(encrypted.charAt(i))) {
                uppers.add(i);
            }
        }
    }
    
    private static List<Integer> uppers = new ArrayList<>();

}
