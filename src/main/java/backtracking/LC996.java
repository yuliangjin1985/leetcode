package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC996 {

    public int numSquarefulPerms(int[] A) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(A);
        bt(list, new LinkedList<>(), A, new boolean[A.length]);
        return list.size();
    }

    public void bt(List<List<Integer>> list, LinkedList<Integer> temp, int[] A, boolean[] visited) {
        if(temp.size() == A.length) list.add(new LinkedList<>(temp));

        for(int start =0;start<A.length;start++) {

            if(visited[start]) continue;

            if(start > 0 && A[start] == A[start-1] && !visited[start-1]) continue;


            if(temp.size() > 0) {
                int pre = temp.get(temp.size()-1);
                if(isPerfectSquare((double) pre + A[start])) {
                    visited[start] = true;
                    temp.add(A[start]);
                    bt(list, temp, A, visited);
                    visited[start] = false;
                    temp.remove(temp.size()-1);
                }

            } else {
                visited[start] = true;
                temp.add(A[start]);
                bt(list, temp, A, visited);
                visited[start] = false;
                temp.remove(temp.size()-1);
            }

        }
    }

    boolean isPerfectSquare(double x) {

        double sr = Math.sqrt(x);
        return ((sr - Math.floor(sr)) == 0);
    }

    public static void main(String[] args) {
        int i = new LC996().numSquarefulPerms(new int[]{2, 2, 2});
        System.out.println(i);
    }

}
