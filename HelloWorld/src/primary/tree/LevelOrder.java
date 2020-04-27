package primary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * kkk3
 * kk/ \
 * k9  20
 * kkk/  \
 * k15   7
 * return its level order traversal as:
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LevelOrder extends BaseTree {

    public LevelOrder(Integer[] arr) {
        super(arr);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            List<List<Integer>> lists = new LinkedList<>();

            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()) {
                List<TreeNode> listTemp = new LinkedList<>();

                while (!nodeQueue.isEmpty()) {
                    TreeNode nodeTemp = nodeQueue.poll();
                    listTemp.add(nodeTemp);
                }
                if (!listTemp.isEmpty()) {
                    List<Integer> listInt = new LinkedList<>();
                    for (TreeNode node : listTemp) {
                        listInt.add(node.val);
                        if (node.left != null)
                            nodeQueue.offer(node.left);
                        if (node.right != null)
                            nodeQueue.offer(node.right);
                    }
                    lists.add(listInt);
                }
            }
            return lists;
        }
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder(new Integer[]{});
        System.out.println(levelOrder.levelOrder(levelOrder.root));
    }
}
