package grind75;

import java.util.Hashtable;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // 1.hashset
        // 2.arr
        if (t.length() < s.length()) {
            return false;
        }
        Map<Character, Integer> table = new Hashtable<>();
        for (char c : s.toCharArray()) {
            if (table.containsKey(c)) {
                table.put(c, table.get(c) + 1);
            } else {
                table.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!table.containsKey(c)) {
                return false;
            } else {
                if (table.get(c) < 1) {
                    return false;
                } else {
                    table.put(c, table.get(c) - 1);
                }
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        // 1.hashset
        // 2.arr
        int[] freqs = new int[26];
        int[] freqt = new int[26];

        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freqt[c - 'a']++;
        }

        for (int i = 0; i != 26; ++i) {
            if (freqs[i] != freqt[i]) {
                return false;
            }
        }
        return true;
    }
}
