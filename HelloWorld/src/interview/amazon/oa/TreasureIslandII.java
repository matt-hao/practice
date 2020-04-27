package interview.amazon.oa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/356150
 * You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in. There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to one of the treasure islands.
 * <p>
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time.
 * The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks.
 * You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.
 * Input:
 * [['S', 'O', 'O', 'S', 'S'],
 * ['D', 'O', 'D', 'O', 'D'],
 * ['O', 'O', 'O', 'O', 'X'],
 * ['X', 'D', 'D', 'O', 'O'],
 * ['X', 'D', 'D', 'D', 'O']]
 * <p>
 * Output: 3
 * Explanation:
 * You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 4)
 */
public class TreasureIslandII {

    public int minStep(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] delta = new int[]{0, -1, 0, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'S') {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 'D';
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + delta[j];
                    int ny = p[1] + delta[j + 1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if (grid[nx][ny] == 'X') return step;
                        if (grid[nx][ny] == 'O') {
                            grid[nx][ny] = 'D';
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'},
        };
        System.out.println(new TreasureIslandII().minStep(grid));
    }
}
