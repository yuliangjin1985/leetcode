package doordash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule.size() <= 1)
            return new ArrayList<>();

        List<Interval> ans = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();

        schedule.forEach(s -> intervals.addAll(s));
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prevEnd = intervals.get(0).end;

        for (final Interval interval : intervals) {
            if (interval.start > prevEnd)
                ans.add(new Interval(prevEnd, interval.start));
            prevEnd = Math.max(prevEnd, interval.end);
        }

        return ans;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}