package practice.hackTheAlgorithm;

import java.util.*;

/**
 * LeetCode 273. Integer to English Words
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntToEngWord {
    private static List<String> list = new ArrayList<>();
    private static List<Integer> triList = new ArrayList<>();
    private static Map<Integer, String> geWei = new HashMap<>();
    private static Map<Integer, String> shiWei = new HashMap<>();
    private static Map<Integer, String> sWei = new HashMap<>();

    static {
        list.add("");
        list.add("Thousand");
        list.add("Million");
        list.add("Billion");
        list.add("Trillion");

        triList.add(1);
        triList.add(2);
        triList.add(3);

        geWei.put(1, "One");
        geWei.put(2, "Two");
        geWei.put(3, "Three");
        geWei.put(4, "Four");
        geWei.put(5, "Five");
        geWei.put(6, "Six");
        geWei.put(7, "Seven");
        geWei.put(8, "Eight");
        geWei.put(9, "Nine");

        shiWei.put(2, "Twenty");
        shiWei.put(3, "Thirty");
        shiWei.put(4, "Forty");
        shiWei.put(5, "Fifty");
        shiWei.put(6, "Sixty");
        shiWei.put(7, "Seventy");
        shiWei.put(8, "Eighty");
        shiWei.put(9, "Ninety");

        sWei.put(10, "Ten");
        sWei.put(11, "Eleven");
        sWei.put(12, "Twelve");
        sWei.put(13, "Thirteen");
        sWei.put(14, "Fourteen");
        sWei.put(15, "Fifteen");
        sWei.put(16, "Sixteen");
        sWei.put(17, "Seventeen");
        sWei.put(18, "Eighteen");
        sWei.put(19, "Nineteen");
    }

    public String numberToWords(int num) {
        int left = 0;
        int cnt1 = 0;

        int cnt = 0;

        LinkedList<String> res = new LinkedList<>();

        while (num != 0) {
            left = num % 1000;
            cnt++;
            if (left > 0) {
                if (cnt > 3) {
                    res.addFirst(list.get(cnt1++));
                }

            }
            num = num / 1000;
        }
        return "";
    }
}
