package chapter1__arrays_and_strings;

public class PalindromePermutation {

	/*
	 * Given a string, write a function to check if it is a permutation of a
	 * palindrome. A palindrome is a word or phrase that is the same forwards and
	 * backwards. A permutation is a rearrangement of letters. The palindrome does
	 * not need to be limited to just dictionary words.
	 * 
	 * EXAMPLE
	 * 
	 * Input: Tact Coa
	 * 
	 * Output: True (permutations: "taco cat", "atco cta", etc.)
	 */

	public static boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[26];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;

				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
	
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

	public static void main(String[] args) {
		String phrase = "Tact Coa";
		boolean result = isPermutationOfPalindrome(phrase);
		System.out.println(result);
	}

}
