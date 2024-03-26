package neetcode150.slidingwindow;

/**
 * <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/description/">424. 替换后的最长重复字符</a>
 * 中等 <p>
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。 <p>
 * <p>
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。 <p>
 * <p>
 * 示例 1： <p>
 * 输入：s = "ABAB", k = 2  <p>
 * 输出：4 <p>
 * 解释：用两个'A'替换为两个'B',反之亦然。 <p>
 * <p>
 * 示例 2： <p>
 * 输入：s = "AABABBA", k = 1 <p>
 * 输出：4 <p>
 * <p>
 * 解释： <p>
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。 <p>
 * 子串 "BBBB" 有最长重复字母, 答案为 4。 <p>
 * 可能存在其他的方法来得到同样的结果。 <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 105
 * s 仅由大写英文字母组成
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        // AABABBA k = 1
        int maxWindowSize = Integer.MIN_VALUE;
        int[] table = new int[26]; // 记录每个字符在当前窗口出现的次数
        int windowStart = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            table[c - 'A']++;
            maxCount = max(maxCount, table[c - 'A']); // 比较当前字符出现次数是否为最多的
            while (windowEnd - windowStart + 1 - maxCount > k) { // 移动窗口
                table[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            int windowSize = windowEnd - windowStart + 1;
            maxWindowSize = max(windowSize, maxWindowSize);
        }
        return maxWindowSize;
    }

    public int max(int a, int b) {
        if (a > b) return a;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }

    static class Solution {

        public int characterReplacement(String s, int k) {
            int winbeg = 0;
            int maxwin = 0;
            int[] count = new int[26];
            int curWinMaxCount = 0;
            for (int winend = 0; winend < s.length(); winend++) {
                char c = s.charAt(winend);
                count[c - 'A']++; // [1]

                curWinMaxCount = Math.max(curWinMaxCount, count[c - 'A']);
                while ((winend - winbeg + 1) - curWinMaxCount > k) { // (winend-winbeg+1)==wingap
                    count[s.charAt(winbeg) - 'A']--; // move winbeg and remove count
                    winbeg++;
                }
                int wingap = winend - winbeg + 1;
                maxwin = Math.max(maxwin, wingap);
            }

            return maxwin;
        }
    }
    
    static class Solution2 {
        public int characterReplacement(String s, int k) {
            int max = 0;
            int wdstart = 0;
            int wdend = 0;
            int wdRepeatedMax = 0;
            int[] table = new int[26];
            for (; wdend<s.length(); wdend++) {
    
                char c = s.charAt(wdend);
                table[c-'A']++; // current char count++
                wdRepeatedMax = Math.max(wdRepeatedMax, table[c-'A']);

                if (wdend-wdstart-wdRepeatedMax+1 > k) {
                    table[s.charAt(wdstart)-'A']--; // windowstart need move, so wdstart's char count--
                    wdstart++;
                }
    
                max = Math.max(max, wdend-wdstart+1);
            }
    
            return max;
        }
    }

}
