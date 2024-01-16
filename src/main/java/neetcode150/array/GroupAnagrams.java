package neetcode150.array;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">49. 字母异位词分组</a>
 * <p>
 * 中等
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] <p>
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]] <p>
 * 示例 2:
 * <p>
 * 输入: strs = [""] <p>
 * 输出: [[""]] <p>
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 本质上还是分组,每一个str是一个小组, 需要确认每个组是否和其他组相同
        /*
        解法1:(暴力解法) - （看了下答案好像都是这样的）: 排序 + 匹配
        提供相同的一组 str字符空间, 只是装载的是排序过后的str，然后再进行遍历分组，时间复杂度N方
        可以优化的地方：匹配时，已经分好组的元素可以跳过匹配，这样每个元素之需要匹配一次
        */
        Map<String, List<String>> res = new HashMap<>(strs.length);
        for (String str : strs) {
            String key = hash(str);
            if (!res.containsKey(key)) res.put(key, new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }

    public String hash(String str) {
        char[] arr = new char[26];
        for (char c : str.toCharArray()) arr[c - 'a']++;
        return String.valueOf(arr);
    }

    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>(0);
            Map<String, List> map = new HashMap<>();
            for (String str : strs) {
                char[] charArr = str.toCharArray();
                Arrays.sort(charArr);
                String key = String.valueOf(charArr);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList());
                }
                map.get(key).add(str);
            }
            return new ArrayList(map.values());
        }
    }

}
