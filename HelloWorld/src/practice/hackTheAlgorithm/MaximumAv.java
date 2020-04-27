package practice.hackTheAlgorithm;

public class MaximumAv {
    private double max;
    private TreeNode maxNode;

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null)
            return null;
        max = Double.NEGATIVE_INFINITY;
        maxNode = root;
        helper(root);
        return maxNode;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int left = helper(node.left);
        int right = helper(node.right);
        int num = 3;
        if (left == Integer.MIN_VALUE) {
            left = 0;
            num--;
        }
        if (right == Integer.MIN_VALUE) {
            right = 0;
            num--;
        }
        double maxTemp = (left + right + node.val) / num;
        if (maxTemp > max) {
            max = maxTemp;
            maxNode = node;
        }
        return left + right + node.val;
    }

    public static void main(String[] args) {
        MaximumAv m = new MaximumAv();
    }
}
