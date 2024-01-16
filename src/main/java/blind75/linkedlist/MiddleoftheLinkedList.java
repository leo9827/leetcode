package blind75.linkedlist;


public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one;
    }
}
