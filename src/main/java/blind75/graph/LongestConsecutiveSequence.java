package blind75.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence
{

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Set<Integer> table = new HashSet<>();
        for (int num : nums) table.add(num);
        int ans = 0;
        for(int num : nums) {
            int left  = num - 1;
            int right = num + 1;
            while(table.remove(left))  left--;
            while(table.remove(right)) right++;
            ans = Math.max(ans, right - left - 1);
            if(table.isEmpty()) return ans; //save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }

    public int longestConsecutive3(int[] nums) {
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int n = 1, m = 1;
        for (int i = 1; i < nums.length; i++){
            if      (nums[i]-nums[i-1] == 1) n++;
            else if (nums[i]-nums[i-1] != 0) n = 1; // nums[i]-nums[i-1] == 0 的时候什么都不做，continue;
            if (n > m) m = n;
        }
        return m;
    }
    public int longestConsecutive2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // 1.先排序，排序完成再进行分组(interval) 还要注意去重
        Arrays.sort(nums);
        List<Integer>[] table = new List[nums.length + 1];
        int idx = 0;
        table[idx] = new ArrayList<>();
        table[idx].add(nums[idx]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] == nums[i-1]+1) {
                table[idx].add(nums[i]);
            } else {
                table[++idx] = new ArrayList<>();
                table[idx].add(nums[i]);
            }
        }
        System.out.println(Arrays.toString(table));
        int max = 0;
        for (List<Integer> integers : table) {
            if (integers != null && max < integers.size()) {
                max = integers.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}
