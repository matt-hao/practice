package primary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * kkkk1
 * kkk/ \
 * kk2   2
 * k/ \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * kkk1
 * kk/ \
 * k2   2
 * k\   \
 * k3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree extends BaseTree {
    public SymmetricTree(Integer[] arr) {
        super(arr);
    }

    /**
     * recursive
     */
    public boolean isSymmetric_recursive(TreeNode root) {
        if (root == null)
            return true;
        return method(root.left, root.right);
    }

    private boolean method(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return method(node1.left, node2.right) && method(node1.right, node2.left);
    }

    /**
     * iterate
     */
    public boolean isSymmetric_Iterate(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root.left);
        nodeQueue.offer(root.right);
        while (!nodeQueue.isEmpty()) {
            TreeNode node1 = nodeQueue.poll();
            TreeNode node2 = nodeQueue.poll();

            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            nodeQueue.offer(node1.left);
            nodeQueue.offer(node2.right);
            nodeQueue.offer(node1.right);
            nodeQueue.offer(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("================Iterate=========");
        SymmetricTree symmetricTree1 = new SymmetricTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(symmetricTree1.isSymmetric_Iterate(symmetricTree1.root));

        SymmetricTree symmetricTree2 = new SymmetricTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println(symmetricTree2.isSymmetric_Iterate(symmetricTree2.root));

        System.out.println("================Recursive=========");
        SymmetricTree symmetricTree3 = new SymmetricTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(symmetricTree3.isSymmetric_recursive(symmetricTree3.root));

        SymmetricTree symmetricTree4 = new SymmetricTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println(symmetricTree4.isSymmetric_recursive(symmetricTree4.root));
    }
}
