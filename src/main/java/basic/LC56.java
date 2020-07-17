package basic;

import java.util.*;

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
//        List<Interval> intervals = new LinkedList<>();
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(1,2));
//        intervals.add(new Interval(2,6));
//        intervals.add(new Interval(6,7));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
//        List<Interval> merge = new LC56().merge(intervals);
//        for (Interval interval : merge) {
//            System.out.println("Start : " + interval.start + " , End: " + interval.end);
//        }

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        LC56 lc56 = new LC56();
        int[][] merge = lc56.merge(intervals);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " :" + ints[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Comparator<int[]> comparator = (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        };
        Arrays.sort(intervals, comparator);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals) {
            int key = interval[0];
            int value = interval[1];
            Integer floor = map.floorKey(key);
            if(floor != null) {
                if(map.get(floor) < key) {
                    map.put(key, value);
                } else {
                    map.put(floor, Math.max(map.get(floor), value));
                }
            } else {
                map.put(key, value);
            }

        }

        int len = map.size();
        int[][] ret = new int[len][2];
        int id = 0;
        for(int key : map.keySet()) {
            ret[id][0] = key;
            ret[id++][1] = map.get(key);
        }
        return ret;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
