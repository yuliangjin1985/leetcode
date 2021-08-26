package leetcode75;

import java.util.Arrays;

public class IntervalsNonOverlapping {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cur = intervals[0][1];
        int cnt = 0;
        int n = intervals.length;
        for(int i=1;i<n;i++) {
            if(intervals[i][0] < cur) {
                cnt++;
            } else {
                cur = intervals[i][1];
            }
        }
        return cnt;
    }
}
