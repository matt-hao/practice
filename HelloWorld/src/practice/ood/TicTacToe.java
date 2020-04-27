package practice.ood;

class TicTacToe {
    public static void main(String[] args) throws AlreadyTakenException, GameEndException {
        TicTacToe t = new TicTacToe();
        t.move(0, 0);
        t.move(1, 0);
        t.move(1, 1);
        t.move(2, 0);
        t.move(2, 2);
        t.move(0, 1);
        t.move(0, 0);
        t.move(1, 0);
        t.move(1, 1);
        t.move(2, 0);
        t.move(2, 2);
    }


    private int[][] matrix;
    private int who;
    private boolean end;
    private int cnt;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe() {
        matrix = new int[3][3];
        who = 1;
        end = false;
        cnt = 9;
    }

    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if (end) throw new GameEndException();
        if (matrix[row][col] != 0) throw new AlreadyTakenException();

        matrix[row][col] = who;
        this.who = -this.who;
        cnt--;
        valid();
        if (cnt == 0 && !end) {
            end = true;
            System.out.println("it's a draw");
            return false;
        }
        return true;
    }

    private void valid() {
        int[] r = new int[3];
        int[] c = new int[3];
        int lh = 0, rh = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                r[i] += matrix[i][j];
                c[j] += matrix[i][j];
                if (i == j) lh += matrix[i][j];
                if (i + j == 2) rh += matrix[i][j];
            }
        }
        if (Math.abs(r[0]) == 3 || Math.abs(r[1]) == 3 || Math.abs(r[2]) == 3
                || Math.abs(c[0]) == 3 || Math.abs(c[1]) == 3 || Math.abs(c[2]) == 3
                || Math.abs(lh) == 3 || Math.abs(rh) == 3) {
            System.out.println(who == 1 ? "X player wins!" : "O player wins!");
            end = true;
        }
    }
}

class AlreadyTakenException extends Exception {
    public AlreadyTakenException() {
        super("Already Taken");
    }
}

class GameEndException extends Exception {
    public GameEndException() {
        super("Game Ended");
    }
}