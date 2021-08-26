package leetcode75;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new LinkedList<>();
        int i = 0;
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        while(i < n && intervals[i][1] < newInterval[0]) {
            l.add(intervals[i++]);
        }

        while(i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        l.add(new int[]{start, end});
        while(i < n) {
            l.add(intervals[i++]);
        }
        int m = l.size();
        return l.toArray(new int[m][2]);
    }
}
