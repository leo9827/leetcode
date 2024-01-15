package neetcode150.dp;

/**<a href="https://leetcode.com/problems/partition-equal-subset-sum/description/">
 * 416. Partition Equal Subset Sum </a>  <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。 <p>
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 <p>
 * <p>
 * 示例 1： <p>
 * 输入：nums = [1,5,11,5] <p>
 * 输出：true <p>
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。 <p>
 * <p>
 * 示例 2： <p>
 * 输入：nums = [1,2,3,5] <p>
 * 输出：false <p>
 * 解释：数组不能分割成两个元素和相等的子集。 <p>
 * <p>
 * 提示： <p>
 * 1 <= nums.length <= 200 <p>
 * 1 <= nums[i] <= 100 <p>
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int[] case1 = new int[]{1,5,11,5};
        System.out.println(p.canPartition(case1));
        int[] case2 = new int[]{1,2,3,5};
        System.out.println(!p.canPartition(case2));
    }
}
