package practice.hackTheAlgorithm;

import java.util.PriorityQueue;

/**
 * leetcode:23. Merge k Sorted Lists (hard)
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    //O(nk)时间复杂度，如果k = n,时间复杂度为O(n ^ 2), 空间复杂度为O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        int minIndex = findMinNode(lists);
        if (minIndex == -1)
            return null;
        ListNode res = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        ListNode temp = res;
        while ((minIndex = findMinNode(lists)) != -1) {
            temp.next = lists[minIndex];
            temp = temp.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return res;
    }

    private int findMinNode(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            if (lists[i].val < min) {
                index = i;
                min = lists[i].val;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        MergeKLists m = new MergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.build(new int[]{1, 4, 5});
        lists[1] = ListNode.build(new int[]{1, 3, 4});
        lists[2] = ListNode.build(new int[]{2, 6});

        System.out.println(m.mergeKLists(lists));


//        //test
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (ListNode x, ListNode y) -> x.val - y.val);
//        priorityQueue.offer(null);
//        int[] temp = new int[4];
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode build(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode start = new ListNode(arr[0]);
        ListNode temp = start;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return start;
    }
}