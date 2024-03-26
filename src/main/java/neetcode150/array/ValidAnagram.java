package neetcode150.array;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">242. 有效的字母异位词</a>  <p>
 * 简单 <p>
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1: <p>
 * 输入: s = "anagram", t = "nagaram" <p>
 * 输出: true <p>
 * <p>
 * 示例 2: <p>
 * 输入: s = "rat", t = "car" <p>
 * 输出: false <p>
 * <p>
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104 <p>
 * s 和 t 仅包含小写字母
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // 1.hashset
        // 2.arr
        var freqs = new int[26];
        var freqt = new int[26];

        for (var c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
            freqt[c - 'a']++;
        }

        for (int i = 0; i != 26; ++i) {
            if (freqs[i] != freqt[i]) {
                return false;
            }
        }
        return true;
    }
    // passed
    public boolean isAnagram2(String s, String t) {
        // use 1 arr
        int[] freq = new int[26];
        for (char c:s.toCharArray()) {
            freq[c-'a']++;
        }
        for (char c:t.toCharArray()){
            freq[c-'a']--;
        }
        for (int i=0; i<26; i++) {
            if (freq[i]!=0) return false;
        }
        return true;
    }
}
