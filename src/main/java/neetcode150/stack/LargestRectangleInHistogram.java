package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/description/">84. Largest Rectangle in Histogram</a>
 * Hard. <p>
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1: <p>
 * 输入：heights = [2,1,5,6,2,3] <p>
 * 输出：10 <p>
 * 解释：最大的矩形为图中红色区域，面积为 10 <p>
 * <p>
 * 示例 2： <p>
 * 输入： heights = [2,4] <p>
 * 输出： 4 <p>
 * <p>
 * 提示： <p>
 * 1 <= heights.length <=105 <p>
 * 0 <= heights[i] <= 104
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int length = heights.length;
        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1) && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }
}
