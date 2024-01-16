package blind75.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));  // 12
        System.out.println(new HouseRobber().robTabulation(new int[]{1, 2, 3, 1})); // 4
//        System.out.println(new HouseRobber().robTabulation(new int[]{2,7,9,3,1}));  // 12
    }
    public int rob(int[] nums) {
        return rob(nums, 0, new HashMap<>(nums.length));
    }
    public int rob(int[] nums, int idx, Map<Integer, Integer> table) {
        if (table.containsKey(idx)) return table.get(idx);
        if (idx >= nums.length) return 0;
        /*
        case: [1, 2, 3, 1]
                      0
                1/  2/ \3 \1
                1   2
              3/\1 1|
              4  2  3
         */

        int max = 0;
        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];
            int maxumiu = rob(nums, i+2, table);
            int curMax = maxumiu + num;
            if (curMax > max) {
                max = curMax;
            }
        }

        table.put(idx, max);
        return max;
    }

    public int robTabulation(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = memo[0] + nums[0];
        System.out.println(Arrays.toString(memo));
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
            System.out.println(Arrays.toString(memo));
        }
        return memo[nums.length];
        /*
        case: [1, 2, 3, 1]
        table:
        [0, 0, 0, 0, 0]
        [0, 1, 0, 0, 0]
        [0, 1, 2/1, 0, 0]
        [0, 1, 2, 4/2, 0]
        [0, 1, 2, 4/2, 4/3]

         */

    }

}