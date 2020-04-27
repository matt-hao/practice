package practice.hackTheAlgorithm;

import java.util.*;

public class NetWorkDelay {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times.length < N - 1)
            return -1;
        Map<Integer, List<Node>> graph = new HashMap<>();
        buildGraph(times, graph);

        Set<Integer> visited = new HashSet<>();

        Map<Integer, Integer> distance = new HashMap<>();
        initialDistance(distance, N);

        visited.add(K);
//        distance.put(K, Integer.MIN_VALUE);
        helper(graph, visited, K, 0, distance);
        int max = 0;
        for (int temp : distance.values()) {
            if (temp > max)
                max = temp;
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void helper(Map<Integer, List<Node>> graph, Set<Integer> visited,
                        int k, int distance, Map<Integer, Integer> distanceMap) {
        if (distance < distanceMap.get(k)) {
            distanceMap.put(k, distance);
        }else{
            return;
        }

        List<Node> neighbors = graph.get(k);
        if (neighbors == null)
            return;
        for (Node node : neighbors) {
            if (visited.contains(node.val))
                continue;
            visited.add(node.val);
            helper(graph, visited, node.val, distance + node.distance, distanceMap);
            visited.remove(node.val);
        }
    }

    private void buildGraph(int[][] times, Map<Integer, List<Node>> graph) {
        for (int i = 0; i < times.length; i++) {
            int source = times[i][0];
            int target = times[i][1];
            int distance = times[i][2];
            if (!graph.containsKey(source)) {
                Node node = new Node(target, distance);
                ArrayList<Node> list = new ArrayList<>();
                list.add(node);
                graph.put(source, list);
            } else {
                graph.get(source).add(new Node(target, distance));
            }
        }
    }

    private void initialDistance(Map<Integer, Integer> distance, int N) {
        for (int i = 1; i <= N; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
        NetWorkDelay netWorkDelay = new NetWorkDelay();
        int[][] times = new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        };
        System.out.println(netWorkDelay.networkDelayTime(times, 4, 2));
    }

    class Node {
        public int val;
        public int distance;

        public Node(int val, int distance) {
            this.val = val;
            this.distance = distance;
        }
    }
}
