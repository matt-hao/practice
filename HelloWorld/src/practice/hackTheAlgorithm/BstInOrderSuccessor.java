package practice.hackTheAlgorithm;

public class BstInOrderSuccessor {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null)
            return null;
        p.left = null;
        p.right = null;
        p = find(root, p);
        if (p.right == null || p.right.left == null)
            return p.right;
        p = p.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    private TreeNode find(TreeNode node, TreeNode p) {
        if (node == null)
            return p;
        if (node.val < p.val)
            return find(node.right, p);
        else if (node.val > p.val)
            return find(node.left, p);
        else
            return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        BstInOrderSuccessor b = new BstInOrderSuccessor();
        TreeNode temp = b.inorderSuccessor(root, new TreeNode(1));
        System.out.println(temp == null ? null : temp.val);

    }
}
