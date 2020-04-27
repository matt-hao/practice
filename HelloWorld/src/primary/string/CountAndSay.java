package primary.string;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {
    String countAndSay(int n) {
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char index = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index != s.charAt(i)) {
                sb.append(count).append(index);
                count = 1;
                index = s.charAt(i);
            } else {
                count++;
            }
        }
        if (count != 0) {
            sb.append(count).append(index);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
}
