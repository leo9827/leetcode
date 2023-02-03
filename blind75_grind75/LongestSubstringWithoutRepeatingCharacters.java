package grind75;

import java.util.Arrays;
import java.util.HashSet;

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
}
