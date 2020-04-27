package practice.hackTheAlgorithm;

import java.util.*;

public class Leetcode957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }

        boolean isCycle = false;
        int count = 0;
        Map<String, int[]> occupyMap = new HashMap<>();
        List<int[]> temp = new ArrayList<>();
        temp.add(cells);
        for (int i = 1; i <= N; i++) {
            int[] nextState = getNext(cells);
            String key = Arrays.toString(nextState);
            if (occupyMap.containsKey(key)) {
                isCycle = true;
                break;
            } else {
                occupyMap.put(key, nextState);
                temp.add(nextState);
                count++;
            }
            System.arraycopy(nextState,0,cells,0, nextState.length);
        }
        if (isCycle) {
            N = N % count;
            return temp.get(N);
        }
        System.out.print("aaaa");
        return cells;
    }

    private int[] getNext(int[] cells) {
        int n = cells.length;
        int[] res = new int[n];
        for (int i = 1; i < n - 1; i++) {
            res[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode957 l = new Leetcode957();

        System.out.println(Arrays.toString(l.prisonAfterNDays(new int[]{1, 1, 0, 1, 1, 0, 1, 1}, 6)));
    }
}

//class Solution {
//     public int[] prisonAfterNDays(int[] cells, int N) {
//        if (N == 0){
//            return cells;
//        }
//
//        boolean isCycle = false;
//        int count = 1;
//        Map<String,int[]> occupyMap = new HashMap<>();
//        String s = Arrays.toString(cells);
//        occupyMap.put(s, cells);
//        List<String> temp = new ArrayList<>();
//        temp.add(s);
//        for (int i = 1; i <= N; i++){
//            int[] nextState = getNext(cells);
//            String key = Arrays.toString(nextState);
//            if(occupyMap.containsKey(key)){
//                isCycle = true;
//                break;
//            }else{
//                occupyMap.put(key, nextState);
//                temp.add(key);
//                count++;
//            }
//           cells = nextState;
//        }
//        if (isCycle){
//            N = N % count;
//            System.out.println("N = " + N);
//            System.out.println("count = " + count);
//            System.out.println("map = " + occupyMap);
//            System.out.println("temp = " + temp);
//            return occupyMap.get(temp.get(N));
//        }
//        return cells;
//    }
//
//    private int[] getNext(int[] cells){
//        int n = cells.length;
//        int[] res = new int[n];
//        for (int i = 1; i < n - 1; i++){
//            res[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
//        }
//        return res;
//    }
//
//
//
//}