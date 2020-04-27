package interview.amazon.oa;

import java.util.*;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * Given an underected connected graph with n nodes labeled 1..n. A bridge (cut edge) is defined as an edge which,
 * when removed, makes the graph disconnected (or more precisely, increases the number of connected components in the graph).
 * Equivalently, an edge is a bridge if and only if it is not contained in any cycle. The task is to find all bridges in the given graph.
 * Output an empty list if there are no bridges.
 * <p>
 * Input:
 * <p>
 * n, an int representing the total number of nodes.
 * edges, a list of pairs of integers representing the nodes connected by an edge.
 * Example 1:
 * <p>
 * Input: n = 5, edges = [[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]
 * Output: [[1, 2], [4, 5]]
 * Explanation:
 * There are 2 bridges:
 * 1. Between node 1 and 2
 * 2. Between node 4 and 5
 * If we remove these edges, then the graph will be disconnected.
 * If we remove any of the remaining edges, the graph will remain connected.
 * Example 2:
 * <p>
 * Input: n = 6, edges = [[1, 2], [1, 3], [2, 3], [2, 4], [2, 5], [4, 6], [5, 6]]
 * <p>
 * <p>
 * Output: []
 * Explanation:
 * We can remove any edge, the graph will remain connected.
 * Example 3:
 * <p>
 * Input: n = 9, edges = [[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 9], [7, 8], [8, 9]]
 * <p>
 * <p>
 * Output: [[3, 4], [3, 6], [4, 5]]
 * The order of nodes is important! If the input contains an edge [3, 1] you should return it as [3, 1], [1, 3] won't be accepted.
 */
public class CriticalConnectionNetwork {
    private List<List<Integer>> res;
    private int[] dfn, low;
    private int time;
    private Map<Integer, List<Integer>> map;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();
        if (connections == null || connections.size() == 0)
            return res;
        dfn = new int[n];
        low = new int[n];
        Arrays.fill(dfn, -1); // which also could represent if current node is visited
        time = 0;
        map = buildGraph(n, connections);
        for (int i = 0; i < n; i++) {
            if (dfn[i] == -1)
                tarjan(i, 0);
        }

        for (List<Integer> c : connections) {
            int n1 = c.get(0) - 1;
            int n2 = c.get(1) - 1;
            //dfn must be ahead to low
            if (dfn[n1] < low[n2] || dfn[n2] < low[n1]) {
                res.add(c);
            }
        }
        return res;
    }

    private Map<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (List<Integer> c : connections) {
            map.get(c.get(0) - 1).add(c.get(1) - 1);
            map.get(c.get(1) - 1).add(c.get(0) - 1);
        }
        return map;
    }

    private void tarjan(int u, int pre) {
        dfn[u] = low[u] = ++time;
        for (int v : map.get(u)) {
            if (v == pre) continue;
            if (dfn[v] == -1) {
                tarjan(v, u);
                low[u] = Math.min(low[u], low[v]);
            } else {
                low[u] = Math.min(low[u], dfn[v]);
            }
        }
    }

    public static void main(String[] args) {
        CriticalConnectionNetwork criticalConnectionNetwork = new CriticalConnectionNetwork();
        //case 1
        int n1 = 5;
        //[[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        edges1.add(new ArrayList<Integer>() {{
            add(1);
            add(3);
        }});
        edges1.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        edges1.add(new ArrayList<Integer>() {{
            add(1);
            add(4);
        }});
        edges1.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
        }});

        //[[1, 2], [4, 5]]
        System.out.println(criticalConnectionNetwork.criticalConnections(n1, edges1));

        //case 2
        int n2 = 4;
        //[[1, 2], [1, 3], [3, 2], [3, 4]]
        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        edges2.add(new ArrayList<Integer>() {{
            add(1);
            add(3);
        }});
        edges2.add(new ArrayList<Integer>() {{
            add(3);
            add(2);
        }});
        edges2.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        //Output:
        //[[3,4]]
        System.out.println(criticalConnectionNetwork.criticalConnections(n2, edges2));
    }
}
