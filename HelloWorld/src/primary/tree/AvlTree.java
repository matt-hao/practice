package primary.tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * kkkk0
 * kkk/ \
 * k-3   9
 * k/   /
 * -10  5
 */
public class AvlTree extends BaseTree {
    /**
     * This method can be changed to be compatible with all conditions
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = null;
        for (int a : nums) {
            treeNode = insert(treeNode, new TreeNode(a));
        }
        return treeNode;
    }

    private TreeNode insert(TreeNode node, TreeNode insert) {
        if (node == null)
            node = insert;
        else {
            node.right = insert(node.right, insert);
            int lHeight = getHeight(node.left);
            int rHeight = getHeight(node.right);
            if (Math.abs(lHeight - rHeight) >= 2) {
                node = RR(node);
            }
        }
        return node;
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(getHeight(node.left) + 1, getHeight(node.right) + 1);
    }

    private TreeNode RR(TreeNode node) {
        TreeNode save = node.right;
        TreeNode temp = node.right.left;
        node.right.left = node;
        node.right = temp;
        return save;
    }

    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        TreeNode treeNode = avlTree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        avlTree.showTree_Bfs(treeNode);
    }
}
