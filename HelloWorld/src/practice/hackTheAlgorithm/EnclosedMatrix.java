package practice.hackTheAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class EnclosedMatrix {
    private int[] deltaX = {0, -1, 0, 1};
    private int[] deltaY = {-1, 0, 1, 0};

    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0)
            return 0;
        if (image[x][y] == '0')
            return 1;
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        image[x][y] = '0';
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            minX = Math.min(minX, curX);
            maxX = Math.max(maxX, curX);

            minY = Math.min(minY, curY);
            maxY = Math.max(maxY, curY);

            for (int i = 0; i < deltaX.length; i++) {
                int nextX = curX + deltaX[i];
                int nextY = curY + deltaY[i];
                if (nextX >= 0 && nextX < m
                        && nextY >= 0 && nextY < n) {
                    if (image[nextX][nextY] == '1') {
                        image[nextX][nextY] = '0';
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public static void main(String[] args) {
        EnclosedMatrix enclosedMatrix = new EnclosedMatrix();
        String[] a = new String[]{
                "0010",
                "0110",
                "0100"
        };
        char[][] c = new char[a.length][a[0].length()];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                c[i][j] = a[i].charAt(j);
            }
        }
        System.out.println(enclosedMatrix.minArea(c, 0, 2));
    }
}

