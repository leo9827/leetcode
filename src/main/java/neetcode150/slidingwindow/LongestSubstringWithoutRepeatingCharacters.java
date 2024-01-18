package neetcode150.slidingwindow;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 * longest substring without repeating characters
 * <p>
 * 中等
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * 示例 1: <p>
 * 输入: s = "abcabcbb" <p>
 * 输出: 3 <p>
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 <p>
 * <p>
 * 示例 2: <p>
 * 输入: s = "bbbbb" <p>
 * 输出: 1 <p>
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 <p>
 * <p>
 * 示例 3: <p>
 * 输入: s = "pwwkew" <p>
 * 输出: 3 <p>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 <p>
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。 <p>
 * <p>
 * 提示： <p>
 * 0 <= s.length <= 5 * 104 <p>
 * s 由英文字母、数字、符号和空格组成 <p>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            // System.out.println("i===" + i);
            i = Math.max(index[s.charAt(j)], i);
            // System.out.println("i===" + i);
            ans = Math.max(ans, j - i + 1);
            // System.out.println("s.charAt(j):" + s.charAt(j));
            // System.out.println("index[s.charAt(j)]:" + index[s.charAt(j)]);
            // System.out.println(Arrays.toString(index));
            index[s.charAt(j)] = j + 1;
            // System.out.println(Arrays.toString(index));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("anviaj"));
    }

    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int[] table = new int[128];
            for (int index = 0, lastIndex = 0; index < s.length(); index++) {
                char c = s.charAt(index);

                lastIndex = Math.max(table[c], lastIndex);

                max = Math.max(max, index - lastIndex + 1);

                table[c] = index + 1;
            }
            return max;
        }
    }

    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            int[] position = new int[128];
            int start = 0;
            int end = 0;
            for (char ch : s.toCharArray()) {
                start = Math.max(position[ch], start);
                maxLength = Math.max(maxLength, end - start + 1);
                position[ch] = end + 1;
                end++;
            }
            return maxLength;
        }
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) return 0;

            HashMap<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            int max = 0;
            for (int i = 0, j = 0; i < s.length(); ++i) {
                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }
}
