package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (n <= 0)
            return res;
        helper(n, 0, new int[n][n], new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int n, int layer, int[][] visited, List<Integer> permutation, List<List<String>> res) {
        if (permutation.size() == n) {
            List<String> strList = convert(permutation);
            res.add(strList);
            return;
        }

        if (layer >= n)
            return;

        for (int i = 0; i < n; i++) {
            if (!isValid(visited, i, layer))
                continue;
            permutation.add(i);
            change(visited, i, layer, 1);
            helper(n, layer + 1, visited, permutation, res);
            change(visited, i, layer, -1);
            permutation.remove(permutation.size() - 1);
        }
    }

    private List<String> convert(List<Integer> list) {
        //to do...
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(intToStr(list.size(), list.get(i)));
        }
        return res;
    }

    private String intToStr(int n, int pos) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i == pos)
                sb.append("Q");
            else
                sb.append(".");
        }
        return sb.toString();
    }

    private boolean isValid(int[][] visited, int i, int layer) {
        return visited[layer][i] == 0;
    }

    private void change(int[][] visited, int i, int layer, int remove) {
        int n = visited.length;
        //vertical
        for (int j = layer; j < n; j++) {
            visited[j][i] += remove;
        }
        //left
        for (int j = layer, k = i; j < n && k >= 0; j++, k--) {
            visited[j][k] += remove;
        }
        //right
        for (int j = layer, k = i; j < n && k < n; j++, k++) {
            visited[j][k] += remove;
        }
    }

    public static void main(String[] args) {
        Nqueens n = new Nqueens();
        System.out.println(n.solveNQueens(5));
    }
}
