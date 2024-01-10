package neetcode150;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/top-k-frequent-element/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < 2) {
            return nums;
        }

        int min = 0, max = 0;
        for (int num : nums) {
            if (min > num) min = num;
            if (max < num) max = num;
        }

        int[] table = new int[max - min + 1];
        // count val
        for (int num : nums) {
            table[max - num]++;
        }
        // sort count
        List[] countTable = new List[nums.length + 1]; // 0 会被忽略
        for (int i = 0; i < table.length; i++) {
            int num = max - i;
            int count = table[i];

            if (countTable[count] == null) countTable[count] = new ArrayList<Integer>();
            countTable[count].add(num);
        }
        int[] result = new int[k];
        int idx = 0;
        for (int i = countTable.length - 1; i > 0; i--) {
            if (countTable[i] != null) {
                List<Integer> list = countTable[i];
                for (Integer num : list) {
                    result[idx++] = num;
                    if (idx == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

}
