package interview.byteDance;

import java.util.*;

public class Programmer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.equals(""))
                break;
            String[] arr = str.split(" ");
            list.add(arr);
        }
        int row = list.size();
        int col = list.get(0).length;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(list.get(i)[j]);
            }
        }
        Programmer programmer = new Programmer();
        System.out.println(programmer.helper(matrix));
    }

    private int[] deltaX = {0, -1, 0, 1};
    private int[] deltaY = {-1, 0, 1, 0};

    private int helper(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int j = 0; j < deltaX.length; j++) {
                    int nextX = temp[0] + deltaX[j];
                    int nextY = temp[1] + deltaY[j];
                    if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && matrix[nextX][nextY] == 1) {
                        matrix[nextX][nextY] = 2;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1)
                    return -1;
            }
        }
        return step;
    }
}
