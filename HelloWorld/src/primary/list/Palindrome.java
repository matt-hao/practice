package primary.list;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Palindrome extends BaseObj {

    public Palindrome(ListNode head) {
        super(head);
    }

    private boolean flag = true;

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        this.head = head;
        tempMethod(head);
        return this.flag;
    }

    private ListNode tempMethod(ListNode temp) {

        if (temp.next == null) {
            return temp;
        }

        ListNode backNode = tempMethod(temp.next);

        if (backNode.val == this.head.val) {
            this.head = this.head.next;
        } else {
            this.flag = false;
        }
        return temp;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome(new ListNode(1));
        palindrome.generateList(new int[]{0, 0});
        palindrome.showList();

        System.out.println(palindrome.isPalindrome(palindrome.head));
    }

}
