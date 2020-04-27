package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserialize {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                list.add("#");
                continue;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
            list.add(temp.val + "");
        }

        int i = list.size() - 1;
        for (; i >= 0; i--) {
            if (!list.get(i).equals("#"))
                break;
        }
        list = list.subList(0, i + 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int j = 0; j < list.size(); j++) {
            stringBuilder.append(list.get(j));
            if (j != list.size() - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0)
            return null;
        data = data.substring(1, data.length() - 1);
        String[] ca = data.split(",");
        if (ca[0].equals("#"))
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ca[0]));
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                continue;
            }
            if (i < ca.length) {
                temp.left = ca[i].equals("#") ? null : new TreeNode(Integer.parseInt(ca[i]));
                i++;
                queue.offer(temp.left);
            }
            if (i < ca.length) {
                temp.right = ca[i].equals("#") ? null : new TreeNode(Integer.parseInt(ca[i]));
                i++;
                queue.offer(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserialize s = new SerializeAndDeserialize();
        String s1 = "{1,#,2}";
        String s2 = "{1,#,2,#,3,#,4}";

        TreeNode treeNode = s.deserialize(s1);
        System.out.println(s.serialize(treeNode));
    }
}
