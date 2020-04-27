package primary.sort_search;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0, j = 0, count = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j])
                arr[count++] = nums1[i++];
            else
                arr[count++] = nums2[j++];
        }
        while (i < m) {
            arr[count++] = nums1[i++];
        }
        while (j < n) {
            arr[count++] = nums2[j++];
        }

        for (int k = 0; k < arr.length; k++) {
            nums1[k] = arr[k];
        }
    }

    public static void main(String[] args) {

    }
}