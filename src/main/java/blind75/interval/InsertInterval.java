package blind75.interval;

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
        int index = 0;
        int left = newInterval[0], right = newInterval[1];
        //  segment1 区间结束值小于要插入的区间开始值，这部分直接加入到result中
        while (index < intervals.length && intervals[index][1] < left) { // intervals[index][1] < left 说明区间结束值小于要插入的区间开始值, 这部分直接加入到result中
            list.add(intervals[index]);
            index++;
        }

        // segment2 区间的开始值是小于要新插入区间的结尾值的，
        // 并且前面已经把结尾比left小的全部判断过了，
        // 所以当前区间的开始肯定是肯定是>=left,然后结尾又<=right，故此当前区间和新插入区间有重合
        // 这部分需要进行合并, 合并比较简单: 取较小的 left 和较大的 right
        while (index < intervals.length && intervals[index][0] <= right) { // intervals[index][0] <= right 说明区间的开始值是小于新区间的结尾值，比如3__5 对上 4__8，说明有重合，这部分需要进行合并
            left = Math.min(left, intervals[index][0]);
            right = Math.max(right, intervals[index][1]);
            index++;
        }
        list.add(new int[]{left, right});

        // segment3 区间的开始值是大于要插入区间的结尾值的，这部分直接加入到result中
        while (index < intervals.length) {
            list.add(intervals[index]);
            index++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
