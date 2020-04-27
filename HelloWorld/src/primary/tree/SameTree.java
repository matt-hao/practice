package primary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * compare two tree to check their equity
 */
public class SameTree extends BaseTree {
    public SameTree(Integer[] arr) {
        super(arr);
    }

    /**
     * recursive
     */
    boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {
            return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        }
        return false;
    }

    /**
     * iterate...bst
     */
    boolean isSameTreeIterate(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offer(node1);
            nodeQueue.offer(node2);
            while (!nodeQueue.isEmpty()) {
                TreeNode nodeOne = nodeQueue.poll();
                TreeNode nodeTwo = nodeQueue.poll();
                if (nodeOne == null && nodeTwo == null)
                    continue;
                if (nodeOne == null || nodeTwo == null)
                    return false;
                if (nodeOne.val != nodeTwo.val)
                    return false;
                nodeQueue.offer(nodeOne.left);
                nodeQueue.offer(nodeTwo.left);
                nodeQueue.offer(nodeOne.right);
                nodeQueue.offer(nodeTwo.right);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        SameTree sameTree1 = new SameTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}), sameTree2 = new SameTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(sameTree1.isSameTreeIterate(sameTree1.root, sameTree2.root));


        SameTree sameTree3 = new SameTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}), sameTree4 = new SameTree(new Integer[]{1, 2, 2, 3, 1, 4, 3});
        System.out.println(sameTree1.isSameTreeIterate(sameTree3.root, sameTree4.root));
    }
}
