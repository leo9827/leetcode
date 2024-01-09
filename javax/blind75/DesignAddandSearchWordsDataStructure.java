package blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DesignAddandSearchWordsDataStructure {

//    public static void main(String[] args) {
//        WordDictionary dictionary = new WordDictionary();
//        dictionary.addWord("bad");
//        dictionary.addWord("dad");
//        dictionary.addWord("mad");
//        dictionary.addWord("pad");
//        System.out.println(dictionary.search(".ad"));
//        System.out.println(dictionary.search("bad"));
//        System.out.println(dictionary.search("..d"));
//    }
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("a");
        dictionary.addWord("a");
        System.out.println(dictionary.search("."));
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search("aa"));
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search(".a"));
        System.out.println(dictionary.search("a."));
    }
}

class WordNode {
    char c;
    Map<Character, WordNode> children;
    boolean is_end;
}

class WordDictionary {
    WordNode root;

    public WordDictionary() {
        root = new WordNode();
        root.children = new HashMap<>(26);
        root.is_end = false;
    }

    public void addWord(String word) {
        WordNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                WordNode node = new WordNode();
                node.c = c;
                node.children = new HashMap<>(26);
                cur.children.put(c, node);
            }
            cur = cur.children.get(c);
        }
        cur.is_end = true;
    }

    public boolean search(WordNode cur, String word, int index) {
        if (index == word.length()) { return cur.is_end; }
        char c = word.charAt(index);
        if (c == '.') {
            for (Entry<Character, WordNode> entry : cur.children.entrySet()) {
                boolean ret = search(entry.getValue(), word, index+1);
                if (ret) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
                return search(cur, word, index+1);
            } else {
                return false;
            }
        }
    }

    public boolean search(String word) {
        WordNode cur = root;
        return search(cur, word, 0);
    }
}
