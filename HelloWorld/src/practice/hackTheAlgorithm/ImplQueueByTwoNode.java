package practice.hackTheAlgorithm;

public class ImplQueueByTwoNode {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;

    public ImplQueueByTwoNode() {
        this.head = new Node(-1);
        this.tail = head;
    }

    public void offer(int i) {
        tail.next = new Node(i);
        tail = tail.next;
    }

    public int poll() {
        if (!isEmpty()) {
            Node temp = head.next;
            head.next = temp.next;
            if (head.next == null) {
                tail = head;
            }
            return temp.val;
        }
        return -1;
    }

    public int peek() {
        if(!isEmpty()){
            return head.next.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == tail && head.next == null;
    }
}
