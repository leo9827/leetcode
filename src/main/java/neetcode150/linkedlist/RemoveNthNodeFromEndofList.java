package neetcode150.linkedlist;

import java.util.Stack;

public class RemoveNthNodeFromEndofList {

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode h = new ListNode(0); // [1],[0] 处理
            h.next = head;
            ListNode fast = h;
            ListNode slow = h;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return h.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start, fast = start;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null && n == 1) return null;

        // 使用栈
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        if (n > stack.size()) return head;
        ListNode left, right = null;
        while (n > 1) {
            right = stack.pop();
            n--;
        }
        stack.pop();
        if (stack.isEmpty()) {
            return right;
        }

        left = stack.pop();
        left.next = right;

        return head;
    }
}
