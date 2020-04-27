package primary.tree;

import java.util.*;

public class BaseTree {

    protected TreeNode root;

    public BaseTree() {
    }

    public BaseTree(Integer[] arr) {
        if (arr != null && arr.length != 0) {
            this.root = new TreeNode(arr[0]);
            generate(this.root, 0, arr);
        }
    }

    /**
     * DFS
     */
    private void generate(TreeNode treeNode, int pos, Integer[] arr) {
        if (2 * pos + 1 < arr.length && arr[2 * pos + 1] != null) {
            treeNode.left = new TreeNode(arr[2 * pos + 1]);
            generate(treeNode.left, 2 * pos + 1, arr);
        }
        if (2 * pos + 2 < arr.length && arr[2 * pos + 2] != null) {
            treeNode.right = new TreeNode(arr[2 * pos + 2]);
            generate(treeNode.right, 2 * pos + 2, arr);
        }
    }

    /**
     * BFS
     */
    protected void showTree_Bfs(TreeNode... nodes) {
        TreeNode root;
        if (nodes == null || nodes.length == 0) {
            root = this.root;
        } else {
            root = nodes[0];
        }

        if (root != null) {
            System.out.println("===========BFS===========");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.val + ":[");
                if (node.left != null) {
                    queue.offer(node.left);
                    System.out.print(node.left.val);
                } else {
                    System.out.print("");
                }
                System.out.print(",");
                if (node.right != null) {
                    queue.offer(node.right);
                    System.out.print(node.right.val);
                } else {
                    System.out.print("");
                }
                System.out.println("]");
            }

        }
    }

    /**
     * DFS
     */
    protected void showTree_Dfs() {
        if (this.root != null) {
            System.out.println("===========DFS===========");
            Stack<TreeNode> stack = new Stack<>();
            stack.push(this.root);

            while (!stack.empty()) {
                TreeNode node = stack.pop();

                System.out.print(node.val + ":[");
                if (node.left != null) {
                    System.out.print(node.left.val);
                    stack.push(node.left);
                } else {
                    System.out.print("");
                }
                System.out.print(",");
                if (node.right != null) {
                    System.out.print(node.right.val);
                    stack.push(node.right);
                } else {
                    System.out.print("");
                }
                System.out.println("]");
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



