package basic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {
    int ver = 0;
    Map<Integer, List<int[]>> map = null;

    public Test(int n) {
        map = new HashMap<>();
    }

    public void set(int i, int v) {
        List<int[]> temp = map.getOrDefault(ver, new LinkedList<>());
        temp.add(new int[]{i, v});
        map.put(ver, temp);
    }

    public int snap() {
        ver++;
        return ver - 1;
    }

    public int get(int i, int id) {
        for(int[] cur : map.get(id)) {
            if(cur[0] == i) return cur[1];
        }
        return id == 0 ? 0 : get(i, id-1);
    }

    public static void main(String[] args) {
        Test test = new Test(4);
        System.out.println(test.snap());
        System.out.println(test.snap());
        System.out.println(test.get(3, 1));
    }
}
