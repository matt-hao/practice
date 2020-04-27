package interview.wePay.oa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Complete the numberOfPairs function in your editor. It has 2 parameters:
 * <p>
 * An array of integers, a.
 * A long integer, k
 * It must return an integer denoting the number of distinct pairs,
 * (ai, aj) where i ≠ j, in a such that ai + aj = k.
 * <p>
 * Note: Pairs(ai, aj) and (aj, ai) are considered to be the same because they are both composed of the same 2 elements; however, while
 * i ≠ j, the value of ai may be equal to aj. In (ai ≡ ak and aj ≡ am) or (ai ≡ am and aj ≡ ak),
 * meaning that both pairs are composed of different elements but the same integer values. See Explanation for more detail.
 * <p>
 * Constraints
 * 1 ≤ n ≤ 5 × 10^5
 * 0 ≤ a[i] ≤10^9
 * <p>
 * 0 ≤ k ≤ 5 × 10^9
 * Input Format
 * <p>
 * The locked stub code assembles the following inputs from stdin and passes them to your function
 * <p>
 * The first line contains an integer,n , denoting the size a. Each of the n subsequent lines describes an element in a
 * . The next line contains an integer, k. Output Format
 * <p>
 * Your function must return the number of pairs of unique/distinct pairs in a having a sum equal to k.
 * <p>Sample Input 0
 * <p>
 * 6 1 3 46 1 3 9
 * <p>
 * 47
 * <p>
 * Sample Output 0
 * <p>
 * 1
 * <p>
 * Sample Input 1
 * <p>
 * 7 6 6 3 9 3 5 1
 * <p>
 * 12
 * <p>
 * Sample Output 1
 * <p>
 * 2
 * <p>
 * Explanation
 * <p>
 * Sample Case 0:
 * <p>
 * a = p[1, 3, 46, 1, 3, 9], k = 47
 * <p>
 * There are 4 pairs of unique elements where ai + aj = k:
 * <p>
 * (a0 = 1, a2 = 46)
 * <p>
 * (a2 = 46, a0 = 1)
 * <p>
 * (a2 = 46, a3 = 1)
 * <p>
 * (a3 = 1, a2 = 46)
 * In the list above, pairs 1 and 2 are equivalent, as are pairs 3 and 4(because they both use the same i and j).
 * In addition, all four pairs contain the same values. Thus, we only 1 distinct pair, (1, 46), so our function returns 1.
 */
public class SumOfTwoNumbers {
    public int numberOfPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(k - nums[i])) {
                Pair temp = new Pair(nums[i], k - nums[i]);
                pairs.add(temp);
            }
            set.add(nums[i]);
        }
        return pairs.size();
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (x == pair.x && y == pair.y) || (x == pair.y && y == pair.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y) + Objects.hash(y, x);
        }
    }

    public static void main(String[] args) {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();

        // Sample Input 0
        // 6 1 3 46 1 3 9
        // 47
        // Sample Output 0
        // 1
        int[] arr1 = new int[]{6, 1, 3, 46, 1, 3, 9};
        int k1 = 47;
        System.out.println(sumOfTwoNumbers.numberOfPairs(arr1, k1));

        // Sample Input 1
        // 6 6 3 9 3 5 1
        // 12
        // Sample Output 1
        // 2
        int[] arr2 = new int[]{6, 6, 3, 9, 3, 5, 1};
        int k2 = 12;
        System.out.println(sumOfTwoNumbers.numberOfPairs(arr2, k2));
    }
}

