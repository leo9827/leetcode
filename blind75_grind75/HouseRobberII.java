package grind75;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(new HouseRobberII().rob(new int[]{2, 3, 2})); // 3
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3})); // 3
        System.out.println(new HouseRobberII().rob(new int[]{200,3,140,20,10})); // 340
        System.out.println();
        System.out.println(new HouseRobberII().robUseTable(new int[]{1, 2, 3, 1})); // 4
        System.out.println(new HouseRobberII().robUseTable(new int[]{2, 3, 2})); // 3
        System.out.println(new HouseRobberII().robUseTable(new int[]{1, 2, 3})); // 3
        System.out.println(new HouseRobberII().robUseTable(new int[]{200,3,140,20,10})); // 340
    }
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        /*
        case: [200,3,140,20,10]
        -> max of [200,3,140,20] , [3,140,20,10]
        */
        return Math.max(
                rob(nums,  new HashMap<>(nums.length), 0, nums.length - 1),
                rob(nums,  new HashMap<>(nums.length), 1, nums.length)
        );
    }

    public int rob(int[] nums, Map<String, Integer> memo, int idx, int end) {
        /*
        case: [200,3,140,20,10]
          -> max of [200,3,140,20] , [3,140,20,10]
         */
        String key = idx +","+ end;
        if (memo.containsKey(key)) return memo.get(key);
        if (idx >= nums.length) return 0;

        int max = 0;
        for (int i = idx; i < end; i++) {
            int num = nums[i];
            int maxumiu = rob(nums, memo, i+2, end);
            int curMax = maxumiu + num;
            if (curMax > max) {
                max = curMax;
            }
        }

        memo.put(key, max);
        return max;
    }

    public int robUseTable(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        /*
        case: [200,3,140,20,10]
        -> max of [200,3,140,20] , [3,140,20,10]
        */
        return Math.max(
                robTabulation(nums,   0),
                robTabulation(nums,   1)
        );
    }
    public int robTabulation(int[] nums, int idx) {
        int[] table = new int[nums.length]; // nums.length 而不是 nums.length+1是重点
        table[1] = nums[idx];
        for (int i = 1; i < nums.length - 1; i++) { // nums.length - 1而不是nums.length是重点
            table[i+1] = Math.max(table[i], table[i-1] + nums[idx+i]);
        }
        return table[nums.length-1];
    }
}
