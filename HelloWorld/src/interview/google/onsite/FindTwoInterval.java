package interview.google.onsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoInterval {
    public static void main(String[] args) {
        FindTwoInterval s = new FindTwoInterval();
        System.out.println(s.method(new int[]{3, 2, 4, -4, 9, 2, 1}, 3));
        System.out.println(s.method(new int[]{-3, 2, 4, -4, 9, -2, 1}, 3));
        System.out.println(s.method(new int[]{-4, 2, 4, -4, 9, -2, 1}, 3));
    }

    public int method(int[] arr, int k) {
        //key为sum值，value为index
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        //用来记录以当前这个index左边区间内，和为k的最小区间长度
        int[] left = new int[len];
        Arrays.fill(left, Integer.MAX_VALUE);

        map.put(0, -1);
        int lsum = 0;
        for (int i = 0; i < len; i++) {
            lsum += arr[i];
            if (map.containsKey(lsum - k)) {
                left[i] = i - map.get(lsum - k);
            }
            if (i > 0)
                left[i] = Math.min(left[i], left[i - 1]);
            map.put(lsum, i);
        }

        map.clear();
        //以当前这个index右边区间内，和为k的最小区间长度
        int[] right = new int[len];
        Arrays.fill(right, Integer.MAX_VALUE);
        map.put(0, len);
        int rsum = 0;
        for (int i = len - 1; i >= 0; i--) {
            rsum += arr[i];
            if (map.containsKey(rsum - k)) {
                right[i] = map.get(rsum - k) - i;
            }
            if (i < len - 1)
                right[i] = Math.min(right[i], right[i + 1]);
            map.put(rsum, i);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            if (left[i] != Integer.MAX_VALUE && right[i + 1] != Integer.MAX_VALUE) {
                res = Math.min(left[i] + right[i + 1], res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
