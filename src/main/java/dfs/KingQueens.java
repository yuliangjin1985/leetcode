package dfs;

import java.util.*;

public class KingQueens {
    List<List<Integer>> list = new LinkedList<>();
    int[][] steps = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
    Set<Integer> qs = new HashSet<>();
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        for(int[] q : queens) {
            qs.add(q[0] * 8 + q[1]);
        }
        for(int[] step : steps) {
            dfs(king[0],king[1], step[0], step[1]);
        }
        return list;
    }

    public void dfs(int a, int b, int x, int y) {
        a += x;
        b += y;
        if(a < 0 || b < 0 || a >= 8 || b >= 8) return;
        if(qs.contains(a * 8 + b)) {
            LinkedList<Integer> integers = new LinkedList<>();
            integers.add(a);
            integers.add(b);
            list.add(integers);
            return;
        } else {
            dfs(a, b, x, y);
        }
    }

    public static void main(String[] args) {
        KingQueens kingQueens = new KingQueens();
        int[][] quenes = new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = new int[]{3,3};
        List<List<Integer>> lists = kingQueens.queensAttacktheKing(quenes, king);
        for (List<Integer> list : lists) {
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }
}
