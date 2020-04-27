package primary.other;

public class MissNum {
    public int missingNumber(int[] nums) {
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            sum += nums[i];
        }
        for (int i = 0; i <= max; i++) {
            sum -= i;
        }
        return -sum;
    }

    public static void main(String[] args) {
        MissNum missNum = new MissNum();
        System.out.println(missNum.missingNumber(new int[]{3, 0, 1}));
        System.out.println(missNum.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
