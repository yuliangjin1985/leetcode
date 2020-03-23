package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] seen = new int[n];
        int[] low = new int[n];
        Arrays.fill(seen, -1);
        List<Integer>[] adjList = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int len = connections.size();
        for (int i = 0; i < len; i++) {
            int p = connections.get(i).get(0);
            int q = connections.get(i).get(1);
            adjList[p].add(q);
            adjList[q].add(p);
        }

        // not seen, dfs
        for (int i = 0; i < n; i++) {
            if (seen[i] == -1) {
                dfs(i, low, seen, adjList, res, 0);
            }
        }
        return res;
    }
    int time = 0;
    private void dfs(int u, int[] low, int[] seen, List<Integer>[] adjList, List<List<Integer>> res, int node) {
        seen[u] = low[u] = ++time;
        for (int j = 0; j < adjList[u].size(); j++) {
            int v = adjList[u].get(j);
            if (v == node) {
                continue;
            }
            if (seen[v] == -1) {
                dfs(v, low, seen, adjList, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > seen[u]) {
                    res.add(Arrays.asList(u, v));
                }
            }
            else {
                low[u] = Math.min(low[u], seen[v]);
            }
        }
    }
}
