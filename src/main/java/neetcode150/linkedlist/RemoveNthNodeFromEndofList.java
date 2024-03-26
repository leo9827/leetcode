package neetcode150.linkedlist;

import java.util.Stack;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 例1
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 */
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
