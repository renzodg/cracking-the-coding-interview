package c1__arrays_and_strings;

import java.util.Arrays;

public class URLify {

	/*
	 * Write a method to replace all spaces in a string with '%20'. You may assume
	 * that the string has sufficient space at the end to hold the additional
	 * characters, and that you are given the "true" length of the string. (Note: If
	 * implementing in Java, please use a character array so that you can perform
	 * this operation in place.)
	 * 
	 * EXAMPLE
	 * 
	 * Input: "Mr John Smith ", 13
	 * 
	 * Output: "Mr%20John%20Smith"
	 */

	public static void replaceSpaces(char[] str, int trueLength) {
		int index = str.length - 1;

		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index] = '0';
				str[index - 1] = '2';
				str[index - 2] = '%';
				index = index - 3;
			} else {
				str[index] = str[i];
				index--;
			}
		}
	}

	public static void main(String[] args) {
		String str = "Mr John Smith 2      ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);
		System.out.println(Arrays.toString(arr));
	}

	private static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}

}
