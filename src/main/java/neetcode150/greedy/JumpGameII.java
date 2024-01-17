package neetcode150.greedy;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/description/">45. Jump Game II</a> <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i] <p>
 * i + j < n <p>
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1: <p>
 * 输入: nums = [2,3,1,1,4] <p>
 * 输出: 2  <p>
 * 解释: 跳到最后一个位置的最小跳跃数是 2。 <p>
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。 <p>
 * <p>
 * 示例 2: <p>
 * 输入: nums = [2,3,0,1,4] <p>
 * 输出: 2 <p>
 * <p>
 * 提示: <p>
 * 1 <= nums.length <= 104 <p>
 * 0 <= nums[i] <= 1000 <p>
 * 题目保证可以到达 nums[n-1]
 */
public class JumpGameII {
    public int jump(int[] nums) {
        // 1.如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
        //   1.1. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
        // 2.如果从这个 起跳点 起跳叫做第 1 次 跳跃，那么从后面 3 个格子起跳 都 可以叫做第 2 次 跳跃。
        // 3.所以，当一次 跳跃 结束时，从下一个格子开始，到现在 能跳到最远的距离，都 是下一次 跳跃 的 起跳点。
        // 3.1. 对每一次 跳跃 用 for 循环来模拟。
        //    跳完一次之后，更新下一次 起跳点 的范围。
        //    在新的范围内跳，更新 能跳到最远的距离。
        // 4.记录 跳跃 次数，如果跳到了终点，就得到了结果。
        int MaxPosition = 0, end = 0, steps = 0;
        for (int cur = 0; cur < nums.length - 1; cur++) {
            int gap = nums[cur];
            MaxPosition = Math.max(MaxPosition, cur + gap);
            if (cur == end) {      // 当前位置是否已经达到上一次走到的最远位置 end
                end = MaxPosition; // 更新当前位置可以达到的最远位置 end
                steps++;           // 更新步数
            }
        }
        return steps;
    }

    class Solution {
        public int jump(int[] nums) {
            // 记录当前能跳跃到的位置的边界下标
            int border = 0;
            // 记录在边界范围内，能跳跃的最远位置的下标
            int maxPosition = 0;
            // 记录所用步数
            int steps = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                // 继续往下遍历，统计边界范围内，哪一格能跳得更远，每走一步就更新一次能跳跃的最远位置下标
                // 其实就是在统计下一步的最优情况
                maxPosition = Math.max(maxPosition, nums[i] + i);

                if (i == border) { // 如果到达了边界，那么一定要跳了，下一跳的边界下标就是之前统计的最优情况maxPosition，并且步数加1
                    border = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
    }
}
