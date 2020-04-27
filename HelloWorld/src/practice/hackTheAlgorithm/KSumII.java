package practice.hackTheAlgorithm;

import java.util.*;

public class KSumII {
    public static void main(String[] args) {
        KSumII kSumII = new KSumII();
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        System.out.println(kSumII.kSumII(A, k, target));
    }

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        if (A == null || A.length == 0) return new LinkedList<>();

        return helper(A, k, target, 0, new HashMap<>());
    }

    private List<List<Integer>> helper(int[] A, int k, int target,
                                       int startIndex, Map<Tuple, List<List<Integer>>> map) {
        Tuple t = new Tuple(k, target, startIndex);
        if (map.containsKey(t))
            return map.get(t);

        if (k < 0 || target < 0)
            return new LinkedList<>();
        if (k == 0 && target == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            map.put(t, list);
            return map.get(t);
        }

        if (startIndex >= A.length){
            return new ArrayList<>();
        }


        List<List<Integer>> noChoose = helper(A, k, target, startIndex + 1, map);

        List<List<Integer>> choose = helper(A, k - 1, target - A[startIndex], startIndex + 1, map);

        for (List<Integer> l : choose) {
            l.add(A[startIndex]);
        }

        noChoose.addAll(choose);
        map.put(t, noChoose);
        return noChoose;
    }

    class Tuple {
        int k;
        int target;
        int startIndex;
        List<Integer> list;

        Tuple(int k, int target, int startIndex) {
            this.k = k;
            this.target = target;
            this.startIndex = startIndex;
            this.list = new ArrayList<>();
        }

        //todo..
        //equals and hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || o.getClass() != this.getClass()) return false;
            Tuple t = (Tuple) o;
            return this.k == t.k && this.target == t.target && this.startIndex == t.startIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.k, this.target, this.startIndex);
        }
    }
}
