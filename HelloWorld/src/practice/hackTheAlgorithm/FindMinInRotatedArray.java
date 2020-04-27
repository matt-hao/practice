package practice.hackTheAlgorithm;

public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end])
                end = mid;
            else
                start = mid;
        }
        if (Math.abs(nums[start]) > Math.abs(nums[end]))
            return end;
        else
            return start;
    }

    public static void main(String[] args) {
        FindMinInRotatedArray findMinInRotatedArray = new FindMinInRotatedArray();
        System.out.println(findMinInRotatedArray.findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
