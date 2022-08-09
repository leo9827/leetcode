package grind75;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray su = new MaximumProductSubarray();
        System.out.println(su.maxProduct(new int[]{2,3,-2,4}));  //6
        System.out.println(su.maxProduct(new int[]{-2,0,-1}));      //0
        System.out.println(su.maxProduct(new int[]{-3,-1,-1}));     //3
    }
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        /*
        nums length >= 1
        case1: [2, 3, -2, 4]
                root
        [2,3]   [3,-2,4]
               [3,-2], [-2,4]

        case2: [-3,-1,-1]
        case3: [-3]
        case3: [-3,-1]
         */


        return 1;
    }
}
