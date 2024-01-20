package neetcode150.twopointer;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">167. 两数之和 II - 输入有序数组</a>
 * 167. 两数之和 II - 输入有序数组 <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ， <p>
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。 <p>
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ， <p>
 * 则 1 <= index1 < index2 <= numbers.length 。 <p>
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * <p>
 * 示例 1： <p>
 * 输入：numbers = [2,7,11,15], target = 9 <p>
 * 输出：[1,2] <p>
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 <p>
 * <p>
 * 示例 2： <p>
 * 输入：numbers = [2,3,4], target = 6 <p>
 * 输出：[1,3] <p>
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 <p>
 * <p>
 * 示例 3： <p>
 * 输入：numbers = [-1,0], target = -1 <p>
 * 输出：[1,2] <p>
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104 <p>
 * -1000 <= numbers[i] <= 1000 <p>
 * numbers 按 非递减顺序 排列 <p>
 * -1000 <= target <= 1000 <p>
 * 仅存在一个有效答案
 */
public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target)
                left++;
            else if (sum > target)
                right--;
            else
                return new int[]{left + 1, right + 1};
        }

        return null;
    }

}
