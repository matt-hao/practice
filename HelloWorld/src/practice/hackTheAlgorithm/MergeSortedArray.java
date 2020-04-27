package practice.hackTheAlgorithm;

public class MergeSortedArray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if (A == null || B == null)
            return;
        int[] temp = merge(A, B, m, n);
        for(int i = 0; i < temp.length; i++){
            A[i] = temp[i];
        }
    }

    private int[] merge(int[] A, int[] B, int m, int n) {
        int[] result = new int[m + n];
        int p1 = 0, p2 = 0;
        int count = 0;
        while (p1 < m && p2 < n) {
            if (A[p1] < B[p2]) {
                result[count++] = A[p1++];
            } else {
                result[count++] = B[p2++];
            }
        }
        while (p1 < m) {
            result[count++] = A[p1++];
        }
        while (p2 < n) {
            result[count++] = B[p2++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{4, 5};

        MergeSortedArray m = new MergeSortedArray();
        m.mergeSortedArray(A, 3, B, 2);
    }
}
