package practice.hackTheAlgorithm;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class MaxSubArrayCycle {
    public static void main(String[] args) {
        MaxSubArrayCycle maxSubArrayCycle = new MaxSubArrayCycle();
        System.out.println(maxSubArrayCycle.maxSubarraySumCircular(new int[]{5, -3, 5}));
        TreeSet<PairSum> t = new TreeSet<>(new Comparator<PairSum>() {
            @Override
            public int compare(PairSum o1, PairSum o2) {
                if(o1.sum == o2.sum)
                    return o1.index - o2.index;
                return o1.sum - o2.sum;
            }
        });
        t.add(new PairSum(0, 0));
        t.add(new PairSum(1, 1));
        t.add(new PairSum(2, 0));
        t.remove(new PairSum(1));
        t.remove(new PairSum(0));
        t.remove(new PairSum(2));
        System.out.println(t.contains(new PairSum(2)));
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) return 0;
        return method1(A);
    }

    private int method1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int res = Integer.MIN_VALUE;

        PairSum[] ps = new PairSum[2 * len + 1];

        TreeSet<PairSum> p = new TreeSet<>(new Comparator<PairSum>() {
            @Override
            public int compare(PairSum o1, PairSum o2) {
                if(o1.sum == o2.sum)
                    return o1.index - o2.index;
                return o1.sum - o2.sum;
            }
        });

        int cnt = 0;
        ps[cnt++] = new PairSum(-1, 0);
        p.add(ps[0]);
        for (int i = 0; i < 2 * len; i++) {
            sum += nums[i % len];
            res = Math.max(res, sum - p.first().sum);

            ps[cnt] = new PairSum(i, sum);
            p.add(ps[cnt]);
            cnt++;
            if (i >= len - 1) {
                p.remove(ps[i - len + 1]);
            }
        }

        return res;
    }
}

class PairSum{
     int index;
    int sum;

    public PairSum(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }

    public PairSum(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairSum p = (PairSum) o;
        return p.index == this.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.index);
    }
}
