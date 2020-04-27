package primary.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbStairs {
    /*stupid way*/
    public int climbStairs_1(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs_1(n - 1) + climbStairs_1(n - 2);
    }

    /*smart way*/
    public int climbStairs_2(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
        return dp(n - 1, arr);
    }

    private int dp(int n, int[] arr) {
        if (n == 0)
            arr[n] = 1;
        if (n == 1)
            arr[n] = 2;
        if (arr[n] == Integer.MIN_VALUE) {
            arr[n] = dp(n - 1, arr) + dp(n - 2, arr);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs_1(5));

        ClimbStairs climbStairs1 = new ClimbStairs();
        System.out.println(climbStairs1.climbStairs_2(5));
    }
}
