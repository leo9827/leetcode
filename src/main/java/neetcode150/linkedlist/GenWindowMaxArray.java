package neetcode150.linkedlist;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/description/">239. Sliding Window Maximum</a>
 * 生成窗口最大值数组
 * <p>
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。 <p>
 * 例如，数组为[4，3，5，4，3，3，6，7]，窗口大小为3时： <p>
 * ￼
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。请实现一个函数。 <p>
 * ● 输入：整型数组arr，窗口大小为w。 <p>
 * ● 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。以本题为例，结果应该返回{5，5，5，4，6，7}。
 */
public class GenWindowMaxArray {

    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) return null;
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GenWindowMaxArray g = new GenWindowMaxArray();
        System.out.println(Arrays.toString(g.getMaxWindow(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3))); // [5,5,5,4,6,7]
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && deque.getLast() < nums[i]) deque.removeLast();
                deque.addLast(nums[i]);
            }

            res[0] = deque.getFirst();

            for (int i = k; i < n; i++) {
                if (nums[i - k] == deque.getFirst()) deque.removeFirst();
                while (!deque.isEmpty() && deque.getLast() < nums[i]) deque.removeLast();
                deque.addLast(nums[i]);
                res[i - k + 1] = deque.getFirst();

            }
            return res;
        }
    }
}
