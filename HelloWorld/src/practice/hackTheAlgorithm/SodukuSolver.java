package practice.hackTheAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class SodukuSolver {
    private int row;
    private int col;
    private Set set;
    private Set[] rowSet;
    private Set[] colSet;
    private Set[] nineSet;
    private int count;
    private boolean solve;
    private int[][] matrix;


    //                {1, 3, 9, 7, 4, 8, 6, 5, 2},
    //                {7, 0, 0, 0, 0, 0, 0, 0, 0},
    //                {0, 2, 0, 1, 0, 9, 0, 0, 0},
    //                {0, 0, 7, 0, 0, 0, 2, 4, 0},
    //                {0, 6, 4, 0, 1, 0, 5, 9, 0},
    //                {0, 9, 8, 0, 0, 0, 3, 0, 0},
    //                {0, 0, 0, 8, 0, 3, 0, 2, 0},
    //                {0, 0, 0, 0, 0, 0, 0, 0, 6},
    //                {0, 0, 0, 2, 7, 5, 9, 0, 0},
    public static void main(String[] args) {
        SodukuSolver s = new SodukuSolver();
        int[][] board = {
                {0, 0, 9, 7, 4, 8, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 9, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 2, 4, 0},
                {0, 6, 4, 0, 1, 0, 5, 9, 0},
                {0, 9, 8, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 8, 0, 3, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 7, 5, 9, 0, 0},

        };
        s.solveSudoku(board);
    }

    public void solveSudoku(int[][] board) {
        // write your code here
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        row = board.length;
        col = board[0].length;

        rowSet = rowSet(board);
        colSet = colSet(board);
        nineSet = nine(board);
        set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }

        count = 0;
        solve = false;
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0)
                    count++;
            }
        }

        helper(board, 0, 0, 0);
        copy(board, matrix);
    }

    private void helper(int[][] board, int x, int y, int cnt) {
        if (solve) return;
        int i = x;
        int j = 0;
        loop:
        for (; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (board[i][j] == 0)
                    break loop;
            }
        }
        if(i == row && j == col)
            return;

        Set<Integer> permit = new HashSet(set);
        permit.removeAll(rowSet[i]);
        permit.removeAll(colSet[j]);
        permit.removeAll(nineSet[i / 3 * 3 + j / 3]);
        cnt++;

        for (int n : permit) {
            rowSet[i].add(n);
            colSet[j].add(n);
            nineSet[i / 3 * 3 + j / 3].add(n);
            board[i][j] = n;
            if (cnt == count) {
                System.out.println(cnt);
                solve = true;
                copy(matrix, board);
                return;
            }
            helper(board, i, j, cnt);

            board[i][j] = 0;
            nineSet[i / 3 * 3 + j / 3].remove(n);
            colSet[j].remove(n);
            rowSet[i].remove(n);
        }
    }


    private void copy(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix1[i][j] = matrix2[i][j];
            }
        }
    }

    private Set[] rowSet(int[][] board) {
        Set[] res = new Set[row];
        for (int i = 0; i < row; i++) {
            res[i] = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 0)
                    res[i].add(board[i][j]);
            }
        }
        return res;
    }

    private Set[] colSet(int[][] board) {
        Set[] res = new Set[col];
        for (int i = 0; i < col; i++) {
            res[i] = new HashSet<>();
            for (int j = 0; j < row; j++) {
                if (board[j][i] != 0)
                    res[i].add(board[j][i]);
            }
        }
        return res;
    }

    private Set[] nine(int[][] board) {
        Set[] res = new Set[9];
        for (int i = 0; i < 9; i++) {
            res[i] = new HashSet<>();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 0) {
                    res[i / 3 * 3 + j / 3].add(board[i][j]);
                }
            }
        }
        return res;
    }
}
