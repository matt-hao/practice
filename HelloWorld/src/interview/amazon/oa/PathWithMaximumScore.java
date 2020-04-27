package interview.amazon.oa;

/**
 * Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r - 1, c - 1].
 * The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.
 * <p>
 * You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[5, 1],
 * [4, 5]]
 * Output: 4
 * Explanation:
 * Possible paths:
 * 5 → 1 → 5 => min value is 1
 * 5 → 4 → 5 => min value is 4
 * Return the max value among minimum values => max(4, 1) = 4.
 * Related problems:
 * <p>
 * https://leetcode.com/problems/unique-paths-ii/
 * https://leetcode.com/problems/path-with-maximum-minimum-value (premium) is a different problem.
 * In this problem we can only move in 2 directions.
 */
public class PathWithMaximumScore {
    public static int maxScore(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < r; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
        }

        for (int i = 1; i < c; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(matrix[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        int tc1 = maxScore(new int[][] { { 5, 1 }, { 4, 5 } });
        int tc2 = maxScore(new int[][] { { 5, 7 }, { 3, 4 }, { 9, 8 } });
        int tc3 = maxScore(new int[][] { { 5, 7, 6, 8 }, { 3, 4, 2, 1 }, { 9, 8, 4, 6 } });
        System.out.println(tc1);
        System.out.println(tc2);
        System.out.println(tc3);
    }
}
