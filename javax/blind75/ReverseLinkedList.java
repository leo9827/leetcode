package blind75;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newh = reverseList(head.next);

        head.next.next = head;
        head.next      = null;

        return newh;
    }

}
