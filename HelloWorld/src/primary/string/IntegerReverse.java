package primary.string;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class IntegerReverse {

    public int reverse(int x) {
        boolean is_Negtive = x < 0;
        x = is_Negtive ? x == Integer.MIN_VALUE ? 0 : -x : x;
        String sx = String.valueOf(x);
        int x_new = 0;
        for (int i = 0; i < sx.length(); i++) {
            x_new += Integer.parseInt(String.valueOf(sx.charAt(i))) * (Math.pow(10, i));
            if (x_new <= Integer.MIN_VALUE || x_new >= Integer.MAX_VALUE) {
                x_new = 0;
                break;
            }
        }
        return is_Negtive ? -x_new : x_new;
    }

    public int reverse1(int x) {
        boolean is_Negtive = x < 0;
        x = is_Negtive ? x == Integer.MIN_VALUE ? 0 : -x : x;
        long l = 0L;
        int remain;
        while (x > 0) {
            remain = x % 10;
            l = l * 10 + remain;
            x = x / 10;

            if (l > Integer.MAX_VALUE)
                return 0;
        }
        return is_Negtive ? -(int) l : (int) l;
    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        System.out.println(integerReverse.reverse1(123));
        System.out.println(integerReverse.reverse1(-123));
        System.out.println(integerReverse.reverse1(120));
        System.out.println(integerReverse.reverse1(-2147483648));
        System.out.println(integerReverse.reverse1(-1534236469));
    }
}
