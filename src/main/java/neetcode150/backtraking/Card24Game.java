package neetcode150.backtraking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/24-game/description/"> 679. 24 点游戏.</a><p>
 * 困难<p>
 * 给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。
 * 您应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
 * <p>
 * 你须遵守以下规则:
 * <p>
 * 除法运算符 '/' 表示实数除法，而不是整数除法。
 * 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
 * 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
 * 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
 * 你不能把数字串在一起
 * 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
 * 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 示例 1:
 * 输入: cards = [4, 1, 8, 7]
 * 输出: true
 * 解释: (8-4) * (7-1) = 24
 * <p>
 * 示例 2:
 * 输入: cards = [1, 2, 1, 2]
 * 输出: false
 */
class Card24Game {

    public boolean judgePoint24(int[] cards) {
        return bphelper(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }

    private static final double TARGET = 24;
    private static final double EPSILON = 1e-6;

    private boolean bphelper(double[] nums) {
        if (nums.length == 1) return Math.abs(nums[0] - TARGET) < EPSILON;

        // 每次选择 2 个不同的数进行回溯
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 将选择出来的两个数字的计算结果和原数组剩下的部分加入到 next 数组中
                double[] next = new double[nums.length - 1];
                for (int k = 0, pos = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        next[pos++] = nums[k];
                    }
                }
                for (double num : calculate(nums[i], nums[j])) {
                    next[next.length - 1] = num;
                    if (bphelper(next)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> calculate(double a, double b) {
        List<Double> l = new ArrayList<>();
        l.add(a + b);
        l.add(a - b);
        l.add(b - a);
        l.add(a * b);
        if (!(Math.abs(b) < EPSILON)) l.add(a / b);
        if (!(Math.abs(a) < EPSILON)) l.add(b / a);
        return l;
    }

}