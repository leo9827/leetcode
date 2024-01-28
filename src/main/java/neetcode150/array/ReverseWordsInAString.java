package neetcode150.array;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/description">151. Reverse Words in a String</a>
 * Medium
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = len-1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }

            int j = i-1;
            while(j >= 0 && s.charAt(j) != ' ') j--;

            sb.append(" ");
            sb.append(s.substring(j+1, i+1));
            i = j-1;
        }
        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        String res = r.reverseWords("the sky is blue");
        System.out.println(res == "blue is sky the");
    }

    static class Solution {
        public String reverseWords(String s) {
            String[] str = s.split(" ");
            StringBuilder sb=new StringBuilder();
            for(int i=str.length-1;i>=0;i--){ // 从后往前遍历
                if(str[i] != ""){
                    sb.append(str[i]).append(" ");
                }
            }
            sb.setLength(sb.length( )-1); // 去掉最后一个空格。
            return sb.toString();
        }
    }
}
