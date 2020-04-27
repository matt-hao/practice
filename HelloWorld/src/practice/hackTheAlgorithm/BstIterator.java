package practice.hackTheAlgorithm;

import java.util.Stack;

public class BstIterator {
    Stack<TreeNode> stack;
    TreeNode cur;

    /*
     * @param root: The root of binary tree.
     */
    public BstIterator(TreeNode root) {
        // do intialization if necessary
        cur = root;
        stack = new Stack<>();
        iterator();
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty() || cur != null;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode temp = stack.pop();
        if (temp.right != null) {
            cur = temp.right;
            iterator();
        }
        return temp;
    }

    private void iterator() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        BstIterator bstIterator = new BstIterator(null);
        while(bstIterator.hasNext()){
            TreeNode node = bstIterator.next();
            System.out.println(node.val);
        }
    }
}
