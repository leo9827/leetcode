package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/description/">234. Palindrome Linked List</a>
 * 234. Palindrome Linked Lis
 * Easy
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    static class Solution1 {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            // mid point
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // reverse from slow to end
            ListNode p = null;
            ListNode q = null;
            ListNode r = slow;
            while (r != null) {
                p = q;
                q = r;
                r = r.next;
                q.next = p;
            }
            ListNode temp = q;
            while (temp != null && head != null) {
                if (temp.val != head.val) return false;
                temp = temp.next;
                head = head.next;
            }
            return true;
        }
    }
}
