package interview.huawei;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Floyd {
    private static double min;
//    private void floyd(double[][] matrix) {
//        int n = matrix.length;
//        for (int k = 1; k < n; k++)
//            for (int i = 0; i < n; i++)
//                for (int j = 0; j < n; j++)
//                    if (matrix[i][j] > matrix[i][k] + matrix[k][j])
//                        matrix[i][j] = matrix[i][k] + matrix[k][j];
//    }

    private double[][] buildGraph(Pair[] pairs) {
        int len = pairs.length;
        double[][] graph = new double[len][len];
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = Double.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                graph[i][j] = distance(pairs[i], pairs[j]);
                graph[j][i] = graph[i][j];
            }
        }
        return graph;
    }

    private double distance(Pair x, Pair y) {
        return Math.sqrt(Math.pow(x.x - y.x, 2) + Math.pow(x.y - y.y, 2));
    }

    private void dfs(double[][] matrix, Set<Integer> visited, double sum, int curIndex, int size) {
        if (visited.size() == size) {
            sum += matrix[curIndex][0];
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < size; i++) {
            if (visited.contains(i) || curIndex == i)
                continue;
            visited.add(i);
            dfs(matrix, visited, sum + matrix[curIndex][i], i, size);
            visited.remove(i);
        }
    }

    public static void main(String[] args) {
        min = Double.MAX_VALUE;

        Scanner scanner = new Scanner(System.in);
        String sc = "";
        LinkedList<Pair> list = new LinkedList<>();
        scanner.useDelimiter(" ");
        if (scanner.hasNextLine()) {
            sc = scanner.nextLine();
        }

        String[] s = sc.split(" ");
        int count = 0;
        int x = 0, y = 0;
        for (int i = 0; i < s.length; i++) {
            count++;
            if (count % 2 == 0) {
                y = Integer.parseInt(s[i]);
                list.add(new Pair(x, y));
            } else {
                x = Integer.parseInt(s[i]);
            }
        }
        list.addFirst(new Pair(0, 0));
        Pair[] pairs = new Pair[list.size()];
        for (int i = 0; i < list.size(); i++) {
            pairs[i] = list.get(i);
        }

        Floyd floyd = new Floyd();
        double[][] graph = floyd.buildGraph(pairs);
//        floyd.floyd(graph);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        floyd.dfs(graph, visited, 0, 0, graph.length);
        System.out.println(min);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}