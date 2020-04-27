package practice.hackTheAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class PrefixSumEqualk {
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        if (nums == null)
            return 0;
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < prefix.length; i++) {
            if (set.contains(prefix[i] - k))
                count++;
            set.add(prefix[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        PrefixSumEqualk p = new PrefixSumEqualk();
        System.out.println(p.subarraySumEqualsK(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}, 9));
    }
}
