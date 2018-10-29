package c1__arrays_and_strings;

public class StringCompression {

	/*
	 * String Compression: Implement a method to perform basic string compression
	 * using the counts of repeated characters. For example, the string aabcccccaaa
	 * would become a2blc5a3. If the "compressed" string would not become smaller
	 * than the original string, your method should return the original string. You
	 * can assume the string has only uppercase and lowercase letters (a - z).
	 */

	public static String compress(String str) {
		int finalLength = countCompression(str);
		
		if (finalLength >= str.length())
			return str;

		StringBuffer compressed = new StringBuffer(finalLength); // initialize capacity
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/* If next character is different than current, append this char to result. */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}

		return compressed.toString();
	}

	public static int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/* If next character is different than current, append this char to result. */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

	public static void main(String[] args) {
		String result = compress("Aaabcccccaa");
		System.out.println(result);
	}
}
