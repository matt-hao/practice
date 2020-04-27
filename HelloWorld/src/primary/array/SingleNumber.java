package primary.array;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while (i < nums.length){
            if(i == nums.length - 1)
                return nums[nums.length - 1];
            if (nums[i] != nums[i + 1])
                return nums[i];
            i = i + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 2, 1};
        int[] a2 = {4, 1, 2, 1, 2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(a1));
        System.out.println(singleNumber.singleNumber(a2));
    }
}
