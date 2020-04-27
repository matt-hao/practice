package practice.hackTheAlgorithm;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        if (matrix[0] == null || matrix[0].length == 0)
            return false;

        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
    //[
    //  [1, 4,  7,  11, 15],
    //  [2, 5,  8,  12, 19],
    //  [3, 6,  9,  16, 22],
    //  [10,13, 14, 17, 24],
    //  [18,21, 23, 26, 30]
    //]

    //  5
}
