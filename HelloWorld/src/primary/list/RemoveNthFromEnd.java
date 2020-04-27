package primary.list;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class RemoveNthFromEnd extends BaseObj {

    public RemoveNthFromEnd(ListNode head) {
        super(head);
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (count <= 1)
            return null;

        int nth = count - n + 1;
        int tempcount = 1;
        temp = head;
        while (tempcount <= nth) {
            if (tempcount == nth) {
                temp.val = temp.next.val;
                temp.next = temp.next.next;
            } else if (tempcount + 1 == count) {
                temp.next = null;
                break;
            } else {
                temp = temp.next;
            }
            tempcount++;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd(new ListNode(1));
        removeNthFromEnd.generateList(new int[]{2, 3, 4, 5});
        removeNthFromEnd.showList();

        removeNthFromEnd.removeNthFromEnd(removeNthFromEnd.head, 2);
        removeNthFromEnd.showList();

    }

}
