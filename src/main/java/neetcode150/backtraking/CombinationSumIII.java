package neetcode150.backtraking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/?envType=study-plan-v2&envId=leetcode-75">
 * 216. Combination Sum III</a>
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combination(res, new ArrayList<>(), k, 1, n); // start index with 1
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> comb, int k,  int index, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            res.add(li);
            return;
        }
        for (int i = index; i <= 9; i++) {
            comb.add(i);
            combination(res, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
