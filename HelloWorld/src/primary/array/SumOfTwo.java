package primary.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;
        SumOfTwo sumOfTwo = new SumOfTwo();
        System.out.println(Arrays.toString(sumOfTwo.twoSum(a, target)));
    }
}
