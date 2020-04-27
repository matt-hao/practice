package primary.tree;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */
public class MaxDepth extends BaseTree {
    public MaxDepth(Integer[] arr) {
        super(arr);
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return find(root, 1, 1);
    }

    private int find(TreeNode node, int height, int count) {
        if (node.left != null) {
            count++;
            height = find(node.left, height, count);
            height = Math.max(height, count);
            count--;
        }
        if (node.right != null) {
            count++;
            height = find(node.right, height, count);
            height = Math.max(height, count);
        }
        return height;
    }

    public static void main(String[] args) {
//        MaxDepth maxDepth = new MaxDepth(new Integer[]{3, 9, 20, null, null, 15, 7});
        MaxDepth maxDepth = new MaxDepth(new Integer[]{1, 2, null, 3, null, null, null, 4});
        System.out.println("BFS==============");
        maxDepth.showTree_Bfs();
        System.out.println("DFS==============");
        maxDepth.showTree_Dfs();
        System.out.println("The height is :" + maxDepth.maxDepth(maxDepth.root));
    }
}
