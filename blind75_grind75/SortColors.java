package grind75;

public class SortColors {

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                nums[i]=1;
                nums[start]=0;
                start++;
                i++;
            } else if (nums[i] == 2) {
                nums[i]=nums[end];
                nums[end]=2;
                end--;
            } else {
                i++;
            }
        }
    }
}