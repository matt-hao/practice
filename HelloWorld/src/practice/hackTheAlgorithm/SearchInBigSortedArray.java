package practice.hackTheAlgorithm;

/**
 * Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
 * <p>
 * Return -1, if the number doesn't exist in the array.
 * <p>
 * Example
 * Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.
 * <p>
 * Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
 * <p>
 * Challenge
 * O(log k), k is the first index of the given target number.
 * <p>
 * Notice
 * If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.
 */
public class SearchInBigSortedArray {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (reader.get(0) == target)
            return 0;
        if (reader.get(1) == target)
            return 1;
        int start = 2;
        while (true) {
            if (reader.get(start * start) < target)
                start *= start;
            else {
                return binarySearch(reader, start, start * start, target);
            }
        }
    }

    private int binarySearch(ArrayReader reader, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (reader.get(mid) > target) {
            return binarySearch(reader, start, mid - 1, target);
        }
        if (reader.get(mid) < target) {
            return binarySearch(reader, mid + 1, end, target);
        }
        if (mid - 1 >= 0 && reader.get(mid) == reader.get(mid - 1))
            return binarySearch(reader, start, mid - 1, target);
        else
            return mid;
    }

    public static void main(String[] args) {
        SearchInBigSortedArray s = new SearchInBigSortedArray();
        System.out.println(s.searchBigSortedArray(new ArrayReader(new int[]{1, 3, 6, 9, 21}), 3));
    }
}

class ArrayReader {
    private int[] arr;

    public ArrayReader(int[] arr) {
        this.arr = arr;
    }

    int get(int k) {
        return arr[k];
    }
}
