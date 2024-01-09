package blind75;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        for(int num : nums) {
            if (table.containsKey(num)) {
                table.put(num, table.get(num) + 1);
            } else {
                table.put(num, 1);
            }
        }
        int maxNum = 0;
        int majority = 0;
        for(Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue() >= maxNum) {
                maxNum = entry.getValue();
                majority = entry.getKey();
            }
        }
        return majority;
    }
    public int majorityElement2(int[] nums) {
        int vote = 0, majority = 0;
        for (int num : nums) {
            if (vote == 0) {
                majority = num;
            }
            // vote
            if (majority == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return majority;
    }

}
