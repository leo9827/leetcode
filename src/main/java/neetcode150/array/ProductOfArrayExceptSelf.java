package neetcode150.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">238. 除自身以外数组的乘积</a>
 * 中等
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:  <p>
 * 输入: nums = [1,2,3,4]  <p>
 * 输出: [24,12,8,6]  <p>
 * <p>
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]  <p>
 * 输出: [0,0,9,0,0]  <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105  <p>
 * -30 <= nums[i] <= 30  <p>
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4})));
        // explain: [1,2,3,4] left: [1,1,2,6] right:[24,12,4,1] -> [24,12,8,6]
    }

    public int[] productExceptSelf(int[] nums) {
        // Left is an array containing the left products
        // i.e: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        int[] left = new int[nums.length];

        // Right is an array containing the array products
        // i.e: right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] product = new int[nums.length];
        for (int i = 0; i < product.length; i++) {
            product[i] = left[i] * right[i];
        }

        return product;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int p = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = p;
            p *= nums[i];
        }

        p = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            res[i] *= p;
            p *= nums[i];
        }
        res[0] = p;

        return res;
    }
}
