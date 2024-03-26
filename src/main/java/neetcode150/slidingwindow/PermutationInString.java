package neetcode150.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/permutation-in-string/description/
567. Permutation in String, 567. 字符串的排列
Medium

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    // 这里的思路是，将s1放入到一个 table(k:char-v:出现次数count) 中，这样就可以忽略它所有的排列
    // 然后再以同样的窗口长度，移动窗口取出 s2 的子串放入同样的 table 中，通过两个 table 相等则 s1 是 s2 的子串
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] arr1 = new int[26]; // 用作hash + count来比较是否重复
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i)- 'a']++;
            arr2[s2.charAt(i)- 'a']++;
        }
        // edge case: s1 == s2
        if (Arrays.equals(arr1, arr2)) return true;

        int winBegin = 0;
        int winlen = s1.length();
        // fixed window size!!!
        // window: front-back, front start from 0
        while(winlen < s2.length()){
            arr2[s2.charAt(winBegin) - 'a']--;
            arr2[s2.charAt(winlen) - 'a']++;

            if(Arrays.equals(arr1, arr2)) return true;
            winBegin++;
            winlen++;
        }
        return false;
    }


    public boolean checkInclusion2(String s1, String s2) {
        List<String> strings = permutation(s1);
        for (String str : strings) {
            if (checkSubString(str, s2)) return true;
        }
        return false;
    }

    public boolean checkSubString(String s1, String s2) {
        int idx = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(idx)) {
                while (idx < s1.length() && (i + idx) < s2.length() && s2.charAt(i + idx) == s1.charAt(idx)) {
                    idx++;
                }
                if (idx == s1.length()) {
                    return true;
                } else {
                    idx = 0;
                }
            }
        }
        return false;
    }

    public List<String> permutation(String s1) {
        List<String> results = new ArrayList<>();
        if (s1.length() == 1) {
            results.add(s1);
            return results;
        }
        char[] charArray = s1.toCharArray();
        bp(charArray, results, "", new int[charArray.length]);
        return results;
    }

    public void bp(char[] src, List<String> results, String cur, int[] walked) {
        if (cur.length() == src.length) {
            results.add(cur);
            return;
        }

        for (int i = 0; i < src.length; i++) {
            if (walked[i] == 1) continue;
            cur += src[i];
            walked[i] = 1;
            bp(src, results, cur, walked);
            walked[i] = 0;
            cur = cur.substring(0, cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        PermutationInString p = new PermutationInString();
        System.out.println(p.checkInclusion(s1, s2));
        String ss1 = "adc", ss2 =  "dcda";
        System.out.println(p.checkInclusion(ss1, ss2));
        String sss1 = "abc", sss2 =  "bbbca";
        System.out.println(p.checkInclusion(sss1, sss2));
    }
}
