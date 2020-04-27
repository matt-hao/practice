package primary.list;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Cycle extends BaseObj {

    public Cycle(ListNode head) {
        super(head);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast, lower;
        fast = lower = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            lower = lower.next;

            if (fast == lower) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle(new ListNode(3));
        cycle.generateList(new int[]{2, 0, -4});
        cycle.showList();

        cycle.findNode(4).next = cycle.head;
        System.out.println(cycle.hasCycle(cycle.head));
    }
}
