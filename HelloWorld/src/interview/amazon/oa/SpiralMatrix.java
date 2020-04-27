package interview.amazon.oa;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix {
    private int cnt;

    public int[][] generateMatrix(int n) {
        cnt = 1;
        if (n == 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        helper(matrix, 0, 0, n);
        return matrix;
    }

    private void helper(int[][] matrix, int x, int y, int n) {
        if (n == 0) return;
        if (n == 1) {
            matrix[x][y] = cnt++;
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            matrix[x][y++] = cnt++;
        }

        for (int i = 0; i < n - 1; i++) {
            matrix[x++][y] = cnt++;
        }

        for (int i = 0; i < n - 1; i++) {
            matrix[x][y--] = cnt++;
        }

        for (int i = 0; i < n - 1; i++) {
            matrix[x--][y] = cnt++;
        }
        x++;
        y++;
        n -= 2;
        helper(matrix, x, y, n);
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println("====3====");
        spiralMatrix.printMatrix(spiralMatrix.generateMatrix(3));
        System.out.println("====4====");
        spiralMatrix.printMatrix(spiralMatrix.generateMatrix(4));
        System.out.println("====5====");
        spiralMatrix.printMatrix(spiralMatrix.generateMatrix(5));

    }

    private void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + (j == n - 1 ? "" : ","));
            }
            System.out.println();
        }
    }
}
