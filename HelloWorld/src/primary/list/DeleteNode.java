package primary.list;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * <p>
 * 4 -> 5 -> 1 -> 9
 * Example 1:
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list
 * should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list
 * should become 4 -> 5 -> 9 after calling your function.
 * Note:
 * <p>
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class DeleteNode extends BaseObj {

    public DeleteNode(ListNode head) {
        super(head);
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public void deleteNode(ListNode node) {
        if (head.equals(node)) {
            head = head.next;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.equals(node)) {
                temp.next = temp.next.next;
                return;
            } else {
                temp = temp.next;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {5, 1, 9};
        DeleteNode deleteNode1 = new DeleteNode(new ListNode(4));
        deleteNode1.generateList(arr1);


        deleteNode1.deleteNode(new ListNode(5));

        deleteNode1.showList();


        int[] arr2 = {5, 1, 9};
        DeleteNode deleteNode2 = new DeleteNode(new ListNode(4));
        deleteNode2.generateList(arr2);

        deleteNode2.deleteNode(new ListNode(1));

        deleteNode2.showList();
    }
}