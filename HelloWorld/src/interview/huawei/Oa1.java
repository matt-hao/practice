package interview.huawei;

public class Oa1 {
    public int method1(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] grid = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(matrix[i - 1][j - 1] == 0)
                    continue;
                if(i == 1 || j == 1) {
                    grid[i][j] = 1;
                    continue;
                }

                grid[i][j] = Math.min(grid[i - 1][j - 1], Math.min(grid[i - 1][j], grid[i][j - 1])) + 1;
            }
        }

        int res = 0;
        for (int i = 0; i <= r ; i++) {
            for (int j = 0; j <= c ; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
}
