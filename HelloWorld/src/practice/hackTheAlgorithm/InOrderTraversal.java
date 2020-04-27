package practice.hackTheAlgorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> lists = new LinkedList<>();
        if (node == null)
            return lists;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode temp = stack.pop();
            lists.add(temp.val);
            if (temp.right != null)
                node = temp.right;
        }
        return lists;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
