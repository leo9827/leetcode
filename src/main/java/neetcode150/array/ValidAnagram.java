package neetcode150;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // 1.hashset
        // 2.arr
        var freqs = new int[26];
        var freqt = new int[26];

        for (var c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
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
