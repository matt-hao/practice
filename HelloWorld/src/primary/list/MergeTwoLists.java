package primary.list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoLists extends BaseObj {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode newHead, newCur;
        if (l1.val < l2.val) {
            newHead = newCur = l1;
            l1 = l1.next;
        } else {
            newHead = newCur = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newCur.next = l1;
                l1 = l1.next;
            } else {
                newCur.next = l2;
                l2 = l2.next;
            }
            newCur = newCur.next;
        }

        newCur.next = l1 != null ? l1 : l2;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(new ListNode(1));
        listNode1.generateList(new int[]{2, 4});

        ListNode2 listNode2 = new ListNode2(new ListNode(1));
        listNode2.generateList(new int[]{3, 4});

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode newListNode = mergeTwoLists.mergeTwoLists(listNode1.head, listNode2.head);
        mergeTwoLists.showList(newListNode);
    }
}


class ListNode1 extends BaseObj {
    public ListNode1(ListNode head) {
        super(head);
    }
}

class ListNode2 extends BaseObj {
    public ListNode2(ListNode head) {
        super(head);
    }
}

