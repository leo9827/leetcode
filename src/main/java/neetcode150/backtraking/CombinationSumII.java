package neetcode150.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">40. 组合总和 II.</a>
 * <p>
 * 中等
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
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
            if (candidate > target)
                continue; // because array is sorted, so if candidate bigger than target it will never become an answer for target
            ans.add(candidate);
            backtrack(candidates, target - candidate, res, ans, i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    static class Solution {
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
