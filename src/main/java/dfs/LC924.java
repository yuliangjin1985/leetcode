package dfs;

import java.util.Arrays;

public class LC924 {

    int N = 0;
    int[][] data = null;
    int[] color = null;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        N = graph.length;
        data = graph;
        color = new int[N];
        Arrays.sort(initial);
        int c = 1;
        for(int i=0;i<N;i++) {
            if(color[i] == 0) dfs(i, c++);
        }

        int[] count = new int[c];
        for(int i : initial) {
            int cur = color[i];
            count[cur]++;
        }

        int ans = Integer.MAX_VALUE;
        for(int i : initial) {
            if(count[color[i-1]] > 1) continue;
            if(ans == Integer.MAX_VALUE) {
                ans = i;
            } else if(count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans == Integer.MAX_VALUE ? initial[0] : ans;
    }

    public void dfs(int i, int c) {
        color[i] = c;
        for(int j=0;j<N;j++) {
            if(data[i][j] == 1 && color[j] == 0) dfs(j, c);
        }
    }

    /**
     * [[1,0,0,0],[0,1,1,0],[0,1,1,0],[0,0,0,1]]
     * [1,3]
     * @param args
     */

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,1}};
        int[] initial = new int[]{1,3};
        LC924 lc924 = new LC924();
        System.out.println(lc924.minMalwareSpread(graph, initial));
    }

}
