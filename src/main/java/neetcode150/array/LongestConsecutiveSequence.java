package neetcode150.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">128. 最长连续序列</a>
 * 中等
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：  <p>
 * 输入：nums = [100,4,200,1,3,2] <p>
 * 输出：4 <p>
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 <p>
 * <p>
 * 示例 2： <p>
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1] <p>
 * 输出：9 <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105 <p>
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] case1 = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(case1) == 4);
    }

    static class Solution {

        public int longestConsecutive(int[] nums) {
            if (nums.length <= 1) return nums.length;
            Set<Integer> tb = new HashSet<>();
            for (int n : nums) tb.add(n);

            int max = 0;
            for (int n : nums) {
                // 因为是连续的，所以不论从哪个位置开始，都可以向左移动和向右移动来到达连续范围的起点和终点
                int toMin = n - 1;
                int toMax = n + 1;
                while (tb.remove(toMin)) toMin--;
                while (tb.remove(toMax)) toMax++;
                max = Math.max(max, toMax - toMin - 1);
                if (tb.isEmpty()) return max;
            }

            return max;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Set<Integer> table = new HashSet<>(nums.length);
        for (int num : nums) table.add(num);
        int ans = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (table.remove(left)) left--;
            while (table.remove(right)) right++;
            ans = Math.max(ans, right - left - 1);
            if (table.isEmpty()) return ans; // save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }

    public int longestConsecutive3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 0;
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 1) {
                count++;
            } else if (diff == 0) {
                continue;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
            }
        }
        return max + 1;

    }

    public int longestConsecutive2(int[] nums) {

        if (nums.length == 1) return 1;
        else if (nums.length == 0) return 0;

        HashSet<Integer> se = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            se.add(nums[i]);
        }

        int maximum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!se.contains(nums[i] + 1)) {
                int length = 1;
                int start = nums[i];
                while (se.contains(start - 1)) {
                    length++;
                    start--;
                }
                maximum = Math.max(maximum, length);
            }
        }
        return maximum;
        //1 8 3 10 7 2 9 4
        //
    }
}
