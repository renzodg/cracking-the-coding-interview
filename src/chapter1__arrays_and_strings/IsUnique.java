package chapter1__arrays_and_strings;

public class IsUnique {

    /*
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     */

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128)
            return false;

        boolean[] charSet = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i);

            if (charSet[code])
                return false;

            charSet[code] = true;
        }

        return true;
    }

    /* Assumes only letters a through z. */
    public static boolean isUniqueChars2(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isUniqueChars2("123a");
        System.out.println(result);
    }
}
