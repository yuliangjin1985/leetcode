package amazon;

import java.util.*;

public class T1 {

    public int[] getMax(int truckSpace, int[] packages) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = packages.length;
        int i1 = -1;
        int i2 = -1;
        int[] ret = new int[2];
        for(int i=0;i<len;i++) {
            List<Integer> orDefault = map.getOrDefault(packages[i], new LinkedList<>());
            orDefault.add(i);
            map.put(packages[i], orDefault);
        }

        for(int key : map.keySet()) {
            if(map.get(truckSpace - 30 - key) != null) {
                List<Integer> integers = map.get(key);
                List<Integer> list = map.get(truckSpace - 30 - key);
                int n1 = integers.get(integers.size()-1);
                int n2 = list.get(list.size()-1);
                if(n1 + n2 > i1 + i2) {
                    i1 = Math.min(n1, n2);
                    i2 = Math.max(n1, n2);
                }

            }
        }

        ret[0] = i1;
        ret[1] = i2;

        return ret;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
//        System.out.println(Arrays.toString(t1.getMax(90, new int[]{1, 10, 25, 35, 60})));
        System.out.println(Arrays.toString(t1.getMax(250, new int[]{100, 180, 40, 120, 10})));
    }
}
