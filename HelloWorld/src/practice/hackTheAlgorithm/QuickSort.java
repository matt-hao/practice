package practice.hackTheAlgorithm;

public class QuickSort {
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return;
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end)
            return;
        int pivot = A[start + (end - start) / 2];
        int left = start, right = end;

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        q.sortIntegers(new int[]{1, 5, 6, 3, 5, 8, 9, 10, 11});
    }
}
