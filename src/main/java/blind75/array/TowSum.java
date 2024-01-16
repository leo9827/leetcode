package blind75.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (index.containsKey(target - nums[i])) {
                return new int[]{index.get(target - nums[i]), i};
            }
            index.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (ls.get(target - nums[i]).get(0) != null) {
                return new int[]{ls.get(target - nums[i]).get(0), i};
            }
            ls.set(nums[i], Collections.singletonList(i));
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TowSum towSum = new TowSum();
        System.out.println(Arrays.toString(towSum.twoSum2(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(towSum.twoSum2(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(towSum.twoSum2(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(towSum.twoSum2(new int[]{0,4,3,0}, 0)));
        Integer[][] index = new Integer[10][1];
//        index[0] = new Integer[]{1};
        System.out.println(index[0][0]);
    }
}
