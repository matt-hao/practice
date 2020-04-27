package practice.hackTheAlgorithm;

/**
 * Lincode
 * 585. Maximum Number in Mountain Sequence
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * <p>
 * Example
 * Given nums = [1, 2, 4, 8, 6, 3] return 8
 * Given nums = [10, 9, 8, 7], return 10
 */
public class MountainSequence {
    public int mountainSequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //mid >= left && mid >= right
            int left = mid - 1;
            int right = mid + 1;
            if ((left >= 0 && nums[mid] >= nums[left]
                    && right <= nums.length - 1 && nums[mid] >= nums[right])
                    || (left < 0 && right <= nums.length - 1 && nums[mid] >= nums[right])
                    || (right > nums.length - 1 && left >= 0 && nums[mid] >= nums[left])
                    || (left < 0 && right > nums.length - 1))
                return nums[mid];
            if (nums[mid] < nums[left] && nums[mid] >= nums[right])
                end = mid - 1;
            if (nums[mid] >= nums[left] && nums[mid] < nums[right])
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainSequence m = new MountainSequence();
        System.out.println(m.mountainSequence(new int[]{10, 9, 8, 7}));
    }

}
