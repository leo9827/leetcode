package neetcode150.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/description/">...</a>
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b)->b-a);
        for (int n : nums) pq.add(n);
        for (int i = 0; i < k - 1; i++) pq.poll();
        return pq.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    class Solution {
        private Random rand;

        public int findKthLargest(int[] nums, int k) {
            rand = new Random();
            List<Integer> list = new ArrayList<>();;
            for (int num : nums) {
                list.add(num);
            }
            return quickSelect(list, k);
        }

        private int quickSelect(List<Integer> list, int k) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> equals = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            int val = partition(list, smaller, equals, larger);
            if (larger.size() >= k) {
                return quickSelect(larger, k);
            } else if (larger.size() + equals.size() >= k) {
                return val;
            } else {
                return quickSelect(smaller, k - larger.size() - equals.size());
            }
        }

        private int partition(List<Integer> list, List<Integer> smaller, List<Integer> equals, List<Integer> larger) {
            int idx = rand.nextInt(list.size());
            int val = list.get(idx);
            for (int num : list) {
                if (num < val) {
                    smaller.add(num);
                } else if (num == val) {
                    equals.add(num);
                } else {
                    larger.add(num);
                }
            }
            return val;
        }
    }
}
