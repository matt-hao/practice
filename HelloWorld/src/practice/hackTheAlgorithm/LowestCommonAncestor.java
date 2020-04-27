package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null)
            return null;
        List<TreeNode> listA = listPath(root, A.val, new ArrayList<>());
        List<TreeNode> listB = listPath(root, B.val, new ArrayList<>());
        int i = 0;
        for (; i < listA.size() && i < listB.size(); i++) {
            if (listA.get(i) == listB.get(i))
                continue;
            break;
        }
        if (i == 0)
            return listA.get(0);
        return listA.get(i - 1);
    }

    private List<TreeNode> listPath(TreeNode root, int target, List<TreeNode> res) {
        if (root == null)
            return res;
        res.add(root);
        if (target == root.val)
            return res;
        if (target < root.val)
            return listPath(root.left, target, res);
        return listPath(root.right, target, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.right = node2;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor3(root, new TreeNode(1), new TreeNode(3)).val);
    }
}
