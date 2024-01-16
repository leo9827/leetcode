package neetcode150.backtraking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        if (null == s) return Collections.emptyList();
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(String s, List<List<String>> res, List<String> ans, int begin) {
        // exit condition
        if (begin == s.length()) { // find all partition/ begine reach to s.length()
            res.add(new ArrayList<>(ans));
        }

        for (int i = begin; i < s.length(); i++) {
            // suitable condition
            // if begin-i of substring satisfy condition, try choose next one
            if (isPalindrome(s, begin, i)) {
                ans.add(s.substring(begin, i + 1));
                backtrack(s, res, ans, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                    }
                }
            }
            helper(res, new ArrayList<>(), dp, s, 0);
            return res;
        }

        private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
            if (pos == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = pos; i < s.length(); i++) {
                if (dp[pos][i]) {
                    path.add(s.substring(pos, i + 1));
                    helper(res, path, dp, s, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
