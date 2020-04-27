package interview.google.onsite;

import java.util.HashMap;
import java.util.Map;

/**
 * Google | Onsite | Min Number of Powers of 2 to Get an Integer
 * Every number can be described in powers of 2. For example, 29 = 2^0 + 2^2 + 2^3 + 2^4. Given an int n, return minimum number of additions and subtractions of 2^i to get n.
 * <p>
 * Example 1:
 * <p>
 * Input: 15
 * Output: 2
 * Explanation: 2^4 - 2^0 = 16 - 1 = 15
 * Example 2:
 * <p>
 * Input: 8
 * Output: 1
 * Example 3:
 * <p>
 * Input: 0
 * Output: 0
 */
public class MinNumberOfPowerOfTwoToGetAnInteger {

    private int minStep(int num) {
        if (num <= 0) return 0;
        return helper(num, new HashMap<>());
    }

    private int helper(int num, Map<Integer, Integer> map) {
        if (map.containsKey(num)) return map.get(num);
        if (num == 0) return 0;
        if (num == 1) return 1;

        double baseD = Math.log(num) / Math.log(2);
        int base = (int) baseD;
        if ((double)base == baseD) return 1;

        int res = 1 + helper(num - (int) Math.pow(2, base), map);
        base++;
//        if (Math.pow(2, base) - num < num)
            res = Math.min(res, 1 + helper((int) Math.pow(2, base) - num, map));
        map.put(num, res);
        return res;
    }

    public static void main(String[] args) {
        MinNumberOfPowerOfTwoToGetAnInteger m = new MinNumberOfPowerOfTwoToGetAnInteger();
        System.out.println(m.minStep(15));
    }
}
