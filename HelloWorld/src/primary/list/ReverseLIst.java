package primary.list;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLIst extends BaseObj {

    private ListNode newNode = null;
    private int count = 1;

    public ReverseLIst(ListNode head) {
        super(head);
    }

    /**
     * recursive
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            newNode = head;
            return head;
        }
        count++;
        reverseList(head.next).next = head;
        head.next = null;
        count--;
        if (count == 1) {
            return newNode;
        }
        return head;
    }

    /**
     * iterate
     */
    public ListNode reverseList_iterate(ListNode head) {
        if (head == null)
            return null;

        ListNode ph, pc;
        ph = pc = head;

        while (ph.next != null) {
            ListNode pn = ph.next;
            ph.next = pn.next;
            pn.next = pc;
            pc = pn;
        }
        return pc;
    }

    public static void main(String[] args) {
        ReverseLIst reverseLIst = new ReverseLIst(new ListNode(1));
        reverseLIst.generateList(new int[]{2, 3, 4, 5});
        reverseLIst.showList();

        ListNode listNode = reverseLIst.reverseList(reverseLIst.head);

        reverseLIst.showList(listNode);

        ReverseLIst reverseLIst1 = new ReverseLIst(new ListNode(1));
        reverseLIst1.generateList(new int[]{2, 3, 4, 5});
        reverseLIst1.showList();

        reverseLIst1.showList(reverseLIst1.reverseList_iterate(reverseLIst1.head));
    }
}
