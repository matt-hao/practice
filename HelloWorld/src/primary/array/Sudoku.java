package primary.array;

import java.util.HashSet;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            HashSet set1 = new HashSet();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!set1.add(board[i][j]))
                    return false;
            }

            HashSet set2 = new HashSet();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.')
                    continue;
                if (!set2.add(board[j][i]))
                    return false;
            }
        }


        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board.length; j = j + 3) {
                HashSet set = new HashSet();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] == '.') continue;
                        if (!set.add(board[k][l]))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        Sudoku sudoku = new Sudoku();
        System.out.println(sudoku.isValidSudoku(board));
    }
}