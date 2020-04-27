package interview.amazon.oa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0)
            return new int[0][0];
        return method3(points, K);
    }

    //O(nlogn)/O(1) -> dose not count the result
    private int[][] method1(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double dis1 = Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
                double dis2 = Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2));
                if (dis1 > dis2) return 1;
                if (dis1 < dis2) return -1;
                return 0;
            }
        });

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[i];
        }
        return res;
    }

    //O(nlogk)/O(k) --> does not count the result
    //main a min heap
    private int[][] method2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double dis1 = Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
                double dis2 = Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2));
                if (dis1 < dis2) return 1;
                if (dis1 > dis2) return -1;
                return 0;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);

            if (i >= K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        int cnt = 0;
        while (!pq.isEmpty()) {
            res[cnt++] = pq.poll();
        }

        return res;
    }

    private int[][] method3(int[][] points, int K) {
        qs(points, 0, points.length - 1, K);
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[i];
        }
        return res;
    }

    //O(n)/O(1)
    private int[] qs(int[][] points, int start, int end, int K) {
        if (start >= end)
            return points[start];
        int left = start, right = end;
        double pivot = dis(points[left + (right - left) / 2]);
        while (left <= right) {
            while (left <= right && dis(points[left]) < pivot) {
                left++;
            }

            while (left <= right && dis(points[right]) > pivot) {
                right--;
            }

            if (left <= right) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                left++;
                right--;
            }
        }

        if (start + K - 1 <= right)
            return qs(points, start, right, K);
        if (start + K - 1 >= left)
            return qs(points, left, end, K - (left - start));
        return points[right + 1];
    }

    private double dis(int[] arr) {
        return Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2));
    }

    public static void main(String[] args) {
    }
}
