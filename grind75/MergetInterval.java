package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b)-> (a[0]- b[0]));
        List<int[]> ans = new ArrayList<>(intervals.length);
        int[] cur = intervals[0];
        for (int i=1;i<=intervals.length; i++) {
            if (i < intervals.length && cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                int[] tmp = new int[2];
                tmp[0] = cur[0];
                tmp[1] = cur[1];
                ans.add(tmp);
                if (i < intervals.length) {
                    cur = intervals[i];
                }                
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}