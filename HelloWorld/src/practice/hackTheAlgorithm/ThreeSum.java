package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int sum = -nums[i];
            twoSum(res, nums, sum, i + 1, nums.length - 1);
        }
        return res;
    }

    private void twoSum(List<List<Integer>> res, int[] nums, int sum, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            while (left > start && left < right && nums[left] == nums[left - 1])
                left++;
            while (right < end && left < right && nums[right] == nums[right + 1])
                right--;
            if (left < right) {
                int temp = nums[left] + nums[right];
                if (temp == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-sum);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                } else if (temp > sum) {
                    right--;
                } else
                    left++;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res= threeSum.threeSum(new int[]{-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5});
        System.out.println(res);
    }
}
