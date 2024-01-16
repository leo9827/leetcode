package neetcode150;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp)) {
                return new int[]{i, map.get(cmp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
