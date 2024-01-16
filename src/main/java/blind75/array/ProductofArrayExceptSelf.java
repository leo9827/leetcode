package blind75.array;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        // 分3种情况
        // 1.没有为 0 的元素，此时先计算总乘积，然后每一位元素的结果=总乘积/当前元素
        // 2.有1个为0 的元素, 此时为0元素的结果为其他元素的乘积，其他元素均为0
        // 3.有2个及以上的为0的元素, 此时所有的结果都是0
        int product = 1;
        int zerocount = 0;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product = product * nums[i];
            } else {
                if (zerocount == 0) {
                    zeroIndex = i;
                    zerocount++;
                } else {
                    zerocount++;
                    break;
                }
            }
        }
        int[] result = new int[nums.length];
        if (zerocount > 1) {
            return result;
        }
        if (zerocount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (i == zeroIndex) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            }
        }
        if (zerocount == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        // 1    2   3   4
        // 1    1   2   6
        //24    12  8   6
        int[] ret = new int[nums.length];
        int prod = 1;
        ret[0] = prod;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = prod * nums[i - 1];
            prod = ret[i];
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = prod * ret[i];
            prod = prod * nums[i];

        }
        return ret;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf o = new ProductofArrayExceptSelf();
        o.productExceptSelf2(new int[]{1,2,3,4});
    }

}
