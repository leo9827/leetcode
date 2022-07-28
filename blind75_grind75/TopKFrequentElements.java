package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements {

    // 方式1，先统计再根据统计大小排序，最后得出结果
    // 方式2，sortedmap?
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1}, 1)));
    }

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
                    if (idx==k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        // 方式1，统计加排序
        // 方式2，[max, max-1, max-2]
        Map<Integer, Integer> table = new HashMap<>();

        List<List<Integer>> cseq = new ArrayList<>(nums.length + 1);
        cseq.add(0, new ArrayList<>());
        int idx = 1;
        for (int i : nums) {
            cseq.add(idx, new ArrayList<>());
            if (!table.containsKey(i)) {
                table.put(i, 0);
            }
            table.put(i, table.get(i) + 1);
        }

        for (Entry<Integer, Integer> et : table.entrySet()) {
            if (cseq.get(et.getValue()) == null) {
                cseq.add(et.getValue(), new ArrayList<>());
            }
            cseq.get(et.getValue()).add(et.getKey());
        }
        System.out.println(cseq);
        int[] ret = new int[k];
        int ct = 0;
        for (int i = cseq.size() - 1; i > 0; i--) {
            for (Integer key : cseq.get(i)) {
                ret[ct++] = key;
                if (k == ct) {
                    return ret;
                }
            }
        }
        return new int[]{};
    }

}

class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < 2) {
            return nums;
        }

        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int[] countVals = new int[max - min + 1];
        for (int num : nums) {
            countVals[max - num]++;
        }

        List[] arr = new List[nums.length + 1];
        for (int i = 0; i < countVals.length; i++) {
            if (countVals[i] > 0) {
                int num = max - i;
                if (arr[countVals[i]] == null) {
                    arr[countVals[i]] = new ArrayList<Integer>();
                }
                arr[countVals[i]].add(num);
            }
        }

        int count = 0;
        int[] result = new int[k];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) {
                List<Integer> temp = arr[i];
                for (int num : temp) {
                    result[count++] = num;
                    if (count == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}