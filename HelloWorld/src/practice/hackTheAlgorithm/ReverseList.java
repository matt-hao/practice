package practice.hackTheAlgorithm;

public class ReverseList {
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null)
            return head;
        ListNode newHead = new ListNode(-1);
        helper(head, newHead);
        return newHead.next;
    }

    private ListNode helper(ListNode head, ListNode newHead) {
        if (head.next == null) {
            newHead.next = head;
            return head;
        }

        ListNode next = helper(head.next, newHead);
        next.next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);

        ReverseList reverseList = new ReverseList();
        ListNode newNode = reverseList.reverse(l1);
        System.out.println(newNode);
    }
}
