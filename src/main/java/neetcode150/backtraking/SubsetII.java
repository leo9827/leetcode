package neetcode150.backtraking;

import java.util.*;

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] numbs) {
        if (numbs == null || numbs.length == 0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbs);

        backtrack(numbs, res, new ArrayList<>(), 0);

        return res;
    }

    public void backtrack(int[] numbs, List<List<Integer>> res, List<Integer> set, int index) {
        res.add(new ArrayList<>(set));

        for (int i = index; i < numbs.length; i++) {
            if (i != index && numbs[i] == numbs[i - 1]) continue;
            set.add(numbs[i]);
            backtrack(numbs, res, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] numbs) {
            if (numbs == null || numbs.length == 0) return Collections.emptyList();
            Set<List<Integer>> res = new HashSet<>();
            Arrays.sort(numbs);

            backtrack(numbs, res, new ArrayList<>(), 0);

            return new ArrayList<>(res);
        }

        public void backtrack(int[] numbs, Set<List<Integer>> res, List<Integer> set, int index) {
            if (!res.contains(set)) {
                res.add(new ArrayList<>(set));
            }
            for (int i=index; i<numbs.length; i++) {
                set.add(numbs[i]);
                backtrack(numbs, res, set, i+1);
                set.remove(set.size()-1);
            }
        }
    }
}
