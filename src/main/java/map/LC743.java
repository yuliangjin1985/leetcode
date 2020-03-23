package map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC743 {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int[][] adj = new int[N+1][N+1];
        for(int[] time : times) {
            int a = time[0];
            int b = time[1];
            adj[a][b] = time[2];
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        dis[K] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1;i<=N;i++) {
                if(adj[cur][i] > 0 && i != cur) {
                    dis[i] = Math.min(dis[i], dis[cur] + adj[cur][i]);
                    q.offer(i);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<= N; i++) {
            max = Math.max(max, dis[i]);
        }

        return max != Integer.MAX_VALUE ? max : -1;
    }

    public static void main(String[] args) {
        LC743 lc743 = new LC743();
        int[][] times = new int[][] {{1,2,1},{2,1,3}};
        System.out.println(lc743.networkDelayTime(times, 2, 2));
    }
}
