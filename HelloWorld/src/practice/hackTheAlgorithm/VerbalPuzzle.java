package practice.hackTheAlgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VerbalPuzzle {
    public static void main(String[] args) {
        VerbalPuzzle v = new VerbalPuzzle();
        //words = ["SEND","MORE"], result = "MONEY"
        String[] words1 = new String[]{"SEND", "MORE"};
        System.out.println(v.isSolvable(words1, "MONEY"));

        //["SEIS","CATORCE","SETENTA"]
        //"NOVENTA"
        String[] words2 = new String[]{"SEIS","CATORCE","SETENTA"};
        System.out.println(v.isSolvable(words2, "NOVENTA"));
    }

    private boolean res;

    public boolean isSolvable(String[] words, String result) {
        String[] nw = new String[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            nw[i] = words[i];
        }
        nw[words.length] = result;
        Set<Character> dic = getCha(nw);

        if (dic.size() > 10) return false;

        res = false;
        boolean[] visited = new boolean[10];

        Set<Character> initial = getInit(nw);
        char[] arr = new char[dic.size()];
        int cnt = 0;
        for (char c : dic) {
            arr[cnt++] = c;
        }
        helper(words, visited, result, 0, arr, new HashMap<>(), initial);
        return res;
    }

    private void helper(String[] words, boolean[] visited, String result,
                        int idx, char[] arr, Map<Character, Integer> map, Set<Character> init) {
        if (res) return;
        if (idx == arr.length) {
            if (valid(words, result, map)) {
                res = true;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (i == 0 && init.contains(arr[idx])) continue;
            map.put(arr[idx], i);
            visited[i] = true;
            helper(words, visited, result, idx + 1, arr, map, init);
            visited[i] = false;
            map.remove(arr[idx]);
        }
    }

    private Set<Character> getInit(String[] nw) {
        Set<Character> set = new HashSet<>();
        for (String w : nw) {
            set.add(w.charAt(0));
        }
        return set;
    }

    private boolean valid(String[] words, String result, Map<Character, Integer> map) {
        int rsum = getNum(result, map);
        if (rsum == -1) return false;

        int sum = 0;
        for (String w : words) {
            int t = getNum(w, map);
            if (t == -1) return false;
            sum += t;
        }

        return rsum == sum;
    }

    private int getNum(String str, Map<Character, Integer> map) {
        // System.out.println(map);
        if (map.get(str.charAt(0)) == 0) return -1;
        int r = 0;
        for (char c : str.toCharArray()) {
            r = r * 10 + map.get(c);
        }
        return r;
    }

    private Set<Character> getCha(String[] words) {
        Set<Character> dic = new HashSet<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                dic.add(c);
            }
        }
        return dic;
    }
}
