package grind75;

public class ReorderList {
    public void reorderList(ListNode head) {
        // step1 slow & fast pointer to find mid
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // step2 reserve half link list
        /*
         3->4->5->6->null
         ↑  ↑  ↑
         p  o  c
         */
        ListNode p = slow;
        ListNode o_p = p.next;
        while (o_p.next != null) {
            ListNode cur = o_p.next;
            o_p.next = cur.next;
            cur.next = p.next;
            p.next = cur;
        }

        // step3 merge link list
        ListNode p1 = head;
        ListNode p2 = p.next;
        while(p1!=p){
            p.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=p.next;
        }
    }
}
