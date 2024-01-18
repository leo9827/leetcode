package neetcode150.binarysearch;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/random-pick-with-weight/description/">
 * 528. Random Pick with Weight</a>
 * Medium
 * <p>
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * <p>
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * <p>
 * <p>
 * 示例 1： <p/>
 * 输入： <p/>
 * ["Solution","pickIndex"] <p/>
 * [[[1]],[]] <p/>
 * 输出： <p/>
 * [null,0] <p/>
 * 解释： <p/>
 * Solution solution = new Solution([1]); <p/>
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 <p/>
 * 示例 2： <p/>
 * 输入： <p/>
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"] <p/>
 * [[[1,3]],[],[],[],[],[]] <p/>
 * 输出： <p/>
 * [null,1,1,1,1,0] <p/>
 * 解释： <p/>
 * Solution solution = new Solution([1, 3]); <p/>
 * solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。 <p/>
 * solution.pickIndex(); // 返回 1 <p/>
 * solution.pickIndex(); // 返回 1 <p/>
 * solution.pickIndex(); // 返回 1 <p/>
 * solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。 <p/>
 * <p>
 * 由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
 * [null,1,1,1,1,0] <p>
 * [null,1,1,1,1,1] <p>
 * [null,1,1,1,0,0] <p>
 * [null,1,1,1,0,1] <p>
 * [null,1,0,1,0,0] <p>
 * ......
 * 诸若此类。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= w.length <= 104
 * 1 <= w[i] <= 105
 * pickIndex 将被调用不超过 104 次
 */
public class RandomPickwithWeight {

    static class Solution {

        Random random;
        int[] wSums;

        public Solution(int[] w) {
            this.random = new Random();
            for (int i = 1; i < w.length; ++i)
                w[i] += w[i - 1];
            this.wSums = w;
        }

        public int pickIndex() {
            int len = wSums.length;
            int idx = random.nextInt(wSums[len - 1]) + 1;
            int left = 0, right = len - 1;
            // search position
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (wSums[mid] == idx) return mid;
                else if (wSums[mid] < idx) left = mid + 1;
                else right = mid;
            }
            return left;
        }
    }
}
