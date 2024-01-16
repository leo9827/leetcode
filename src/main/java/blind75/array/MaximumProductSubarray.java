package blind75.array;

import java.util.Arrays;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray su = new MaximumProductSubarray();
        System.out.println(su.maxProduct(new int[]{2,3,-2,4}));  //6
        System.out.println(su.maxProduct(new int[]{-2,0,-1,-2}));   //0
        System.out.println(su.maxProduct(new int[]{-3,-1,-1}));  //3
    }
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int res = nums[0];
        int max = 1;
        int min = 1;

        for (int n : nums) {
            int tmp = max * n;
            max = Math.max(n, Math.max(tmp, min * n));
            min = Math.min(n, Math.min(tmp, min * n));
            res = Math.max(res, max);
        }
        return res;
    }
}
