package primary.dp;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] store = new int[nums.length];
        Arrays.fill(store, Integer.MIN_VALUE);
        return maxDp(nums.length - 1, nums, store);
    }

    private int maxDp(int n, int[] nums, int[] store) {
        if (n == 0) {
            return store[0] = nums[0];
        }
        if (n == 1) {
            return store[1] = Math.max(nums[0], nums[1]);
        }
        if (store[n] != Integer.MIN_VALUE)
            return store[n];
        return store[n] = Math.max(maxDp(n - 1, nums, store), maxDp(n - 2, nums, store) + nums[n]);
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
