package interview.amazon.oa;

import java.util.Arrays;

/**
 * 533. Two Sum - Closest to target
 * Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
 * <p>
 * Return the absolute value of difference between the sum of the two integers and the target.
 * <p>
 * Example
 * Example1
 * <p>
 * Input:  nums = [-1, 2, 1, -4] and target = 4
 * Output: 1
 * Explanation:
 * The minimum difference is 1. (4 - (2 + 1) = 1).
 * Example2
 * <p>
 * Input:  nums = [-1, -1, -1, -4] and target = 4
 * Output: 6
 * Explanation:
 * The minimum difference is 6. (4 - (- 1 - 1) = 6).
 * Challenge
 * Do it in O(nlogn) time complexity.
 */
public class TwoSumCloset {
    /**
     * @param nums:   an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        // long res = Integer.MAX_VALUE;
        // while(l < r){
        //     long sum = (long)nums[l] + (long)nums[r];
        //     res = Math.min(res, Math.abs(sum - target));
        //     if(sum == target){
        //         return 0;
        //     }
        //     if(sum > target){
        //         r--;
        //     }else{
        //         l++;
        //     }
        // }
        // return (int) res;
        int res = Integer.MAX_VALUE;
        while (l < r) {
            int sum = nums[l] + nums[r];
            res = Math.min(res, Math.abs(sum - target));
            if (sum == target) {
                return 0;
            }
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TwoSumCloset().twoSumClosest(new int[]{-1, 2, 1, -4}, 4));
    }
}
