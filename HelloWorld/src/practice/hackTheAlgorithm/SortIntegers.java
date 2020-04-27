package practice.hackTheAlgorithm;

public class SortIntegers {
    public void sortIntegers2(int[] nums) {
        // write your code here
        //quickSort
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int left = start, right = end;
        int pivot = nums[left + (right - left) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot)
                left++;
            while (left <= right && nums[right] > pivot)
                right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        helper(nums, start, right);
        helper(nums, left, end);
    }

    public static void main(String[] args) {
        SortIntegers s = new SortIntegers();
        s.sortIntegers2(new int[]{1,2,2,1,2,1,2});
    }
}
