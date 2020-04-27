package interview.amazon.oa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/347457
 * related to CanReachTheEndPoint
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in. There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to the treasure island.
 * <p>
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
 * The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.
 * <p>
 * Example:
 * <p>
 * Input:
 * [['O', 'O', 'O', 'O'],
 * ['D', 'O', 'D', 'O'],
 * ['O', 'O', 'O', 'O'],
 * ['X', 'D', 'D', 'O']]
 * <p>
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */
public class TreasureIsland {
    private int minStep(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        matrix[0][0] = 'D';
        int[] delta = new int[]{0, -1, 0, 1, 0};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + delta[j];
                    int ny = cur[1] + delta[j + 1];

                    if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length) {
                        if (matrix[nx][ny] == 'X') return step;
                        if (matrix[nx][ny] == 'O') {
                            matrix[nx][ny] = 'D';
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'},
        };
        System.out.println(new TreasureIsland().minStep(matrix));
    }
}
