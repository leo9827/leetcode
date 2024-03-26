package neetcode150.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-element/"> 347. 前 K 个高频元素 </a>
 * 中等
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1: <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2 <p>
 * 输出: [1,2] <p>
 * <p>
 * 示例 2: <p>
 * 输入: nums = [1], k = 1 <p>
 * 输出: [1] <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 105 <p>
 * k 的取值范围是 [1, 数组中不相同的元素的个数] <p>
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length <= 1) return nums;
            // nums = [1,1,1,2,2,3], k = 2 -> [0,0,0,0] [0,3,2,1] => 1-3,2-2,3-1
            // rest = [1,2] -> [1(3), 2(2), 3(1)] -k-> [1,2]
            int min = 0;
            int max = 0;
            for (int n : nums) {
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
            int[] table = new int[max - min + 1];
            for (int n : nums) {
                table[max-n]++; // [0,3,2,1]
            }

            List[] descSort = new List[nums.length]; // 可能存在相同 count 的 num, 所以count->num1,num2要存放一个list
            for (int i = 0; i < table.length; i++) {
                int num = max - i; //  table[max-num]++; 的反向操作max-i=num  
                int count = table[i];

                if (descSort[count] == null) descSort[count] =  new ArrayList<Integer>();
                descSort[count].add(num); // 可能存在相同 count 的 num, 所以这里没有选择kv
            }

            int[] result = new int[k];
            int index = 0;
            for (int i=descSort.length-1; i>=0; i--) {
                if (descSort[i] != null) {
                    List<Integer> ns = descSort[i];
                    for (int n : ns) {
                        result[index++] = n;
                        if (index == k)  return result;
                    }
                }
            }
            return result;
        }
    }

    static class KV {
        int num;
        public KV(int num){this.num = num;}
    }
}
