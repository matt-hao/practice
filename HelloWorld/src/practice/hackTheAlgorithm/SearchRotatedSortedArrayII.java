package practice.hackTheAlgorithm;

public class SearchRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[start])
                start++;
            else if (nums[mid] == end)
                end--;
            else if (nums[mid] > nums[end])
                start = mid;
            else
                end = mid;
        }
        int minPos = nums[start] > nums[end] ? end : start;
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int realMid = (mid + minPos) % nums.length;
            if (nums[realMid] == target)
                return true;
            if (nums[realMid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }

    int index(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 1, 2, 1, 1};
        SearchRotatedSortedArrayII s = new SearchRotatedSortedArrayII();
        System.out.println(s.index(a, 2));
        System.out.println(s.search(a, 2));
    }
}
