package neetcode150.backtraking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        tr(nums, res, new ArrayList<>(), new int[nums.length]);
        return res;
    }

    private void tr(int[] nums, List<List<Integer>> res, List<Integer> ans, int[] walked) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (walked[i] == 1) continue;
            ans.add(nums[i]);
            walked[i] = 1;
            tr(nums, res, ans, walked);
            ans.remove(ans.size() - 1);
            walked[i] = 0;
        }
    }
}
