package blind75;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        原有区间 1___3 6___9 新区间 2___5
	    将新区间合并到之前的区间之后 1__2__3___5  6___9，只留下头和尾巴, 那么合并完成后结果为 1___5 6___9
        [[1, 3],[6,9]] [2,5] -> [[1,2,3,5], [6,9]] -> [[1,5],[6,9]]

        原有区间 1__2 3__5 6__7 8__10 12__16 新区间 4__8
        将新区间插入到原有区间之后 1__2 3__4__5__6__7__8__10 12__16, 取区间的头尾，合并结果为
         intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
         [[1,2],[3,4,5,6,7,8,10],[12,16]] ->  [[1,2],[3,10],[12,16]]
        1__2 3__10 12__16
        */
        List<int[]> list = new ArrayList<>(intervals.length);
        int idx = 0;
        int st = newInterval[0], ed = newInterval[1];
        //  segment1 区间结束值小于要插入的区间开始值，这部分直接加入到result中
        while (idx < intervals.length && intervals[idx][1] < st) {
            list.add(intervals[idx]);
            idx++;
        }

        // segment2 区间的开始值是小于要插入区间的结尾值的，这部分需要进行合并
        while (idx < intervals.length && intervals[idx][0] <= ed) {
            st = Math.min(st, intervals[idx][0]);
            ed = Math.max(ed, intervals[idx][1]);
            idx++;
        }
        list.add(new int[]{st, ed});

        // segment3 区间的开始值是大于要插入区间的结尾值的，这部分直接加入到result中
        while (idx < intervals.length) {
            list.add(intervals[idx]);
            idx++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
