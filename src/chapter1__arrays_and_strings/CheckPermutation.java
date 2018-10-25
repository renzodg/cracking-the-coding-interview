package chapter1__arrays_and_strings;

public class CheckPermutation {

	/*
	 * Given two strings, write a method to decide if one is a permutation of the
	 * other.
	 */

	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] charSet = new int[128];

		for (char c : s1.toCharArray()) {
			charSet[c]++;
		}

		for (char c : s2.toCharArray()) {
			charSet[c]--;
			if (charSet[c] < 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		boolean result = isPermutation("aba", "baa");
		System.out.println(result);
	}
}
