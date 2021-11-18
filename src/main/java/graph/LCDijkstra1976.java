package graph;

import java.util.*;

public class LCDijkstra1976 {
    int MOD = (int)(1e9+7);
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(i, new LinkedList<>());
        }
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            map.get(u).add(new int[]{v, road[2]});
            map.get(v).add(new int[]{u, road[2]});
        }
        return getWays(0, n, map);
    }

    public int getWays(int start, int n, Map<Integer, List<int[]>> map) {
        int[] dp = new int[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dp[start] = 1;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{start, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0];
            int value = cur[1];
            if(dis[v] < value) continue;
            dis[v] = Math.min(dis[v], value);
            for(int[] next : map.get(v)) {
                if(dis[next[0]] > dis[v] + next[1]) {
                    dis[next[0]] = dis[v] + next[1];
                    dp[next[0]] = dp[v];
                    q.offer(new int[]{next[0], dis[next[0]]});
                } else if(dis[next[0]] == dis[v] + next[1]) {
                    dp[next[0]] = dp[next[0]] % MOD + dp[v] % MOD;
                }
            }
        }
        return dp[n-1] % MOD;
    }
}
