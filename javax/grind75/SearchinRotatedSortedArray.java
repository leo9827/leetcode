package grind75;

public class SearchinRotatedSortedArray {
        public int search(int[] nums, int target) {
           int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
    
                if (target == nums[mid]) {
                    return mid;
                }
                // left
                if (nums[lo] <= nums[mid]) {
                    if (target > nums[mid]) {
                        lo = mid + 1;
                    }
                    else if (target < nums[lo]) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid - 1;
                    }
                }
                // right
                else {
                    if (target < nums[mid]) {
                        hi = mid - 1;
                    }
                    else if (target > nums[hi]) {
                        hi = mid - 1;
                    }
                    else {
                        lo = mid + 1;
                    }
                }
            }
            return -1;
        }
    
    
}
