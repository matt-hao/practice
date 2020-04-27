package interview.amazon.oa;

import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.
 * The answer is in lowercase.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) return "";

        Set<String> bannedDict = new HashSet<>(Arrays.asList(banned));
        //     String[] words = paragraph.replaceAll("\\pP", " ").split("\\s+");
        String[] words = paragraph.replaceAll("[!?',;.]", " ").toLowerCase().split(" ");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word.equals("") || bannedDict.contains(word)) continue;
            if (!freq.containsKey(word))
                freq.put(word, 0);
            freq.put(word, freq.get(word) + 1);
        }

        int maxFreq = 0;
        String res = "";
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxFreq) {
                res = e.getKey();
                maxFreq = e.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MostCommonWords().mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}
