package interview.amazon.oa;


import java.util.*;

/**
 * Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.
 * <p>
 * Conditions:
 * <p>
 * You will pick exactly 2 numbers.
 * You cannot pick the same element twice.
 * If you have muliple pairs, select the pair with the largest number.
 * Example 1:
 * <p>
 * Input: nums = [1, 10, 25, 35, 60], target = 90
 * Output: [2, 3]
 * Explanation:
 * nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
 * Example 2:
 * <p>
 * Input: nums = [20, 50, 40, 25, 30, 10], target = 90
 * Output: [1, 5]
 * Explanation:
 * nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
 * nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
 * You should return the pair with the largest number.
 */
public class FindPairWithGivenSum {
    public List<Integer> findPair(List<Integer> nums, int target) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.size() == 0) return res;
        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        int largest = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(target - nums.get(i)) && (nums.get(i) > largest || target - nums.get(i) > largest)) {
                res.clear();
                res.add(map.get(target - nums.get(i)));
                res.add(i);
                largest = Math.max(nums.get(i), target - nums.get(i));
            }

            map.put(nums.get(i), i);
        }
        return res;
    }

    public static void main(String[] args) {
        FindPairWithGivenSum findPairWithGivenSum = new FindPairWithGivenSum();
        System.out.println(findPairWithGivenSum.findPair(Arrays.asList(1, 10, 25, 35, 60), 90));
        System.out.println(findPairWithGivenSum.findPair(Arrays.asList(20, 50, 40, 25, 30, 10), 90));
        System.out.println(findPairWithGivenSum.findPair(Arrays.asList(5, 55, 40, 20, 30, 30), 90));
    }
}
