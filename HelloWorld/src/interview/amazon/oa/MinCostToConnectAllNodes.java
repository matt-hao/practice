package interview.amazon.oa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected.
 * The i-th edge connects nodes edges[i][0] and edges[i][1] together.
 * Your task is to augment this set of edges with additional edges to connect all the nodes.
 * Find the minimum cost to add new edges between the nodes such that all the nodes are accessible from each other.
 * <p>
 * Input:
 * <p>
 * n, an int representing the total number of nodes.
 * edges, a list of integer pair representing the nodes already connected by an edge.
 * newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can be added and the cost of addition, respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
 * Example 1:
 * <p>
 * Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
 * Output: 7
 * Explanation:
 * There are 3 connected components [1, 4, 5], [2, 3] and [6].
 * We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a minimum cost of 5 + 2 = 7.
 * Solution
 * Related problems:
 * <p>
 * Min Cost to Repair Edges
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost (premium)
 */
public class MinCostToConnectAllNodes {
    public static void main(String[] args) {
        MinCostToConnectAllNodes m = new MinCostToConnectAllNodes();
        //case 1 n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
        int[][] edges1 = new int[][]{{1, 4}, {4, 5}, {2, 3}};
        int[][] nEdges1 = new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        System.out.println(m.mst(6, edges1, nEdges1));

        //case2
        //Input: n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
        //Output: 20
        int[][] edges2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] nEdges2 = new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
        System.out.println(m.mst(5, m.deleteBroken(edges2, nEdges2), nEdges2));

        //case3
        //Input: n = 6, edges = [[1, 2], [2, 3], [4, 5], [3, 5], [1, 6], [2, 4]], edgesToRepair = [[1, 6, 410], [2, 4, 800]]
        //Output: 410
        int[][] edges3 = new int[][]{{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}};
        int[][] nEdges3 = new int[][]{{1, 6, 410}, {2, 4, 800}};
        System.out.println(m.mst(6, m.deleteBroken(edges3, nEdges3), nEdges3));

    }

    private int[][] deleteBroken(int[][] edges, int[][] nEdge) {
        Set<String> set = new HashSet<>();
        for (int[] e : edges) {
            if (e[0] < e[1])
                set.add(e[0] + " " + e[1]);
            else
                set.add(e[1] + " " + e[0]);
        }

        for (int[] e : nEdge) {
            if (e[0] < e[1])
                set.remove(e[0] + " " + e[1]);
            else
                set.remove(e[1] + " " + e[0]);
        }
        int[][] res = new int[set.size()][2];
        int cnt = 0;
        for (String s : set) {
            String[] arr = s.split(" ");
            res[cnt][0] = Integer.parseInt(arr[0]);
            res[cnt][1] = Integer.parseInt(arr[1]);
            cnt++;
        }
        return res;
    }

    public int mst(int n, int[][] edges, int[][] newEdges) {
        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        int cost = 0;
        for (int[] nEdge : newEdges) {
            if (unionFind.union(nEdge[0], nEdge[1])) {
                cost += nEdge[2];
            }
        }
        return unionFind.size == 1 ? cost : -1;
    }

    class UnionFind {
        int[] father;
        int size;

        public UnionFind(int n) {
            father = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                father[i] = i;
            }
            size = n;
        }

        public int find(int x) {
            if (father[x] == x)
                return x;
            return father[x] = find(father[x]);
        }

        public boolean union(int x, int y) {
            int r1 = find(x);
            int r2 = find(y);
            if (r1 != r2) {
                father[r1] = r2;
                size--;
                return true;
            }
            return false;
        }
    }
}
