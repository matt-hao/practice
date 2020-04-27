package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
 * <p>
 * Example
 * Given matrix:
 * <p>
 * doaf
 * agai
 * dcan
 * and dictionary:
 * <p>
 * {"dog", "dad", "dgdg", "can", "again"}
 * <p>
 * return {"dog", "dad", "can", "again"}
 */
public class WordSearchII {
    private int[] xDelta = new int[]{-1, 0, 1, 0};
    private int[] yDelta = new int[]{0, -1, 0, 1};

    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        if (words == null)
            return new ArrayList<String>();
        Set<String> setsMap = strSet(words);
        Set<String> setRes = resSets(words);
        Set<String> rsSets = new HashSet<>();
        int xLen = board.length;
        int yLen = board[0].length;
        boolean[][] visited = new boolean[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                helper(board, i, j, "", visited, setsMap, setRes, rsSets);
            }
        }
        return new ArrayList<String>(rsSets);
    }

    private void helper(char[][] board, int x, int y, String curStr, boolean[][] visited,
                        Set<String> setsMap, Set<String> setRes, Set<String> res) {
        if (curStr.length()!=0 && !setsMap.contains(curStr))
            return;
        if (setRes.contains(curStr)) {
            res.add(curStr);
            return;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length)
            return;

        if (visited[x][y])
            return;

        for (int i = 0; i < xDelta.length; i++) {
            visited[x][y] = true;
            helper(board, x + xDelta[i], y + yDelta[i], curStr + String.valueOf(board[x][y]), visited, setsMap, setRes, res);
            visited[x][y] = false;
        }
    }

    private Set<String> strSet(List<String> words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }
        return set;
    }

    private Set<String> resSets(List<String> words) {
        return new HashSet<>(words);
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] chars = new char[][]{
                {'d', 'o', 'a', 'f'},
                {'a', 'g', 'a', 'i'},
                {'d', 'c', 'a', 'n'}
        };
        //{"dog", "dad", "dgdg", "can", "again"}
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("dad");
        list.add("dgdg");
        list.add("can");
        list.add("again");
        System.out.println(wordSearchII.wordSearchII(chars, list));
    }
}
