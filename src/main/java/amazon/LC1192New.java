package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC1192New {
    private int depth = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //disc[i] is the node's depth in a DFS tree
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        //low[i] is the node's all reachable node's smallest depth in a DFS tree
        int[] low = new int[n];
        //Create the graph;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        //Create the result;
        List<List<Integer>> result = new ArrayList<>();
        //DFS for each node
        for (int i = 0; i < n; i++) {
            if(disc[i] == -1) {
                dfs(i, disc, low, graph, result, i);
            }
        }
        return result;
    }
    private void dfs(int u, int[] disc, int[] low, List<Integer>[] graph, List<List<Integer>> result, int parent) {
        depth++;
        disc[u] = depth;
        low[u] = depth;
        List<Integer> children = graph[u];
        for (int v : children) {
            if (v == parent) {
                continue;
            } else {
                if (disc[v] == -1) {
                    dfs(v, disc, low, graph, result, u);
                    low[u] = Math.min(low[u], low[v]);

                    if (low[v] > disc[u]) {
                        result.add(Arrays.asList(u, v));
                    }
                } else {
                    low[u] = Math.min(low[u], low[v]);
                }
            }
        }
    }

    private void dfsNew(int u, int[] arr, int[] low, List[] adjList, List<List<Integer>> lists, int parent) {
        h++;
        arr[u] = h;
        low[u] = h;
        List<Integer> list = adjList[u];
        for(int v : list) {
            if(v == parent) continue;
            if(arr[v] == -1) {
                dfsNew(v, arr, low, adjList, lists, u);
                low[u] = Math.min(low[u], low[v]);
                if(low[v] > arr[u]) {
                    lists.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }

    int h = 0;
    public List<List<Integer>> cc(int n, List<List<Integer>> connections) {
        List[] adjList = new LinkedList[n];
        int[] arr = new int[n];
        int[] low = new int[n];
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.fill(arr, -1);
        for(int i=0;i<n;i++) {
            adjList[i] = new LinkedList<Integer>();
        }
        for(List<Integer> edge : connections) {
            int p = edge.get(0);
            int q = edge.get(1);
            adjList[p].add(q);
            adjList[q].add(p);
        }

        for(int i=0;i<n;i++) {
            if(arr[i] == -1) {
                dfsNew(i, arr, low, adjList, lists, i);
            }
        }
        return lists;
    }




}
