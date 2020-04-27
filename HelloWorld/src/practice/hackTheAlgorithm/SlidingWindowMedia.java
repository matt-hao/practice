package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SlidingWindowMedia {
    public static void main(String[] args) {
        SlidingWindowMedia slidingWindowMedia = new SlidingWindowMedia();
        int[] nums = new int[]{2147483647, 2147483647, -2147483648, -2147483648, -2147483648};
        slidingWindowMedia.medianSlidingWindow(nums, 3);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> nums[o1] == nums[o2] ? o1 - o2 : nums[o1] - nums[o2]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new double[0];
        return method2(nums, k);
    }

    private double[] method2(int[] nums, int k) {
        TreeSet<Integer> minHeap = new TreeSet<>((o1, o2) -> {
            if (nums[o1] == nums[o2]) return o1 - o2;
            return nums[o1] - nums[o2];
        });

        TreeSet<Integer> maxHeap = new TreeSet<>((o1, o2) -> nums[o2] == nums[o1] ? o2 - o1 : nums[o2] - nums[o1]);

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(i);
            if (i < k - 1) continue;
            balance(minHeap, maxHeap, nums);
            if (k % 2 == 0) {
                list.add(((double) nums[minHeap.first()] + (double) nums[maxHeap.first()]) / 2.0);
            } else {
                list.add((double) nums[maxHeap.first()]);
            }

            if (nums[maxHeap.first()] < nums[i - k + 1]) {
                minHeap.remove(i - k + 1);
            } else
                maxHeap.remove(i - k + 1);
        }
        double[] res = new double[list.size()];
        int cnt = 0;
        for (double d : list) {
            res[cnt++] = d;
        }
        return res;
    }

    private void balance(TreeSet<Integer> minHeap, TreeSet<Integer> maxHeap, int[] nums) {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.pollFirst());
        }

        if (!minHeap.isEmpty() && nums[maxHeap.first()] > nums[minHeap.first()]) {
            int temp = maxHeap.pollFirst();
            maxHeap.add(minHeap.pollFirst());
            minHeap.add(temp);
        }
    }
}
