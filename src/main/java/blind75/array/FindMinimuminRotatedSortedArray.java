package blind75.array;

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
//        System.out.println(new FindMinimuminRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new FindMinimuminRotatedSortedArray().findMin(new int[]{3, 1, 2}));
    }
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) { // [1]
            if (nums[lo] < nums[hi]) return nums[lo];

            int mid = lo + (hi-lo)/2;
            // 这里隐含一层判断，就是上面的 nums[lo] < nums[hi]
            if      (nums[mid] >  nums[hi])   lo = mid+1;
            else if (nums[mid] == nums[hi])  hi = hi-1;  // 处理有相同的元素
            else                             hi = mid;
        }
        return nums[lo];
    }
}
