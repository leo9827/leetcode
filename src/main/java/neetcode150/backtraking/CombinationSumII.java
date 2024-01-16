package neetcode150.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || target < 1) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int index) {
        if (target == 0) { // find solution
            res.add(new ArrayList<>(ans));
        }
        if (target < 0) return; // not right path
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // skip duplicate
            int candidate = candidates[i];
            if (candidate > target)  continue; // because array is sorted, so if candidate bigger than target it will never become an answer for target
            ans.add(candidate);
            backtrack(candidates, target - candidate, res, ans, i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || target < 1) return Collections.emptyList();
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, res, new ArrayList<>(), 0);
            return res;
        }

        public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> sul, int index) {
            if (target == 0) { // find solution
                res.add(new ArrayList<>(sul));
            }
            if (target < 0) return; // not right path
            for (int i = index; i < candidates.length; i++) {
                if (i != index && candidates[i] == candidates[i - 1]) continue; // skip duplicate
                int candidate = candidates[i];
                if (candidate > target) break;
                sul.add(candidate);
                backtrack(candidates, target - candidate, res, sul, i + 1);
                sul.remove(sul.size() - 1);
            }
        }
    }
}
