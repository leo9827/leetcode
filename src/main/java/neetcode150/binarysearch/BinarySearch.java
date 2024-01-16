package neetcode150.binarysearch;

/**
 * <a href="https://leetcode.com/problems/binary-search"> 704. 二分查找 </a>
 * 简单
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int index = s.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(index + " : " + (index == 4));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int hi = nums.length - 1;
            int lo = 0;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return -1;
        }
    }
}
