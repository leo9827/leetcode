package neetcode150.dp;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII breakII = new WordBreakII();
//        System.out.println(breakII.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code")))); // ["leet code"]
//        System.out.println(breakII.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")))); //["cats and dog","cat sand dog"]
//        System.out.println(breakII.wordBreak("a", new ArrayList<>(Arrays.asList("a")))); // ["a"]
//        System.out.println(breakII.wordBreak("abcd", new ArrayList<>(Arrays.asList("a","abc","b","cd")))); // ["a b cd"]
        System.out.println(breakII.wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple","pen","applepen","pine","pineapple"))));//        ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        System.out.println(breakII.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"))));
        System.out.println(breakII.wordBreakTabulation("pineapplepenapple", new ArrayList<>(Arrays.asList("apple","pen","applepen","pine","pineapple"))));//        ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        System.out.println(breakII.wordBreakTabulation("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"))));


    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }
    public List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        if (Objects.equals(s, "")) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        List<String> rets = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> ret = wordBreak(s.substring(word.length()), wordDict, memo);
                if (ret != null) {

                    for (String retStr : ret) {
                        String temp = word;
                        if (Objects.equals(retStr, "")) {
                            rets.add(temp);
                        } else {
                            temp += " ";
                            temp += retStr;
                            rets.add(temp);
                        }
                    }
                }
            }
        }

        memo.put(s, rets);
        return rets;
    }

    public List<String> wordBreakTabulation(String s, List<String> wordDict) {
        if (Objects.equals(s, "")) return new ArrayList<>();

        List<String>[] table = new List[s.length()+1];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }
        table[0].add("");
        for (int i = 0; i < s.length(); i++) {
            if (table[i] != null) { // 新的起点
                for (String word : wordDict) {
                    if (word.charAt(0) == s.charAt(i) && s.startsWith(word, i)) {
                        List<String> list = table[i + word.length()];
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        List<String> prefixList = table[i];
                        for (String prefix : prefixList) {
                            if ("".equals(prefix)) {
                                list.add(word);
                            } else {
                                list.add(prefix + " " + word);
                            }
                        }
                        table[i + word.length()] = list;
                    }
                }
            }
        }
        return table[s.length()];
    }

}
