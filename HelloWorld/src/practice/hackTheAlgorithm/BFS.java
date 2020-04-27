package practice.hackTheAlgorithm;

import java.util.*;

public class BFS {
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                assert temp != null;
                list.add(temp.val);

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    private TreeNode buildTree(Integer[] nums) {
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            treeNodes[i] = nums[i] == null ? null : new TreeNode(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (treeNodes[i] == null)
                continue;
            if (i * 2 + 1 <= nums.length - 1 && nums[i * 2 + 1] != null)
                treeNodes[i].left = treeNodes[i * 2 + 1];
            if (i * 2 + 2 <= nums.length - 1 && nums[i * 2 + 2] != null)
                treeNodes[i].right = treeNodes[i * 2 + 2];

        }
        return treeNodes[0];
    }

    public static void main(String[] args) {

        BFS bfs = new BFS();
        TreeNode treeNode = bfs.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> list = bfs.bfs(treeNode);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}
