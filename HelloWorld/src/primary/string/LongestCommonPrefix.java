package primary.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String longestString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(longestString)) {
                int j = 0;
                for (; j < longestString.length() && j < strs[i].length(); j++) {
                    if (longestString.charAt(j) != strs[i].charAt(j))
                        break;
                }
                longestString = longestString.substring(0, j);
                if (longestString.length() == 0)
                    break;
            }
        }
        return longestString;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] arr1 = {"flower", "flow", "flight"};
        String[] arr2 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix.longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr2));

    }
}
