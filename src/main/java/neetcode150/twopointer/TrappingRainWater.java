package neetcode150.twopointer;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">42. Trapping Rain Water</a>
 * 42. 接雨水
 * Hard
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：  <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]<p>
 * 输出：6 <p>
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。<p>
 * <p>
 * 示例 2：  <p>
 * 输入：height = [4,2,0,3,2,5]  <p>
 * 输出：9 <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length  <p>
 * 1 <= n <= 2 * 104 <p>
 * 0 <= height[i] <= 105 <p>
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        if (height.length < 2) return 0;

        int result = 0;

        int leftElementIdx = 1;
        int rightElementIdx = height.length - 2;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        while (leftElementIdx <= rightElementIdx) {
            while (leftMax < rightMax) {
                if (leftElementIdx > rightElementIdx) {
                    break;
                }

                int unitHeightDiff = Math.min(leftMax, rightMax) - height[leftElementIdx];

                if (unitHeightDiff > 0) {
                    result += unitHeightDiff;
                }

                if (height[leftElementIdx] > leftMax) {
                    leftMax = height[leftElementIdx];
                }
                leftElementIdx += 1;
            }

            while (rightMax <= leftMax) {
                if (leftElementIdx > rightElementIdx) {
                    break;
                }
                int unitHeightDiff = Math.min(leftMax, rightMax) - height[rightElementIdx];

                if (unitHeightDiff > 0) {
                    result += unitHeightDiff;
                }
                if (height[rightElementIdx] > rightMax) {
                    rightMax = height[rightElementIdx];
                }
                rightElementIdx -= 1;
            }
        }
        return result;
    }
}
