package api;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 1, 6, 8};
        Arrays.sort(ints, 2, 6);//Sort a range in an array.
        System.out.println(String.join(",", Arrays.stream(ints).mapToObj(String::valueOf).toArray(String[]::new)));
        System.out.println(System.identityHashCode(ints));
        testSet();
    }

    public static void testSet() {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        set.add(new ArrayList<>(integers));
        set.add(new ArrayList<>(integers));
        set.add(new ArrayList<>(integers));
        System.out.println(set.size());
    }
}
