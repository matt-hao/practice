package practice.hackTheAlgorithm;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {

    //method1: brute force...O(n^3)
    public String longestPalindrome_1(String s) {
        if (s == null || s.length() == 0)
            return "";

        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int left = i, right = j;
                while (right >= left && s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }
                if (right < left && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    //method2: even and odd....O(n ^ 2)
    public String longestPalindrome_2(String s) {
        if (s == null || s.length() == 0)
            return "";

        int startPos = 0, maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            //even condition
            for (int k = i, j = i + 1; j < s.length() && k >= 0; j++, k--) {
                if (s.charAt(k) == s.charAt(j)) {
                    if (j - k + 1 > maxLength) {
                        startPos = k;
                        maxLength = j - k + 1;
                    }
                } else break;
            }

            //odd condition
            for (int k = i - 1, j = i + 1; j < s.length() && k >= 0; j++, k--) {
                if (s.charAt(k) == s.charAt(j)) {
                    if (j - k + 1 > maxLength) {
                        startPos = k;
                        maxLength = j - k + 1;
                    }
                } else break;
            }
        }
        return s.substring(startPos, startPos + maxLength);
    }


    //method3: recursive, dp....O(n ^ 2).....doesn't work and this method has error
//    public String longestPalindrome_3(String s) {
//        if (s == null || s.length() == 0)
//            return "";
//        return palindromeHelper(s, 0, s.length() - 1);
//    }
//
//    String palindromeHelper(String s, int start, int end) {
//        if (start == end)
//            return String.valueOf(s.charAt(start));
//        if (start + 1 == end && s.charAt(start) == s.charAt(end))
//            return s.substring(start, end + 1);
//
//        if (s.charAt(start) == s.charAt(end))
//            return s.charAt(start) + palindromeHelper(s, start + 1, end - 1) + s.charAt(end);
//        else {
//            String s1 = palindromeHelper(s, start + 1, end);
//            String s2 = palindromeHelper(s, start, end - 1);
//            return s1.length() > s.length() ? s1 : s2;
//        }
//
//    }

    //method4: dp....O(n^2) time and space

    //manacher

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.lps("abcda".toCharArray(), 0, 4));

    }

    //this method is used to acquire longest palindrome sequence
    int lps(char seq[], int i, int j) {
        // Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }

        // If the first and last characters match
        if (seq[i] == seq[j]) {
            return lps(seq, i + 1, j - 1) + 2;
        }

        // If the first and last characters do not match
        return Math.max(lps(seq, i, j - 1), lps(seq, i + 1, j));
    }
}

