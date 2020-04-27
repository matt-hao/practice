package practice.hackTheAlgorithm;

import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end))
            return 1;
        dict.add(start);
        dict.add(end);
        Map<String, Set<String>> map = buildGraph(dict);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (end.equals(temp))
                    return step;
                for (String s : map.get(temp)) {
                    if (set.contains(s))
                        continue;
                    set.add(s);
                    queue.offer(s);
                }
            }
            step++;
        }
        return -1;
    }

    private Map<String, Set<String>> buildGraph(Set<String> dict) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : dict) {
            Set<String> neighbors = getNeighbors(s, dict);
            map.put(s, neighbors);
        }
        return map;
    }

    private Set<String> getNeighbors(String s, Set<String> dict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (s.charAt(i) == j)
                    continue;
                String temp = nextString(s, i, j);
                if (dict.contains(temp)) {
                    set.add(temp);
                }
            }
        }
        return set;
    }

    private String nextString(String s, int i, char j) {
        char[] c = s.toCharArray();
        c[i] = j;
        // return new String(c);
        return c.toString();
    }

    public static void main(String[] args) {
        String[] temp = new String[]{"hot", "dot", "dog", "lot", "log"};
        Set<String> set = new HashSet<>(Arrays.asList(temp));
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("hit", "cog", set));
    }
}
