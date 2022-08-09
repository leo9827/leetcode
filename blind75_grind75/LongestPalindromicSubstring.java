package grind75;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd")); // "bb"
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbb")); // "bb"
        /*
        cbbd
        c bbd   cb bd   cbb d
        c b bd  c b bd  c bb d
            b d
         */
    }
    private int begin, maxLen;

    public String longestPalindromeTwoPointer2(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        String res = "";

        // babad
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
                if (right-left + 1 > res.length()) {
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }

        // cbbd
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i+1;
            while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
                if (right-left + 1 > res.length()) {
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }

        return res;
    }
    public String longestPalindromeTwoPointer(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        expandCenter(str, n >> 1, 0);
        return new String(str, begin, maxLen);
    }

    private void expandCenter(char[] str, int idx, int direction) {
        int len = str.length;
        int i = idx - 1;
        int j = idx + 1;

        while (i >= 0 && str[i] == str[idx])
            i--;
        while (j < len && str[j] == str[idx])
            j++;

        int left = i;
        int right = j;
        while (left >= 0 && right < len
                && str[left] == str[right]) {
            left--;
            right++;
        }

        if (right - left - 1 > maxLen) {
            begin = left + 1;
            maxLen = right - left - 1;
        }

        if (i << 1 > maxLen && direction <= 0)
            expandCenter(str, i, -1);

        if (len - j << 1 > maxLen && direction >= 0)
            expandCenter(str, j, 1);
    }

    public String longestPalindromeTabulation(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;

        int n = s.length();
        String res = null;

        boolean[][] table = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                table[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || table[i + 1][j - 1]);

                if (table[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome(String s) {
        return longestPalindrome(s, new HashMap<>(s.length()));
    }
    private final Map<String, Boolean> isPalindromeMap = new HashMap<>();
    public String longestPalindrome(String s, Map<String, String> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        /*
        babad
                babad
              b abad        ba bad    bab ad   baba d
                a bad      b a b ad   1   a d  b aba d
                  b ad           a d
                   a d
         */
        if (s == null || s.equals("") )
        {
            memo.put(s, "");
            return "";
        }

        if (isPalindrome(s)) {
            memo.put(s, s);
            return s;
        }

        String longest = "";
        for (int i = 1; i < s.length(); i++) {
            String left = longestPalindrome(s.substring(0, i), memo);
            String right = longestPalindrome(s.substring(i), memo);
            String max = left.length() > right.length() ? left : right;

            if (max.length() > longest.length()) {
                longest = max;
            }
        }
        memo.put(s, longest);
        return longest;
    }
    private boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        if (isPalindromeMap.containsKey(s)) return isPalindromeMap.get(s);
        int left=0, right = s.length()-1;
        while (left<right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindromeMap.put(s, false);
                return false;
            }
            left++;
            right--;
        }
        isPalindromeMap.put(s, true);
        return true;
    }
}
