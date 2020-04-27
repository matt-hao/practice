package practice.hackTheAlgorithm;

import java.util.Arrays;

public class DiscreateArray {
    public int[] discreate(int[] arr) {
        Node[] temp = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = new Node(arr[i], i);
        }
        Arrays.sort(temp);
        int i, j;
        for (i = 0, j = 0; i < arr.length - 1; i++, j++) {
            arr[temp[i].index] = j;
            if (temp[i].val == temp[i + 1].val) {
                j--;
            }
        }

        if (i == arr.length - 1) {
            arr[temp[i].index] = j;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 23, 4, 2, -1, 23};
        DiscreateArray discreateArray = new DiscreateArray();
        System.out.println(Arrays.toString(discreateArray.discreate(arr)));
    }
}

class Node implements Comparable<Node> {
    public int val;
    public int index;

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}