package grind75;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        // 有环的链表的特点：next next节点全都不为null  [3,2,0,1,5,4]  4->2 : 如何判断有环?
        // 1.针对上面的特点：可以用hashSet解决，将所有的节点都放入到set中，出现重复的node，那么就为true
        /*
        2.双指针法: 当出现有环时，一个指针按个遍历，一个指针双倍遍历，如果有环,那么快的那个会追上慢的那个
        [3,2,0,1,5,4] 4->2: 3, 3
        2   0   1   5   4   2
        0   5   3   0   5   2
        [3,2,0,5,4] 4->2: 3, 3
        2   0   5   4
        0   4   0   4
         */
        if (head == null) {
            return false;
        }
        ListNode oneSpeed = head;
        ListNode twoSpeed = head;
        while (twoSpeed.next != null && twoSpeed.next.next != null) {
            oneSpeed = oneSpeed.next; // 一倍速遍历
            twoSpeed = twoSpeed.next.next; // 二倍速遍历
            if (twoSpeed == oneSpeed) { // 当二倍速追上了一倍速（不一定是在环的那位置)，证明有环
                return true;
            }
        }
        return false;
    }
}
