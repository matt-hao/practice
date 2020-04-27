package primary.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
            while (i < s.length() && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))))
                i++;
            while (j >= 0 && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))))
                j--;

            if (i == s.length() && j < 0)
                return true;

            if (s.charAt(i) != s.charAt(j))
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome("race a car"));
        System.out.println(palindrome.isPalindrome(",,,,,,,,,"));
    }
}
