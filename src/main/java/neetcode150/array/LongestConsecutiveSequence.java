package neetcode150.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
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
            if (table.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
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
