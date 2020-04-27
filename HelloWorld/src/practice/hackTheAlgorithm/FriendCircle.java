package practice.hackTheAlgorithm;

import java.util.*;

public class FriendCircle {
    public int findCircleNum(int[][] M) {
        if (M == null)
            return 0;
        Map<Integer, List<Integer>> graph = buildMap(M);
        Set<Integer> keySet = new HashSet<>(graph.keySet());
        int count = 0;
        for (Integer key : keySet) {
            Set<Integer> setTemp = new HashSet<>();
            helper(graph, key, setTemp);
            if (setTemp.size() > 0)
                count++;
        }
        return count;
    }

    private void helper(Map<Integer, List<Integer>> graph, int cur, Set<Integer> set) {
        if (graph.containsKey(cur)) {
            List<Integer> neighbors = graph.get(cur);
            set.add(cur);
            graph.remove(cur);
            for (int i = 0; i < neighbors.size(); i++) {
                set.add(neighbors.get(i));
                helper(graph, neighbors.get(i), set);
            }
        }
    }

    private Map<Integer, List<Integer>> buildMap(int[][] nums) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 1 && i != j)
                    temp.add(j);
            }
            graph.put(i, temp);
        }
        return graph;
    }

    public static void main(String[] args) {
        FriendCircle friendCircle = new FriendCircle();
        int[][] M = new int[][]{
//                {1, 0, 0, 1},
//                {0, 1, 1, 0},
//                {0, 1, 1, 1},
//                {1, 0, 1, 1}
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}

        };
        System.out.println(friendCircle.findCircleNum(M));
    }
}
