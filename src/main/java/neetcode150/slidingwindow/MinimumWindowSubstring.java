package neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring
 * Hard
 * 
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

    注意：

    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    如果 s 中存在这样的子串，我们保证它是唯一的答案。
    

    示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
    解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。

    示例 2：
    输入：s = "a", t = "a"
    输出："a"
    解释：整个字符串 s 是最小覆盖子串。

    示例 3:
    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。

 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        /*
        "ABC" -> ['A','B','C']
        "BCE" -> ['B','C','E']
        start = min(index) of 已找到的序列, 怎么判断找没找够t个元素( map + linked list ) 使用 size==t.length()进行判断
        功能: 要知道找到了每一个的位置, 重复的怎么算?
        有一个地方需要记录一下命中了ABC 中的任意一个，命中的第一个就是start,命中的最后一个就是end，此时计算长度，保留较小的值
        窗口移动 ->
         "ADOBECODAEBANC" -> "ADOBEC" -> "DOBEC" -> "DOBECODA" -> "OBECODA" -> "BECODA" -> "ECODA" -> "ECODAEB"
          -> "CODAEB" -> "ODAEB" -> "ODAEBANC" -> "DAEBANC" -> "AEBANC" -> "EBANC" -> "BANC" -> "ANC"
        */
        Map<Character, Integer> table = new HashMap<>();
        for (char c : t.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0) + 1);
        }
        int minStartIdx = 0, minLen = s.length(), findall = t.length();
        int start = 0;
        boolean find = false;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (table.containsKey(c)) {
                table.put(c, table.getOrDefault(c, 0) - 1);
                if (table.get(c) >= 0) findall--; // 0->1->2->3

                while (findall == 0) {
                    find = true;
                    int curLen = end + 1 - start;
                    if (curLen < minLen) {
                        minLen = curLen;
                        minStartIdx = start;
                    }

                    char startc = s.charAt(start);
                    if (table.containsKey(startc)) {
                        table.put(startc, table.getOrDefault(startc, 0) + 1);
                        if (table.get(startc) >= 1) findall++;
                    }
                    start++;
                }
            }
        }
        System.out.println(minLen);
        System.out.println(find);
        return find ? s.substring(minStartIdx, minStartIdx + minLen) : "";
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("aa", "aa"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
    }
}
