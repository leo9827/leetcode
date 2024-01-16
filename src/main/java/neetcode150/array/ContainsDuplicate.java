package neetcode150.array;

import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                return true;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}