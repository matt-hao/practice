package practice.hackTheAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HouseRobber2 {

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        System.out.println(houseRobber2.houseRobber2(new int[]{1, 3, 2, 1, 5}));
    }

    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        Map<Pair, Integer> map = new HashMap<>();
        return Math.max(helper(nums, 2, map, true) + nums[0], helper(nums, 1, map, false));
    }

    private int helper(int[] nums, int index, Map<Pair, Integer> map, boolean startFromZero) {
        System.out.println(index + " " + startFromZero);
        Pair p = new Pair(index, startFromZero);
        if (map.containsKey(p)) {
            return map.get(p);
        }

        if (index >= nums.length)
            return 0;

        if (startFromZero && index == nums.length - 1) {
            map.put(p, 0);
            return 0;
        }

        int res = Math.max(helper(nums, index + 2, map, startFromZero) + nums[index],
                helper(nums, index + 1, map, startFromZero));
        map.put(p, res);
        return res;
    }

    class Pair {
        int index;
        boolean startFromZero;

        Pair(int index, boolean startFromZero) {
            this.index = index;
            this.startFromZero = startFromZero;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return p.index == this.index && (p.startFromZero == this.startFromZero);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, startFromZero);
        }
    }
}
