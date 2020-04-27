package practice.hackTheAlgorithm;

import java.util.*;

public class MatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        if (A == null || B == null)
            return new int[0][0];
        Map<Integer, Set<Integer>> mapA = buildSetA(A);
        Map<Integer, Set<Integer>> mapB = buildSetB(B);
        Set<Tuple> setRes = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (!mapA.containsKey(i))
                continue;
            for (int j = 0; j < B[0].length; j++) {
                int sum = 0;
                if (!mapB.containsKey(j))
                    continue;
                Set<Integer> setA = new HashSet<>(mapA.get(i));
                Set<Integer> setB = new HashSet<>(mapB.get(j));
                setA.retainAll(setB);
                if(setA.size() == 0)
                    continue;
                for (int temp : setA) {
                    sum += A[i][temp] * B[temp][j];
                }
                setRes.add(new Tuple(i, j, sum));
            }
        }

        int[][] result = new int[A.length][B[0].length];
        for (Tuple t : setRes) {
            result[t.row][t.col] = t.val;
        }
        return result;
    }

    private Map<Integer, Set<Integer>> buildSetA(int[][] A) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0)
                    continue;
                if (map.containsKey(i)) {
                    map.get(i).add(j);
                } else {
                    Set<Integer> newSet = new HashSet<>();
                    newSet.add(j);
                    map.put(i, newSet);
                }
            }
        }
        return map;
    }

    private Map<Integer, Set<Integer>> buildSetB(int[][] B) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < B[0].length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] == 0)
                    continue;
                if (map.containsKey(i)) {
                    map.get(i).add(j);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(j);
                    map.put(i, set);
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] A = new int[][]{
                {1, 0, 0},
                {-1, 0, 3}
        };
        int[][] B = new int[][]{
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(Arrays.deepToString(m.multiply(A, B)));
    }
}

class Tuple {
    int row;
    int col;
    int val;

    public Tuple(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}