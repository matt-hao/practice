package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMedian {
    /**
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0)
            return list;
        for (int i = 0; i <= nums.length - k; i++) {
            list.add(findMedian(nums, k, i, i + k - 1));
        }
        return list;
    }

    private int findMedian(int[] nums, int k, int start, int end) {
        int[] m = new int[k];
        for (int i = 0; i < k; i++) {
            m[i] = nums[start + i];
        }
        //merge sort
        mergeSort(m, 0, m.length - 1, new int[m.length]);
        return m[(k - 1) / 2];
    }

    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, end, temp);
    }

    private void merge(int[] nums, int start, int end, int[] temp) {
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex])
                temp[index++] = nums[leftIndex++];
            else
                temp[index++] = nums[rightIndex++];
        }

        while (leftIndex <= mid) {
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = nums[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        System.out.println(s.medianSlidingWindow(new int[]{1, 2, 7, 7, 2}, 5));
    }
}
