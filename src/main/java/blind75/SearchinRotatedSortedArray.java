package blind75;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{1}, 1));
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{1,3}, 1));
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new SearchinRotatedSortedArray().search(
                new int[]{12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 3));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) { // [1]
            int mid = lo + (hi-lo)/2;
            if (target == nums[mid]) return mid;

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
            else {
                if (target > nums[hi]) {
                    hi = mid - 1;
                }
                else if (target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int num;
            // If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target)      lo = mid + 1;
            else if (num > target) hi = mid - 1;
            else                   return mid;
        }
        return -1;
    }


    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
