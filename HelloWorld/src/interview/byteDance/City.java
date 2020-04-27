package interview.byteDance;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class City {
    private int result = Integer.MAX_VALUE;

    private void dfs(int[][] dis, int cur, Set<Integer> visited, int n, int temp) {
        if (visited.size() == n) {
            result = Math.min(result, temp + dis[cur][0]);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            dfs(dis, i, visited, n, temp + dis[cur][i]);
            visited.remove(i);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] dis = new int[n][n];
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = scanner.nextInt();
            }
        }
//        visited.add(0);
//        City city = new City();
//        city.dfs(dis, 0, visited, n, 0);
//        System.out.print(city.result);

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dis[i][j] > dis[i][k] + dis[k][j])
                        dis[i][j] = dis[i][k] + dis[k][j];
        System.out.println(dis[n - 1][n - 1]);
    }
}
