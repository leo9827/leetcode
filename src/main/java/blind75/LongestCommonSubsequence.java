package blind75;

import java.util.Arrays;
import java.util.Objects;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.longestCommonSubsequenceRecurision("bcdef", "acef"));//3
        System.out.println(l.longestCommonSubsequenceRecurision("abcde", "ace"));//3
        System.out.println(l.longestCommonSubsequenceRecurision("abc", "abc"));//3
        System.out.println(l.longestCommonSubsequenceRecurision("abc", "def"));//0
        System.out.println(l.longestCommonSubsequenceRecurision("ezupkr","ubmrapg"));//2
        System.out.println(l.longestCommonSubsequenceRecurision("oxcpqrsvwf", "shmtulqrypy"));//2 qr
        System.out.println(l.longestCommonSubsequenceRecurision("abcba", "abcddba"));//5 qr
        System.out.println(l.longestCommonSubsequenceRecurision("pmjghexybyrgzczy","hafcdqbgncrcbihkd")); // 4
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        if (Objects.equals(text1, text2)) return text1.length();
        if (Objects.equals(text1, "") || Objects.equals(text2, "")) return 0;

        int[][] table = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    table[i][j] = table[i-1][j-1] + 1;
                } else {

                    table[i][j] = Math.max(table[i][j-1], table[i-1][j]);
                }
            }
        }
        return table[text1.length()][text2.length()];
    }

    public int longestCommonSubsequenceRecurision(String text1, String text2) {
        return longestCommonSubsequenceRecurision(text1, text1.length(), text2, text2.length());
    }
    public int longestCommonSubsequenceRecurision(String text1, int i, String text2, int j) {
        if (i <= 0) return 0;
        if (j <= 0) return 0;
        if (text1.charAt(i-1) == text2.charAt(j-1)) return longestCommonSubsequenceRecurision(text1, i-1, text2, j-1) + 1;
        return Math.max(
                longestCommonSubsequenceRecurision(text1, i-1, text2, j),
                longestCommonSubsequenceRecurision(text1, i, text2, j-1)
        );
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (Objects.equals(text1, text2)) return text1.length();
        if (Objects.equals(text1, "") || Objects.equals(text2, "")) return 0;

        int[][] table = new int[text1.length()+1][text2.length()+1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    table[i][j] = 1 + table[i+1][j+1];
                } else {
                    table[i][j] = Math.max(table[i][j+1],table[i+1][j]);
                }
            }
        }
        return table[0][0];
    }


}
