import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    // Input: nums = [1,2,3]
    // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(lists, nums, new ArrayList<>(), 0);

        return lists;
    }

    public void backtrack(List<List<Integer>> list,  int[] nums, List<Integer> tmp, int index) {
        list.add(new ArrayList<>(tmp));
        for (int i=index;i<nums.length;i++) {
            tmp.add(nums[i]);
            backtrack(list, nums, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

}
