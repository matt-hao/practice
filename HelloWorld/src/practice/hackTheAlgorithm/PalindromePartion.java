package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PalindromePartion {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (s == null)
            return res;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, new ArrayList<String>()));

        Pair pair = null;
        while (!queue.isEmpty()) {
            pair = queue.poll();
            if (pair.startIndex == s.length()) {
                res.add(pair.list);
                break;
            }

            for (int i = pair.startIndex; i < s.length(); i++) {
                if (!isPalindrome(s, pair.startIndex, i))
                    continue;
                Pair temp = new Pair(pair);
                temp.list.add(s.substring(pair.startIndex, i + 1));
                temp.startIndex = i + 1;
                queue.offer(temp);
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

class Pair {
    public int startIndex;
    public List<String> list;

    public Pair(int startIndex, List<String> list) {
        this.startIndex = startIndex;
        this.list = list;
    }

    public Pair(Pair pair) {
        this(pair.startIndex, new ArrayList<String>(pair.list));
    }
}