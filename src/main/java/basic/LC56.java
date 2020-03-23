package basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC56 {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        LinkedList<Interval> list = new LinkedList<>();
        for(Interval cur : intervals) {
            if(list.size() == 0 || list.getLast().end < cur.start) {
                list.add(cur);
            } else if(cur.start == list.getLast().start) {
                list.getLast().end = Math.max(cur.end, list.getLast().end);
            } else if(cur.start <= list.getLast().end) {
                list.getLast().end = cur.end;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        List<Interval> merge = new LC56().merge(intervals);
        for (Interval interval : merge) {
            System.out.println("Start : " + interval.start + " , End: " + interval.end);
        }
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

}
