package blind75.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code")))); // true
        System.out.println(wordBreak.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")))); // false
        System.out.println(wordBreak.wordBreak("a", new ArrayList<>(Arrays.asList("a")))); // true
        System.out.println(wordBreak.wordBreak("abcd", new ArrayList<>(Arrays.asList("a","abc","b","cd")))); // true
        System.out.println(wordBreak.wordBreak2("leetcode", new ArrayList<>(Arrays.asList("leet", "code")))); // true
        System.out.println(wordBreak.wordBreak2("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")))); // false
        System.out.println(wordBreak.wordBreak2("a", new ArrayList<>(Arrays.asList("a")))); // true
        System.out.println(wordBreak.wordBreak2("abcd", new ArrayList<>(Arrays.asList("a","abc","b","cd")))); // true
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        [fffff] -> s.length+1, index代表前面的字符串是否可能被拼接到
        "",[...] -> true => [abcd-] -> a是可以作为a之前是可以被拼接到的，a可以作为新起点

        [tffff] -> a   -> [ttfff] -> b是可以作为起点的
                          [abcd-]
        [tffff] -> abc -> [ttftf] -> d是可以作为起点的
        [tffff] -> b   -> [ttttf] -> c是可以作为起点的
        [tffff] -> cd  -> [ttttf] -> -是可以作为起点的
         */
        if (s == null || s.length() <1) return true;

        boolean[] table = new boolean[s.length()+1];
        table[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (table[i]) { // 当前位置是可以作为新起点, i=0的时候是a
                // 前缀匹配
                for (String word : wordDict) {
                    if (word.charAt(0) == s.charAt(i) && s.startsWith(word, i))  // 前缀一样,并且匹配
                    {
                        table[i+word.length()] = true;
                    }
                }
            }
        }
        return table[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }
    public boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        if (Objects.equals(s, "")) return true;

        for (String word:wordDict) {
            if (s.startsWith(word)) {
                boolean ret = wordBreak(s.substring(word.length()), wordDict, memo);
                memo.put(s, ret);
                if (ret) return true;
            }
        }

      memo.put(s, false);
        return false;
    }
}
