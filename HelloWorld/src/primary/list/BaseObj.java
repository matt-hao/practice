package primary.list;

import java.util.Objects;

public abstract class BaseObj {

    protected ListNode head;

    public BaseObj() {
    }

    public BaseObj(ListNode head) {
        this.head = head;
    }

    public void generateList(int[] arr) {
        ListNode tempHead = this.head;
        for (int i = 0; i < arr.length; i++) {
            tempHead.next = new ListNode(arr[i]);
            tempHead = tempHead.next;
        }
    }

    public ListNode findNode(int n) {
        ListNode temp = head;
        int count = 0;
        while (temp.next != null && count < n) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public void showList() {
        ListNode temp = this.head;
        System.out.print("{");
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(",");
            }
            temp = temp.next;
        }
        System.out.print("}\n");
    }

    public void showList(ListNode listNode) {
        ListNode temp = listNode;
        System.out.print("{");
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(",");
            }
            temp = temp.next;
        }
        System.out.print("}\n");
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

}
