package neetcode150;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 * 435. Non-overlapping Intervals
 * Medium
 * NonoverlappingIntervals
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));
        int prev=0;
        int count=1;
        for (int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=intervals[prev][1]){
                prev=i;
                count++;
            }
        }
        return intervals.length-count;
    }
}