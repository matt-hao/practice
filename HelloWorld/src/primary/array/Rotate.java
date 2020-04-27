package primary.array;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class Rotate {
    //O(n),T(n)
    public void rotate1(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }
    }

    //O(1),T(kn)
    void rotate2(int[] nums, int k) {
        int lastNum;
        while (k-- > 0) {
            lastNum = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = lastNum;
        }
    }

    void rotate3(int[] nums, int k) {
        int lastNum = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - k > 0 ? i - k : nums.length + (i - k)];
        }
        //.....
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        Rotate rotate = new Rotate();
        rotate.rotate2(array1, k1);
        System.out.println(Arrays.toString(array1));

        rotate.rotate1(array2, k1);
        System.out.println(Arrays.toString(array2));

    }
}
