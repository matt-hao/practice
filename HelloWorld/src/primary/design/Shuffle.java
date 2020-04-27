package primary.design;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class Shuffle {

    private int[] original;

    public Shuffle(int[] original) {
        this.original = original;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        for (int i = 0; i < copy.length; i++) {
            int s = i + (int) (Math.random() * (copy.length - i));
            int temp = copy[i];
            copy[i] = copy[s];
            copy[s] = temp;

//            copy[i] = copy[i] ^ copy[s];
//            copy[s] = copy[i] ^ copy[s];
//            copy[i] = copy[i] ^ copy[s];
        }
        return copy;
    }


    public int[] shuffer_sim() {
        List<Integer> list = IntStream.of(this.original).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(shuffle.reset()));
        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.reset()));
        System.out.println(Arrays.toString(shuffle.shuffer_sim()));

        int a = 5, b = 6;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);


        int[] c = new int[]{1, 3, 5, 5};
        int[] d = new int[c.length];
        System.arraycopy(c, 0, d, 0, c.length);
        d[2] ^= d[2];
        d[2] ^= d[2];
        d[2] ^= d[2];
        System.out.println(Arrays.toString(d));
    }
}
