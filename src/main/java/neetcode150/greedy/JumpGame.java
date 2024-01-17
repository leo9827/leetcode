package neetcode150.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/jump-game/description/">55. Jump Game</a>
 * Medium
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * Example 1:  <p>
 * Input: nums = [2,3,1,1,4]  <p>
 * Output: true  <p>
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index. <p>
 * <p>
 * Example 2:  <p>
 * Input: nums = [3,2,1,0,4] <p>
 * Output: false <p>
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints: <p>
 * 1 <= nums.length <= 104 <p>
 * 0 <= nums[i] <= 105 <p>
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1： <p>
 * 输入：nums = [2,3,1,1,4] <p>
 * 输出：true <p>
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2： <p>
 * 输入：nums = [3,2,1,0,4] <p>
 * 输出：false <p>
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示： <p>
 * 1 <= nums.length <= 104 <p>
 * 0 <= nums[i] <= 105
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        // 假设输入为：nums = [2,3,1,1,4]
        int[] tb = new int[nums.length]; // [2, 3, 2, 1, 0], 判断每一步是否能到达
        nums[nums.length - 1] = 0;
        tb[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            tb[i + 1] = Math.max(tb[i] - 1, nums[i + 1]);
            System.out.println(i + 1 + " " + Arrays.toString(tb));
            if (tb[i] == 0) return false;
        }
        System.out.println(Arrays.toString(tb));
        return tb[nums.length - 2] > 0;
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(j.canJump(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(j.canJump(new int[]{1, 0, 1, 0})); // false
    }

    class Solution {
        // 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
        // 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
        // 如果可以一直跳到最后，就成功了
        public boolean canJump(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > k) return false;
                k = Math.max(k, i + nums[i]);
            }
            return true;

        }
    }
}
