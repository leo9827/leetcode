package neetcode150.greedy;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/description/">53. Maximum Subarray</a>
 * Medium
 * <p>
 * Given an integer array nums, find the subarray with the largest sum, and return its sum. <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] <p>
 * Output: 6  <p>
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6. <p>
 * <p>
 * Example 2: <p>
 * Input: nums = [1] <p>
 * Output: 1 <p>
 * Explanation: The subarray [1] has the largest sum 1. <p>
 * <p>
 * Example 3: <p>
 * Input: nums = [5,4,-1,7,8] <p>
 * Output: 23 <p>
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. <p>
 * <p>
 * <p>
 * Constraints: <p>
 * 1 <= nums.length <= 105 <p>
 * -104 <= nums[i] <= 104
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] tb = new int[nums.length];
        tb[0] = nums[0];

        // 假设输入为 [-2,1,3,-4,2]，因为是连续的数组,
        // 我们假设从index=0出发，到达第 1 个位置 nums[0]=-2时，能得到最大的和是多少？只能是-2 -> [-2]
        //                        到达第 2 个位置 nums[1]= 1时，能得到最大的和是多少？要么是 1 自己，或是 1 加上之前最大的和-2 > -2+1 = -1，这里取最大的 1 -> [-2,1]
        //                        到达第 3 个位置 nums[2]= 3时，能得到最大的和是多少？要么是 3 自己，或是 3 加上之前最大的和 1 > 3+1 = 4，这里取最大的 4  -> [-2,1,4]
        //                        到达第 4 个位置 nums[3]=-4时，能得到最大的和是多少？要么是-4 自己，或是-4 加上之前最大的和 4 > -4+4 = 0，这里取最大的 0 -> [-2,1,4,0]
        //                        到达第 5 个位置 nums[4]= 2时，能得到最大的和是多少？要么是 2 自己，或是 2 加上之前最大的和 0 > 2+0 = 2，这里取最大的 2  -> [-2,1,4,0,2]
        //                        得到结果 -> [-2,1,4,0,2],遍历得到最大的值则是最大和
        for (int i = 1; i < nums.length; i++) {
            tb[i] = Math.max(tb[i - 1] + nums[i], nums[i]);
        }
        int max = tb[0];
        for (int n : tb) {
            max = Math.max(max, n);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int ret1 = m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(ret1 == 6);
    }
}
