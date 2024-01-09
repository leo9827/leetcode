package grind75;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {
        // sort the array and compare the elements  O(n), 
        // add the elements in to set  O(n)  , O(n)
        // 
        // Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            return true;
        }
        //  return false;
        Set hs = new HashSet();
        for(int i=0;i<nums.length;i++)
        {
            if(!hs.add(nums[i]))
            return true;   
        }
        return false;
    }
}
