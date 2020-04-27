package primary.string;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class UniqueChar {
    //stupid. The worse case is O(n^2)
    int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean isDup = false;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    isDup = true;
                    break;
                }
            }
            if (isDup)
                continue;

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isDup = true;
                    break;
                }
            }
            if (isDup)
                continue;
            return i;
        }
        return -1;
    }

    //better. O(n)
    int firstUniqChar_1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        UniqueChar uniqueChar = new UniqueChar();
        System.out.println(uniqueChar.firstUniqChar_1("leetcode"));
        System.out.println(uniqueChar.firstUniqChar_1("loveleetcode"));
        System.out.println(uniqueChar.firstUniqChar_1("ccas"));
        System.out.println(uniqueChar.firstUniqChar_1("abc"));
        System.out.println(uniqueChar.firstUniqChar_1("aabbcc"));
    }
}
