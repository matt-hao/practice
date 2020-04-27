package primary.array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (temp == 1) {
                if (digits[i] + 1 >= 10) {
                    digits[i] = 0;
                    if (i == 0) {
                        digits = new int[digits.length + 1];
                        digits[i] = 1;
                    }
                } else {
                    digits[i] += 1;
                    temp = 0;
                }
            } else {
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] a1 = {4, 3, 2, 1};
        int[] a2 = {9, 9, 9, 9, 9};
        int[] a3 = {9};
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(a)));
        System.out.println(Arrays.toString(plusOne.plusOne(a1)));
        System.out.println(Arrays.toString(plusOne.plusOne(a2)));
        System.out.println(Arrays.toString(plusOne.plusOne(a3)));
    }
}
