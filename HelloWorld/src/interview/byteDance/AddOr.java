package interview.byteDance;

import java.util.Scanner;

/**
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * <p>
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据为两个正整数 x , k。 满足 0 < x , k ≤ 2,000,000,000。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数y。
 * <p>
 * <p>
 * 输入例子1:
 * 5 1
 * <p>
 * 输出例子1:
 * 2
 */
public class AddOr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = 0;
        long k = 0;
        if (scanner.hasNextLong())
            x = scanner.nextLong();
        if (scanner.hasNextInt())
            k = scanner.nextInt();

        System.out.println(addor(x, k));
    }

    private static long addor(long x, long k) {
        long num = 0;
        long radix = 1;
        while (k > 0) {
            if ((x & radix) == 0) {
                num += radix * (k & 1);
                k >>= 1;
            }
            radix <<= 1;
        }
        return num;
    }
}
