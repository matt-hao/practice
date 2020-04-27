package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatedWord {

    public static void main(String[] args) {
        ConcatedWord c = new ConcatedWord();
        System.out.println(c.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Trie t = new Trie();
        for (String w : words) {
            t.insert(w);
        }
        for (String w : words) {
            if (helper(w, 0, t, 0))
                res.add(w);
        }
        return res;
    }

    private boolean helper(String word, int idx, Trie t, int cnt) {
        TreeNode cur = t.root;
        for (int i = idx; i < word.length(); i++) {
            Map<Character, TreeNode> child = cur.child;
            if (!child.containsKey(word.charAt(i))) return false;
            cur = child.get(word.charAt(i));
            if (cur.isWord) {
                if (i == word.length() - 1) return cnt > 0;
                if (helper(word, i + 1, t, cnt + 1)) return true;
            }
        }
        return false;
    }

    class Trie {
        TreeNode root;

        public Trie() {
            root = new TreeNode('#');
        }

        public void insert(String word) {
            TreeNode cur = this.root;
            for (char c : word.toCharArray()) {
                Map<Character, TreeNode> child = cur.child;
                if (child.containsKey(c)) {
                    cur = child.get(c);
                } else {
                    TreeNode node = new TreeNode(c);
                    child.put(c, node);
                    cur = node;
                }
            }
            cur.isWord = true;
        }
    }

    class TreeNode {
        char c;
        Map<Character, TreeNode> child;
        boolean isWord;

        public TreeNode(char c) {
            this.c = c;
            this.child = new HashMap<>();
            this.isWord = false;
        }
    }

}

