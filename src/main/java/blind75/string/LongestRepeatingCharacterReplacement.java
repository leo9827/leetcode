package blind75;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        // AABABBA k = 1
        int maxWindowSize = Integer.MIN_VALUE;
        int windowStart = 0;
        int[] table = new int[26];
        int maxCount = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            table[c - 'A']++;
            maxCount = max(maxCount, table[c - 'A']);
            while (windowEnd - windowStart + 1 - maxCount > k) {
                table[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            int windowSize = windowEnd - windowStart + 1;
            maxWindowSize = max(windowSize, maxWindowSize);
        }
        return maxWindowSize;
    }
    public int max(int a, int b) {
        if (a > b) return a;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }
}
