package practice.hackTheAlgorithm;

import java.util.Arrays;

public class TwoClosetSum {
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int p1 = 0, p2 = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum > target) {
                p2--;
            } else {
                p1++;
            }
            int diffAbs = Math.abs(sum - target);
            if (diffAbs <= diff) {
                diff = diffAbs;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                203, 201, 345, 101
        };
        int num = 407;
        TwoClosetSum twoClosetSum = new TwoClosetSum();
        System.out.println(twoClosetSum.twoSumClosest(a, num));
    }
}
