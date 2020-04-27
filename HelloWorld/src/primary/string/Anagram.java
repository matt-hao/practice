package primary.string;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Anagram {
    /**
     * This method apply to String which only contains alphabet
     * Universal Hash
     */
    public boolean isAnagram(String s, String t) {
        int[] temp = new int[26];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * What if the String contains unicode?
     * Use mergeSort to sort the String, which cost O(nlogn)
     * Then check the equality of two String
     * the total cost is O(nlogn)
     */

    public boolean isAnagram_unicode(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        mergeSort(sChar, 0, s.length() - 1);
        mergeSort(tChar, 0, t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            if (sChar[i] != tChar[i])
                return false;
        }

        return true;
    }

    void mergeSort(char[] s, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(s, l, m);
            mergeSort(s, m + 1, r);
            merge(s, l, m, r);
        }
    }

    void merge(char[] s, int l, int m, int r) {
        char[] tempLeft = new char[m - l + 1];
        char[] tempRight = new char[r - m];

        for (int i = 0; i < tempLeft.length; i++) {
            tempLeft[i] = s[l + i];
        }
        for (int i = 0; i < tempRight.length; i++) {
            tempRight[i] = s[m + 1 + i];
        }

        int leftcount = 0, rightcount = 0, k = l;
        while (leftcount < tempLeft.length && rightcount < tempRight.length) {
            if (tempLeft[leftcount] <= tempRight[rightcount]) {
                s[k++] = tempLeft[leftcount++];
            } else {
                s[k++] = tempRight[rightcount++];
            }
        }

        while (leftcount < tempLeft.length) {
            s[k++] = tempLeft[leftcount++];
        }
        while (rightcount < tempRight.length) {
            s[k++] = tempRight[rightcount++];
        }
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();

        String s = "anagram", t = "nagaram";
        System.out.println(anagram.isAnagram(s, t));
        System.out.println(anagram.isAnagram_unicode(s, t));

        String s1 = "rat", t1 = "car";
        System.out.println(anagram.isAnagram(s1, t1));
        System.out.println(anagram.isAnagram_unicode(s1, t1));
    }
}
