package blind75.tree;

import java.util.Hashtable;
import java.util.Map;

public class ImplementTriePrefixTree {

}
class TrieNode {
    Map<Character, TrieNode> children;
    boolean is_end;
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.children = new Hashtable<>( 26); // 26 -> 32
    }

    public void insert(String word) {
        if (word == null) return;

        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                TrieNode trieNode = new TrieNode();
                trieNode.children =  new Hashtable<>( 26);
                cur.children.put(c, trieNode);
            } else {
                // do nothing
            }
            cur = cur.children.get(c);
        }
        cur.is_end = true;
    }

    public boolean search(String word) {
        if (word == null) return false;
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        if (cur.is_end == false) {
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}