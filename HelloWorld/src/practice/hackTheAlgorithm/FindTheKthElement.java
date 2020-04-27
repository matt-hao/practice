package practice.hackTheAlgorithm;

public class FindTheKthElement {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
            return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];
        int left = start, right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right)
            return quickSelect(nums, start, right, k);
        if (start + k - 1 >= left)
            return quickSelect(nums, left, end, k - (left - start));

        return nums[right + 1];
    }

    public static void main(String[] args) {
        FindTheKthElement f = new FindTheKthElement();
        System.out.println(f.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
