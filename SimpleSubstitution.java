/*
 * Naomi Campbell
 * Info Sec. 2/16/2018
 */

import java.util.*;

public class SimpleSubstitution {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		String cipher;
		System.out.print("Enter in ciphertext you want to decrypt: ");
		cipher = in.next();
		
		// frequency counts
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for(char c: cipher.toCharArray()){
			if (freqMap.get(c) == null){
				freqMap.put(c, 1);
			}
			else{
				freqMap.put(c, (freqMap.get(c)) + 1);
			}
		}
		
		// print counts
		System.out.println("Printing word counts: ");
		for(char c : freqMap.keySet()){
			System.out.println("Char: " + c + ", Frequency: " + freqMap.get(c));
		}
		
		// guess the key
		String guessKey, result;
		char start = 'A';
		System.out.print("Guess a key. Enter 26 letters to replace ABC...Z (e.g. XYZ...A): ");
		Map<Character, Character> keyMap = new HashMap<Character, Character>();
		guessKey = in.next();
		if(guessKey.length() != 26){ // didn't add handling
			System.exit(0);
		}
		for(char c: guessKey.toCharArray()){
			keyMap.put(c, start); // key is cipher letter, easy access
			start++;
		}
		// System.out.println(Arrays.asList(keyMap));
		
		result = "";
		for(int i = 0; i < cipher.length(); i++){
			char newChar = keyMap.get(cipher.charAt(i));
			// System.out.println("PRINTING NEW CHAR: " + newChar);
			result += newChar;
		}
		System.out.println("Decryption result: " + result);
		
		
		System.out.println("Thank you.");
		in.close();
	}
	
}