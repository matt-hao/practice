package interview.amazon.oa;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * Example 1:
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 * <p>
 * <p>
 * Note:
 * <p>
 * You must return the copy of the given head as a reference to the cloned list.
 */
public class CopyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        return method2(head);
    }

    //node1 -> nNode1
    //node2 _> nNode2
    //O(n)/O(n)
    private Node method1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node temp = map.get(cur);
            temp.random = map.get(cur.random);
            temp.next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }

    //n1->n11->n2->n22->n3->n33
    //n11.r -> n33
    // n1-n2-n3
    // n11-n22-n33
    //O(n)/O(1)
    private Node method2(Node head) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val, null, null);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.random == null) {
                next.random = null;
                cur = cur.next.next;
                continue;
            }
            next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node dummy = new Node(-1, null, null);
        Node temp = dummy;
        while (cur != null) {
            temp.next = cur.next;
            temp = temp.next;

            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
