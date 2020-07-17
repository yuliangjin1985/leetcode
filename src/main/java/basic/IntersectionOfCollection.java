package basic;

import java.util.*;

public class IntersectionOfCollection {
    public List<Integer> peopleIndexes(List<List<String>> f) {
        int size = f.size();
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<size;i++) {
            for(String c : f.get(i)) {
                List<Integer> l = map.getOrDefault(c, new LinkedList<Integer>());
                l.add(i);
                map.put(c, l);
            }
        }
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<size;i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<f.get(i).size();j++) {
                String com = f.get(i).get(j);
                if(j == 0) {
                    set = new HashSet<>(map.get(com));
                } else {
                    set.retainAll(new HashSet<>(map.get(com)));
                }
            }
            if(set.size()<2) {
                list.add(i);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        IntersectionOfCollection intersectionOfCollection = new IntersectionOfCollection();
        List<List<String>> lists = new LinkedList<>();
        List<String> l0 = Arrays.asList(new String[]{"leetcode", "google", "facebook"});
        List<String> l1 = Arrays.asList(new String[]{"google","microsoft"});
        List<String> l2 = Arrays.asList(new String[]{"google","facebook"});
        List<String> l3 = Arrays.asList(new String[]{"google"});
        List<String> l4 = Arrays.asList(new String[]{"amazon"});
        lists.add(l0);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        List<Integer> integers = intersectionOfCollection.peopleIndexes(lists);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
