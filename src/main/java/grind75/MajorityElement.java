package grind75;

public class MajorityElement {
    
    // ex: [3, 2, 3] -> 3
    public int majorityElement(int[] nums) {
        int vote =0, majority = 0;
        for (int num : nums) {
            if (vote == 0) {
                majority = num;
            }
            if (majority == num) {
               vote++;
            } else {
                vote--;
            }
        }
        return majority;   
    }
}
