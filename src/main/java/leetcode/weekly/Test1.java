package leetcode.weekly;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    int m = 0;
    int n = 0;
    int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int maxDistance(int[][] g) {
        m = g.length;
        n = g[0].length;
        int max = -1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(g[i][j] == 0) {
                    System.out.println(i);
                    System.out.println(j);
                    int cur = bfs(g, i, j);
                    if(cur > max) {
                        max = cur;
                    }
                }
            }
        }
        return max;
    }

    public int bfs(int[][] g, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()) {
            int n = q.size();
            for(int l=0;l<n;l++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                if(x>=0 && x<m && y>=0 && y<n) {
                    if(g[x][y] == 1) {

                        // System.out.println(x);
                        // System.out.println(y);
                        return Math.abs(x - i) + Math.abs(y - j);
                    } else {
                        for(int[] step : steps) {
                            int p = step[0] + x;
                            int r = step[1] + y;
                            q.offer(new int[]{p, r});
                        }
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(new Test1().maxDistance(input));
    }
}
