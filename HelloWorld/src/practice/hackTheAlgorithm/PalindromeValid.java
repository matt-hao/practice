package practice.hackTheAlgorithm;

/**
 * 125.Valid Palindrome
 * Example
 * "A man, a plan, a canal: Panama" is a palindrome.
 * <p>
 * "race a car" is not a palindrome.
 * <p>
 * Challenge
 * O(n) time without extra memory.
 * <p>
 * note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class PalindromeValid {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
            while (i < s.length() && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))))
                i++;
            while (j >= 0 && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))))
                j--;

            if (i >= s.length() && j < 0)
                return true;

            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
