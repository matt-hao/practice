package interview.alibaba;

public class InsertList {
    private ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummy.next;
    }

    private String print(ListNode head) {
        if (head == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val + "->");
            head = head.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public ListNode insertNode(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val >= val) {
                ListNode node = new ListNode(val);
                node.next = cur.next;
                cur.next = node;
                return dummy.next;
            } else {
                cur = cur.next;
            }
        }
        cur.next = new ListNode(val);
        return dummy.next;
    }


    public static void main(String[] args) {
        //testCase1
        InsertList insertList = new InsertList();
        int[] arr1 = {1, 2, 3, 4, 5, 7, 8, 9, 20};
        ListNode head1 = insertList.buildList(arr1);
        head1 = insertList.insertNode(head1, 6);
        System.out.println(insertList.print(head1));


        //testCase2
        int[] arr2 = null;
        ListNode head2 = insertList.buildList(arr2);
        head2 = insertList.insertNode(head2, 100);
        System.out.println(insertList.print(head2));

        //testCase3
        int[] arr3 = new int[]{1, 2, 2, 2, 2, 2, 4, 5, 5, 6, 8, 8};
        ListNode head3 = insertList.buildList(arr3);
        head3 = insertList.insertNode(head3, 5);
        System.out.println(insertList.print(head3));

        //testCase4
        int[] arr4 = new int[]{1, 2, 2, 2, 2, 2, 4, 5, 5, 6, 8, 8};;
        ListNode head4 = insertList.buildList(arr4);
        head4 = insertList.insertNode(head4, Integer.MIN_VALUE);
        System.out.println(insertList.print(head4));
    }
}


class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}