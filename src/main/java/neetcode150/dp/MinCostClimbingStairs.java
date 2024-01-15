package neetcode150.dp;

import java.util.Arrays;

/**
 * 746. Min Cost Climbing Stairs
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/description/">...</a>
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * 示例 1：
 * 输入：cost = [10,15,20] <p>
 * 输出：15 <p>
 * 解释：你将从下标为 1 的台阶开始。  <p>
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。 <p>
 * 总花费为 15 。 <p>
 * <p>
 * 示例 2：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6 <p>
 * 解释：你将从下标为 0 的台阶开始。 <p>
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。 <p>
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。 <p>
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。 <p>
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。 <p>
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。 <p>
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。 <p>
 * 总花费为 6 。 <p>
 * 提示：
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] tb = new int[len + 1];
        tb[0] = 0;
        tb[1] = 0;
        for (int i = 2; i <= len; i++) {
            tb[i] = Math.min(tb[i - 1] + cost[i - 1], tb[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(tb));
        return tb[len];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        int[] case1 = new int[]{10, 15, 20};
        System.out.println(m.minCostClimbingStairs(case1) == 15);
        int[] case2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(m.minCostClimbingStairs(case2) == 6);
    }

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            // bottom up
            int[] dp = new int[cost.length];
            if (cost.length == 1) {
                return cost[0];
            }
            // base case
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < cost.length; i++) {
                // dp[i] is min of dp[i-1] and dp[i-2] + cost[i]
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            // reaching top of stair, in this question, means last from the top or top
            return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
        }
    }
}
