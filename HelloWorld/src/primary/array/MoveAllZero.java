package primary.array;

import java.util.Arrays;

public class MoveAllZero {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0)
                j++;
            else {
                nums[i] = nums[j];
                if (i++ != j)
                    nums[j] = 0;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        MoveAllZero moveAllZero = new MoveAllZero();
        moveAllZero.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
