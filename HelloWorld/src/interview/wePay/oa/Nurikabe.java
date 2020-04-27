package interview.wePay.oa;

import java.util.*;

/**
 * Nurikabe is a puzzle where a 2d grid is given with many blank spaces and some numbers. The challenge is to fill in the grid with '.' (water) and '#' (islands) in such a way that
 * <p>
 * Each number is with a connected group of island squares that, including the number square itself, contains exactly that many squares are connected up-down-left-right only, not diagonally
 * Each connected group of island squares contains exactly one numbered square
 * All of the water squares are connected to each other
 * There no 2x2 blocks of water anywhere in the grid
 * No other characters appear in the grid (cheater!)
 * Your task is to write a function that takes a 2d array[i] representing a solved Nurikabe puzzle and returns True if the puzzle is correctly solved and False otherwise.
 * <p>
 * For example, given the 5x5 puzzle
 * <p>
 * .#2.1
 * .....
 * #2.#.
 * ...2.
 * #2..1
 * you would return true, but given
 * <p>
 * ..2.1
 * ..#..
 * #2.#.
 * ...2.
 * #2..1
 * you would return false: There is a disconnected 2x2 block of water in the upper left, violating both of those rules.
 */
public class Nurikabe {
    private Set<String> set = new HashSet<>(new ArrayList<>() {{
//        add("1");
//        add("2");
//        add("3");
//        add("4");
//        add("5");
//        add("6");
//        add("7");
//        add("8");
//        add("9");
        add("#");
        add(".");
    }});
    //For valid 2x2 blocks, the directions should be (0,1), (1,0), (1,1)
    private int[] xBlock = new int[]{0, 1, 1};
    private int[] yBlock = new int[]{1, 0, 1};

    private int[] xIsland = new int[]{0, -1, 0, 1};
    private int[] yIsland = new int[]{-1, 0, 1, 0};

    private int[] xWater = new int[]{0, -1, 0, 1};
    private int[] yWater = new int[]{-1, 0, 1, 0};

    public boolean verify(String[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        //valid the character in matrix and whether there a 2x2 blocks existed
        if (!inputVerify(matrix, row, col))
            return false;
        //valid the islands
        boolean[][] visited = new boolean[row][col];
        if (!islandValid(matrix, row, col, visited))
            return false;
        //valid whether the water is connected
        visitedWater(matrix, row, col, visited);
        //valid whether there still exited "#" which is not visited
        if (hasRestIslandOrWater(matrix, row, col, visited)) {
            return false;
        }
        return true;
    }

    private boolean inputVerify(String[][] matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!(set.contains(matrix[i][j]) || isNumber(matrix[i][j])))
                    return false;
                //check 2x2 blocks
                boolean twoTotwo = true;
                if (matrix[i][j].equals(".")) {
                    if (i <= row - 2 && j <= col - 2) {
                        for (int k = 0; k < xBlock.length; k++) {
                            int rowDirection = i + xBlock[k];
                            int colDirection = j + yBlock[k];
                            if (rowDirection >= 0 && rowDirection < row && colDirection >= 0 && colDirection < col) {
                                if (matrix[rowDirection][colDirection].equals("."))
                                    continue;
                                twoTotwo = false;
                            }
                        }
                        if (twoTotwo)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean islandValid(String[][] matrix, int row, int col, boolean[][] visited) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isNumber(matrix[i][j])) {
                    int num = Integer.parseInt(matrix[i][j]);
                    if (num != islandSize(matrix, i, j, row, col, visited)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isNumber(String s) {
//        Pattern p = Pattern.compile("[0-9]*");
//        Matcher isNum = p.matcher(s);
//        if (isNum.matches())
//            return true;
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return num > 0;
    }

    private int islandSize(String[][] matrix, int i, int j, int row, int col, boolean[][] visited) {
        if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j] && !matrix[i][j].equals(".")) {
            visited[i][j] = true;
            int curSize = 1;
            for (int k = 0; k < xIsland.length; k++) {
                curSize += islandSize(matrix, i + xIsland[k], j + yIsland[k], row, col, visited);
            }
            return curSize;
        }
        return 0;
    }

    private boolean hasRestIslandOrWater(String[][] matrix, int row, int col, boolean[][] visited) {
        boolean hasRest = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((matrix[i][j].equals("#") || matrix[i][j].equals(".")) && !visited[i][j]) {
                    visited[i][j] = true;
                    hasRest = true;
                }
            }
        }
        return hasRest;
    }

    private void visitedWater(String[][] matrix, int row, int col, boolean[][] visited) {
        int i = 0;
        int j = 0;
        loop:
        for (; i < row; i++) {
            for (; j < col; j++) {
                if (matrix[i][j].equals("."))
                    break loop;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int k = 0; k < xWater.length; k++) {
                int nextX = x + xWater[k];
                int nextY = y + yWater[k];
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Nurikabe nurikabe = new Nurikabe();

        String[][] puzzle = {
                {".", "#", "2", ".", "1"},
                {".", ".", ".", ".", "."},
                {"#", "2", ".", "#", "."},
                {".", ".", ".", "2", "."},
                {"#", "2", ".", ".", "1"}};


        String[][] puzzle2 = {
                {".", ".", "2", ".", "1"},
                {".", ".", ".", ".", "."},
                {"#", "2", ".", "#", "."},
                {".", ".", ".", "2", "."},
                {"#", "2", ".", ".", "1"}};

        String[][] puzzle3 = {
                {".", "#", "2", ".", "10", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "2", ".", "#", ".", "#", "9", "#", "#", "#", "#", "#", "#", "#"},
                {".", ".", ".", "2", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "2", ".", ".", "10", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};

        String[][] puzzle4 = {
                {".", "3", ".", "#", "."},
                {"#", "#", ".", "#", "."},
                {".", ".", ".", "#", "."},
                {"7", "#", "#", "#", "."},
                {".", ".", ".", ".", "."}};

        String[][] puzzle5 = {
                {".", ".", ".", ".", "."},
                {".", ".", "#", "#", "."},
                {"10", "#", "#", "#", "."},
                {"#", "#", "#", "#", "."},
                {".", ".", ".", ".", "."}};

        String[][] puzzle6 = {
                {".", ".", ".", ".", "."},
                {".", ".", ".", "#", "."},
                {".", ".", ".", "#", "."},
                {"6", "#", "#", "#", "."},
                {".", ".", ".", ".", "."}};

        String[][] puzzle7 = {
                {".", ".", ".", "#", "."},
                {".", ".", ".", "#", "."},
                {".", ".", ".", "#", "."},
                {"7", "#", "#", "#", "."},
                {".", ".", ".", ".", "."}};

        System.out.println(nurikabe.verify(puzzle));//true
        System.out.println(nurikabe.verify(puzzle2));//false
        System.out.println(nurikabe.verify(puzzle3));//true
        System.out.println(nurikabe.verify(puzzle4));//false
        System.out.println(nurikabe.verify(puzzle5));//false
        System.out.println(nurikabe.verify(puzzle6));//false
        System.out.println(nurikabe.verify(puzzle7));//false
    }
}
