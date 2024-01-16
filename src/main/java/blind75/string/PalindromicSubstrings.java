package blind75;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("abc"));//3
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));//6
    }

    public int countSubstrings(String s) {

        Set<String> sss = new HashSet<>();
        // babad
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
                sss.add(left + ","+ right);
                left--;
                right++;
            }
        }

        // cbbd
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i+1;
            while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
                sss.add(left + ","+ right);
                left--;
                right++;
            }
        }

        return sss.size();
    }
    public int countSubstringsDP(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }
    int count = 0;

    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is mid-point
            extendPalindrome(s, i, i);           // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
