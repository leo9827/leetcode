package neetcode150.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[j];
                int y = target - x;
                if (index.containsKey(y)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(y);
                    Collections.sort(list);
                    result.add(list);
                } else {
                    index.put(x, j);
                }
            }
            index.clear();
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        if(nums.length==0) return Collections.emptyList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { // (i > 0 && nums[i] != nums[i-1]) 相邻的值(与上一个值相同)如果是一样的就没必要再找一遍答案了
                int j = i+1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if      (sum == 0)  {
                        while (j < k && nums[j] == nums[j+1]) { // 跳过重复值
                            j++;
                        }
                        while (j < k && nums[k] == nums[k-1]) { // 跳过重复值
                            k--;
                        }
                        res.add(Arrays.asList(nums[i], nums[j++], nums[k--])); // 这里也需要递增和递减
                    }
                    else if (sum >  0)  k--;
                    else if (sum <  0)  j++;
                }
            }
        }
        return res;
    }

    /**
     * 思路：先排序，这样数组就是有序的了
     * 从第1个数开始，拿住第1个数，然后在剩下的数组中尝试左右开弓找和，找到即为解
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) { // -2 是保留最后2个这个区间给 lo和hi 使用
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // 重复的值就快速跳过
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i]; // 左右开弓
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) { // 找到答案，保存
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++; // 跳过重复值
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--; // 跳过重复的值
                        lo++; hi--; // 尝试是否还有别的解答，比如sum=10， 19， 28都是解答， 需要找到lo>=hi为止
                    }
                    else if (nums[lo] + nums[hi] < sum) lo++; // 小了， 左边增大，反之，右边降低
                    else hi--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
