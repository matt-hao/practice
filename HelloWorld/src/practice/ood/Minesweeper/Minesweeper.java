package practice.ood.Minesweeper;

/**
 *
 */
public class Minesweeper {
    // the current time of game
    private long timeStamp;
    // the current status of game
    private Status status;
    // the matrix board
    private Board board;

    //todo....
    //initial the board

    /**
     * display the while matrix board
     * @return
     */
    public Board display() {
        return this.board;
    }

    /**
     * quit the game
     */
    public void quit() {
        //todo...
        //quit the game
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

/**
 * the matrix board which represent the minesweeper
 */
class Board {
    //the matrix board
    private Cell[][] board;
    // the total min in the board
    private int mine;
    // the current level of playing the game
    private Level level;

    // constructor, used to initial the whole matrix board
    public Board() {
    }

    public Board(Cell[][] board, int mine, Level level) {
        this.board = board;
        this.mine = mine;
        this.level = level;
    }

    /**
     * create the matrix board
     * @param level
     * @return
     */
    public Cell[][] createBoard(Level level) {
        return null;
    }

    /**
     * place the sign of every single cell
     * @param sign
     * @param x
     * @param y
     */
    public void placeSign(Sign sign, int x, int y) {

    }

    /**
     * uncover the current cell, calculate whether meets a mine
     * @param x
     * @param y
     */
    public void unCoverCell(int x, int y) {

    }

    /**
     * reset the whole game, this method can be also used for create new game
     */
    public void reset() {

    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getMine() {
        return mine;
    }

    public void setMine(int mine) {
        this.mine = mine;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}

/**
 * every single cell of matrix board
 */
class Cell {
    // the status of current cell
    private Sign sign;
    // whether the current cell is mine
    private boolean isMine;

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}

/**
 * used for representing the status of cell
 */
enum Sign {
    Flag, Question, Empty
}

/**
 * representing the level of game
 */
enum Level {
    Beginner, Intermediate, Expert, Custom
}


/**
 * representing the status of game
 */
enum Status {
    Win, Lose, Ongoing
}