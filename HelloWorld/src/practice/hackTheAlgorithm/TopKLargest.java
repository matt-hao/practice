package practice.hackTheAlgorithm;

import java.util.Arrays;

public class TopKLargest {
    public int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < k)
            return new int[0];
        quickSort(nums, 0, nums.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int left = start;
        int right = end;
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
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    public static void main(String[] args) {
        TopKLargest topKLargest = new TopKLargest();
        System.out.println(Arrays.toString(topKLargest.topk(new int[]{9, 3, 2, 4, 8}, 3)));
    }
}
