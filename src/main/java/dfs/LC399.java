package dfs;

import java.util.Arrays;

public class LC399 {

    boolean[] visited;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int len = equations.length;
        double[] result = new double[queries.length];


        for(int i=0;i<queries.length;i++) {
            visited = new boolean[len];
            result[i] = dfs(equations, values, queries[i], 1.0);
        }

        return result;
    }

    double dfs(String[][] equations, double[] values, String[] query, double last) {

        int len = equations.length;
        for(int i=0;i<len;i++) {
            String[] equa = equations[i];
            if(!visited[i] && equa[0].equals(query[0])) {
                visited[i] = true;
                if(equa[1].equals(query[1])){
                    return values[i] * last;
                } else {

                    return dfs(equations, values, new String[]{equa[1], query[1]}, last * values[i]);
                }
            }
        }
        return -0.1;
    }

    public static void main(String[] args) {
        double[] doubles = new LC399().calcEquation(new String[][]{{"a", "b"}, {"b", "c"}}, new double[]{2.0, 3.0}, new String[][]{{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}});
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

//    public static void main(String[] args) {
//        Arrays.stream(new int[]{1,2,3}).map(i -> {
//            System.out.println(i);
//            return i * 2;
//        }).sum();
//    }
}
