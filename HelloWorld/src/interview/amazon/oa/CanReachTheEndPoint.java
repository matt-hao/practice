package interview.amazon.oa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1479. Can Reach The Endpoint
 * Given a map size of m*n, 1 means space, 0 means obstacle, 9 means the endpoint. You start at (0,0) and return whether you can reach the endpoint.
 * <p>
 * Example
 * Example1
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,1,1],
 * [1,1,9]
 * ]
 * Output: true
 * Example2
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,0],
 * [1,0,9]
 * ]
 * Output: false
 */
public class CanReachTheEndPoint {
    //O(n2)
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        if (map == null || map.length == 0 || map[0] == null || map[0].length == 0)
            return false;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        if (map[0][0] == 9) return true;
        map[0][0] = 0;

        int[] delta = new int[]{0, -1, 0, 1, 0};

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + delta[j];
                    int ny = cur[1] + delta[j + 1];

                    if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                        if (map[nx][ny] == 9) {
                            // System.out.println(step);
                            return true;
                        }
                        if (map[nx][ny] == 1) {
                            map[nx][ny] = 0;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1, 0, 0},
                {1, 0, 0},
                {1, 9, 1}
        };
        System.out.println(new CanReachTheEndPoint().reachEndpoint(map));
    }
}
