package neetcode150.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
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


}
