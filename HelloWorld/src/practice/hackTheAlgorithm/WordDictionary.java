package practice.hackTheAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        root.insert(root, word);
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        TreeNode res = root.find(root, word);
        return res != null && res.isWord;
    }

    class TreeNode {
        char c;
        Map<Character, TreeNode> childs;
        boolean isWord;

        public TreeNode() {
            this.childs = new HashMap<>();
            this.isWord = false;
        }

        public TreeNode(char c) {
            this.c = c;
            this.childs = new HashMap<>();
            this.isWord = false;
        }

        public TreeNode find(TreeNode root, String word) {
            if (word == null || word.length() == 0)
                return null;
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Map<Character, TreeNode> cds = cur.childs;
                if (c == '.') {
                    System.out.print("fuck");
                    if (i == word.length() - 1)
                        return cds.get(cds.keySet().iterator().next());

                    for (char ch : cds.keySet()) {
                        TreeNode node = find(cds.get(c), word.substring(i + 1));
                        if (node != null && node.isWord)
                            return node;
                    }
                    return null;
                } else if (cds.containsKey(c)) {
                    cur = cds.get(c);
                } else
                    return null;
            }
            return cur;
        }

        public void insert(TreeNode root, String word) {
            if (word == null || word.length() == 0)
                return;
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                Map<Character, TreeNode> cds = cur.childs;
                if (cds.containsKey(c)) {
                    cur = cds.get(c);
                } else {
                    TreeNode nNode = new TreeNode(c);
                    cds.put(c, nNode);
                    cur = nNode;
                }
            }
            cur.isWord = true;
        }
    }
}
