package practice.hackTheAlgorithm;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0)
            return paragraph;
        if (banned == null || banned.length == 0)
            return null;
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));

        String[] words = paragraph.replaceAll("\\pP", " ").split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (word == null || word.length() == 0 || banSet.contains(word) || !handler(word))
                continue;
            word = word.toLowerCase();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        String result = "";
        int count = Integer.MIN_VALUE;
        for (String word : map.keySet()) {
            if (map.containsKey(word) && map.get(word) > count) {
                count = map.get(word);
                result = word;
            }
        }
        return result;
    }

    private boolean handler(String word) {
        String regex = ".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(word);
        return m.matches();
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] words = new String[]{"hit"};
        System.out.println(mostCommonWord.mostCommonWord(p, words));
    }
}
