package neetcode150.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            // System.out.println("i===" + i);
            i = Math.max(index[s.charAt(j)], i);
            // System.out.println("i===" + i);
            ans = Math.max(ans, j - i + 1);
            // System.out.println("s.charAt(j):" + s.charAt(j));
            // System.out.println("index[s.charAt(j)]:" + index[s.charAt(j)]);
            // System.out.println(Arrays.toString(index));
            index[s.charAt(j)] = j + 1;
            // System.out.println(Arrays.toString(index));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("anviaj"));
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int[] table = new int[128];
            int max = 0;
            for (int i=0, j=0; i<s.length(); i++) {
                char c = s.charAt(i);
                j = Math.max(table[c], j);
                max = Math.max(max, i-j+1);
                table[c] = i+1;
            }
            return max;
        }
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) return 0;

            HashMap<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            int max = 0;
            for (int i = 0, j = 0; i < s.length(); ++i) {
                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }
}
