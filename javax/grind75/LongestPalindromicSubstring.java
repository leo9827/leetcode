package grind75;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longest = "";
        if (s == "") return longest;

        for (int i=0; i<s.length(); i++) {
            int left = i, right = i;
            while (left>=0 && right <s.length() && s.charAt(left) == s.charAt(right) ) {
                if (right-left+1>longest.length()) {
                    longest = s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }

        for (int i=0; i<s.length(); i++) {
            int left = i, right = i+1;
            while (left>=0 && right <s.length()&&s.charAt(left) == s.charAt(right)) {
                if (right-left+1>longest.length()) {
                    longest = s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return longest;
    }
}
