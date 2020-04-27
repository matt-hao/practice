package practice.hackTheAlgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }

        int[][] edges = new int[n][n];
        for (int[] e : edges) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
//        for (int i = 0; i < n; i++) {
//            edges[i][i] = 0;
//        }

        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            String[] str = s.split(" ");
            edges[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = Integer.parseInt(str[2]);
        }

        System.out.println(Arrays.toString(dijkstra(edges)));
    }

    private static int[] dijkstra(int[][] edges) {
        int n = edges.length;
        Set<Integer> visited = new HashSet<>();
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = edges[0][i];
        }
        visited.add(0);

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int next = 0;
            for (int j = 0; j < n; j++) {
                if (visited.contains(j))
                    continue;
                if (dis[j] < min) {
                    min = dis[j];
                    next = j;
                }
            }
            visited.add(next);
            for (int j = 0; j < n; j++) {
                if (edges[next][j] < Integer.MAX_VALUE) {
                    dis[j] = Math.min(dis[j], dis[next] + edges[next][j]);
                }
            }
        }
        return dis;
    }
}
