package map;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RangeModule {
    TreeMap<Integer, Integer> range = null;

    public RangeModule() {
        range = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer v1 = range.floorKey(left);
        Integer v2 = range.floorKey(right);

        if(v1 == null && v2 == null) {
            range.put(left, right);
        } else if(v1 != null && range.get(v1) >= left) {
            range.put(v1, Math.max(Math.max(range.get(v2), right), range.get(v1)));
        } else {
            range.put(left, Math.max(range.get(v2), right));
        }

        Map<Integer, Integer> subMap = range.subMap(left, false, right, true);
        range.keySet().removeAll(new HashSet(subMap.keySet()));
    }

    public boolean queryRange(int left, int right) {
        Integer v1 = range.floorKey(left);
        return v1 != null && range.get(v1) >= right;
    }

    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = range.floorKey(left);
        Integer end = range.floorKey(right);
        if (end != null && range.get(end) > right) {
            range.put(right, range.get(end));
        }
        if (start != null && range.get(start) > left) {
            range.put(start, left);
        }
        Map<Integer, Integer> subMap = range.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        range.keySet().removeAll(set);
    }
}
