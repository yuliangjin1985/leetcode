package leetcode75;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] i : intervals)
            if (!merged.isEmpty() && merged.getLast()[1] >= i[0])
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            else merged.add(i);
        return merged.toArray(new int[0][]);
    }
}
