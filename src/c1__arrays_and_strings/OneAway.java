package c1__arrays_and_strings;

public class OneAway {

	/*
	 * There are three types of edits that can be performed on strings: insert a
	 * character, remove a character, or replace a character. Given two strings,
	 * write a function to check if they are one edit (or zero edits) away.
	 * 
	 * EXAMPLE
	 * 
	 * 
	 * pale, ple -> true
	 * 
	 * pales, pale -> true
	 * 
	 * pale, bale -> true
	 * 
	 * pale, bae -> false
	 */

	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}

	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		int length = s1.length();
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}

				foundDifference = true;
			}
		}
		return true;
	}

	/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "balee";
		String b = "pale";
		boolean isOneEdit = oneEditAway(a, b);
		System.out.println(a + ", " + b + " -> " + isOneEdit);
	}
}
