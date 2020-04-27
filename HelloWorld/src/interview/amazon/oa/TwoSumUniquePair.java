package interview.amazon.oa;

import java.util.Arrays;

/**
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target.
 * Return the number of pairs.
 * <p>
 * Example 1:
 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
 * Output: 2
 * Explanation:
 * 1 + 46 = 47
 * 2 + 45 = 47
 * Example 2:
 * <p>
 * Input: nums = [1, 1], target = 2
 * Output: 1
 * Explanation:
 * 1 + 1 = 2
 * Example 3:
 * <p>
 * Input: nums = [1, 5, 1, 5], target = 6
 * Output: 1
 * Explanation:
 * [1, 5] and [5, 1] are considered the same.
 * Related problems:
 * <p>
 * https://leetcode.com/problems/two-sum
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 */
public class TwoSumUniquePair {
    public int uniquePair(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = 0;
        while (l < r) {
            while (l > 0 && l < r && nums[l] == nums[l - 1]) {
                l++;
            }
            while (r < nums.length - 1 && l < r && nums[r] == nums[r + 1]) {
                r--;
            }
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res++;
                l++;
                r--;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumUniquePair twoSumUniquePair = new TwoSumUniquePair();
        System.out.println(twoSumUniquePair.uniquePair(new int[]{1, 1, 2, 45, 46, 46}, 47));
        System.out.println(twoSumUniquePair.uniquePair(new int[]{1, 1}, 2));
        System.out.println(twoSumUniquePair.uniquePair(new int[]{1, 5, 1, 5}, 6));
    }
}
