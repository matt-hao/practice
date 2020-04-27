package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class SurroundRegion {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    private int row;
    private int col;
    private int[] delta = {0, -1, 0, 1, 0};

    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    //扫描矩阵边界，如果有'O',把于'O' 相连通的'O'全部找到，标记成'E'，说明这些都是不被包围的
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y] = 'E';
        for (int i = 0; i < 4; i++) {
            int nx = x + delta[i];
            int ny = y + delta[i + 1];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny] == 'O') {
                dfs(board, nx, ny);
            }
        }

        Collections.sort(new ArrayList<String>(), Collections.reverseOrder());
    }
}
