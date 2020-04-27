package practice.hackTheAlgorithm;

import java.util.*;

class AutocompleteSystem {

    public static void main(String[] args) {
        String[] str = new String[]{"i love you", "island", "iroman", "i love leetcode"};
        int[] times = new int[]{5, 3, 2, 2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(str, times);
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));

    }

    private Map<String, Integer> map;
    private Trie trie;
    private TreeNode node;
    private StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.map = new HashMap<>();
        this.trie = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            this.trie.insert(sentences[i]);
            this.map.put(sentences[i], times[i]);
        }
        this.node = this.trie.root;
        this.sb = new StringBuilder();
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            this.trie.insert(this.sb.toString());
            this.map.put(this.sb.toString(), this.map.getOrDefault(this.sb.toString(), 0) + 1);
            this.node = this.trie.root;
            this.sb = new StringBuilder();
            return res;
        } else {
            Map<Character, TreeNode> child = this.node.child;
            if (child.containsKey(c)) {
                this.node = child.get(c);
            } else {
                TreeNode n = new TreeNode(c);
                child.put(c, n);
                this.node = n;
            }
            this.sb.append(c);
            res = new ArrayList<>(this.node.set);
        }
        res.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1.compareTo(o2);
            }
            return map.get(o2) - map.get(o1);
        });
        return res.size() <= 3 ? res : res.subList(0, 3);
    }

    class Trie {
        TreeNode root;

        public Trie() {
            this.root = new TreeNode('#');
        }

        public void insert(String str) {
            TreeNode cur = this.root;
            for (char c : str.toCharArray()) {
                Map<Character, TreeNode> child = cur.child;
                if (child.containsKey(c)) {
                    cur = child.get(c);
                } else {
                    TreeNode n = new TreeNode(c);
                    child.put(c, n);
                    cur = n;
                }
                cur.set.add(str);
            }
            cur.sentence = str;
        }
    }

    class TreeNode {
        char c;
        Map<Character, TreeNode> child;
        Set<String> set;
        String sentence;

        public TreeNode(char c) {
            this.c = c;
            this.child = new HashMap<>();
            this.set = new HashSet<>();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */