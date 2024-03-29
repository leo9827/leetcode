package neetcode150.stack;


import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">23. Merge k Sorted Lists</a>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> stack = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) stack.add(node);
        }

        while (!stack.isEmpty()) {
            tail.next = stack.poll();
            tail = tail.next;

            if (tail.next != null) {
                stack.add(tail.next);
            }
        }
        return dummy.next;
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;

            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) return lists[start];

            if (start + 1 == end) return merge(lists[start], lists[end]);

            int mid = start + (end - start) / 2;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return merge(left, right);
        }

        private ListNode merge(ListNode l, ListNode r) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (l != null && r != null) {
                if (l.val < r.val) {
                    tail.next = l;
                    l = l.next;
                } else {
                    tail.next = r;
                    r = r.next;
                }
                tail = tail.next;
            }

            if (l == null) {
                tail.next = r;
            } else {
                tail.next = l;
            }

            return dummy.next;
        }
    }
}
