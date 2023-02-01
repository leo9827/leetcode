package grind75;

public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0, left = 0, right = nums.length-1;
        while (i <= right) { // only has 0, 1, 2 so enum element value and swap them
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums,i, right);
                right--;
            } else {
                i++;
            }
        }
    }    

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

