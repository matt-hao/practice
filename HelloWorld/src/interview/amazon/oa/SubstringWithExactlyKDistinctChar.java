package interview.amazon.oa;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k distinct characters.
 * If the given string doesn't have k distinct characters, return 0.
 * https://leetcode.com/problems/subarrays-with-k-different-integers
 * <p>
 * Example 1:
 * <p>
 * Input: s = "pqpqs", k = 2
 * Output: 7
 * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
 * Example 2:
 * <p>
 * Input: s = "aabab", k = 3
 * Output: 0
 * Constraints:
 * <p>
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 */
public class SubstringWithExactlyKDistinctChar {
    public int kDistinctChar(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        return mostKDistinctChar(s, k) - mostKDistinctChar(s, k - 1);
    }

    private int mostKDistinctChar(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int p1, p2;
        p1 = p2 = 0;
        int res = 0;
        while (p2 < s.length()) {
            map.put(s.charAt(p2), map.getOrDefault(s.charAt(p2), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(p1), map.get(s.charAt(p1)) - 1);
                if (map.get(s.charAt(p1)) == 0)
                    map.remove(s.charAt(p1));
                p1++;
            }
            res += p2 - p1 + 1;
            p2++;
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringWithExactlyKDistinctChar substringWithExactlyKDistinctChar = new SubstringWithExactlyKDistinctChar();
        String s1 = "pqpqs";
        System.out.println(substringWithExactlyKDistinctChar.kDistinctChar(s1, 2));
        String s2 = "aabab";
        System.out.println(substringWithExactlyKDistinctChar.kDistinctChar(s2, 3));
    }
}
