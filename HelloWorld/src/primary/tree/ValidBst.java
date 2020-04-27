package primary.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */
public class ValidBst extends BaseTree {
    public ValidBst(Integer[] arr) {
        super(arr);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return method(root.left, Long.MIN_VALUE, root.val) && method(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean method(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        return method(node.left, min, node.val) && method(node.right, node.val, max);
    }

    public static void main(String[] args) {
        ValidBst validBst = new ValidBst(new Integer[]{5, 1, 4, null, null, 3, 6});
        validBst.showTree_Bfs();
        validBst.showTree_Dfs();

        System.out.println(validBst.isValidBST(validBst.root));

        ValidBst validBst1 = new ValidBst(new Integer[]{2, 1, 3});
        validBst1.showTree_Bfs();
        validBst1.showTree_Dfs();

        System.out.println(validBst1.isValidBST(validBst1.root));
    }
}
