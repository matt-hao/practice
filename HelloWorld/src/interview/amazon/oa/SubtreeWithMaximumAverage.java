package interview.amazon.oa;

/**
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 * <p>
 * (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values,
 * divided by the number of nodes.)
 * <p>
 * Example 1:
 * Input: [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 5000.
 * Each node will have a value between 0 and 100000.
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 */
public class SubtreeWithMaximumAverage {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        return helper(root).max;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0, 0);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        int sum = left.sum + right.sum + root.val;
        int num = left.num + right.num + 1;
        double max = (double) sum / (double) num;
        max = Math.max(max, Math.max(left.max, right.max));
        return new Result(max, sum, num);
    }

    class Result {
        double max;
        int sum;
        int num;

        public Result(double max, int sum, int num) {
            this.max = max;
            this.sum = sum;
            this.num = num;
        }
    }
}
