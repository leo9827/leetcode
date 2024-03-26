package neetcode150.array;

import java.util.Map;
import java.util.HashMap;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i:nums) {
            mp.put(i, mp.getOrDefault(i, 0));
        }
        int maxFreq = Integer.MIN_VALUE;
        for (int freq : mp.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        int count=0;
        for (int freq : mp.values()) {
            if (freq == maxFreq) {
                count+=freq;
            }
        }
        return count;
    }
}
