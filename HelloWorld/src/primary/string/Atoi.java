package primary.string;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */
public class Atoi {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;
        int index = 0, sum = 0, sign = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0) == '+' ? 1 : -1;
            index++;
        }
        while (index < str.length()) {
            if (!Character.isDigit(str.charAt(index)))
                break;
            int temp  = str.charAt(index) - '0';
            if (Integer.MAX_VALUE / 10 < sum || (Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < temp))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sum = sum * 10 + temp;
            index++;
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        String a1 = "42";
        String a2 = "   -42";
        String a3 = "4193 with words";
        String a4 = "words and 987";
        String a5 = "-91283472332";
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi(a1));
        System.out.println(atoi.myAtoi(a2));
        System.out.println(atoi.myAtoi(a3));
        System.out.println(atoi.myAtoi(a4));
        System.out.println(atoi.myAtoi(a5));

        String s = "12a34";
        System.out.println(s.charAt(4) + 1);
    }
}
