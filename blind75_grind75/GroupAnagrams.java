package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 本质上还是分组,每一个str是一个小组, 需要确认每个组是否和其他组相同
        /*
        解法1:(暴力解法) - （看了下答案好像都是这样的）: 排序 + 匹配
        提供相同的一组 str字符空间, 只是装载的是排序过后的str，然后再进行遍历分组，时间复杂度N方
        可以优化的地方：匹配时，已经分好组的元素可以跳过匹配，这样每个元素之需要匹配一次
        */
        Map<String, List<String>> res = new HashMap<>(strs.length);
        char[] arr = new char[26]; //按只有小写英文字母来算
        for (String str : strs) {
/*
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(arr);
*/
            String key = hash(str); // 替换排序
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }
        Collection<List<String>> values = res.values();
        return new ArrayList<>(values);
    }

    String hash(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        System.out.println(String.valueOf(a));
        //"eat" -> [1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
//        return Arrays.toString(a);
        return String.valueOf(a);
    }

    public static void main(String[] args) {
//        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat"}));
    }
}
