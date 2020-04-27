package interview.amazon.oa;

import java.util.*;

/**
 * 937. Reorder Data in Log Files
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class RecordLogFile {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return new String[0];
        List<String> digitList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        for (String l : logs) {
            int spaceIdx = l.indexOf(" ");
            if (Character.isDigit(l.charAt(spaceIdx + 1))) {
                digitList.add(l);
            } else {
                strList.add(l);
            }
        }

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);
                if (s1[1].equals(s2[1])) {
                    return s1[0].compareTo(s2[0]);
                }

                return s1[1].compareTo(s2[1]);
            }
        });

        strList.addAll(digitList);
        String[] res = new String[strList.size()];
        int cnt = 0;
        for (String s : strList) {
            res[cnt++] = s;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        RecordLogFile recordLogFile = new RecordLogFile();
        System.out.println(Arrays.toString(recordLogFile.reorderLogFiles(input)));
    }
}
