package amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC1192 {
    private int h = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List[] adjList = new LinkedList[n];
        int[] height = new int[n];
        int[] low = new int[n];
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.fill(height, -1);
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
            if(height[i] == -1) {
                dfs(i, height, low, adjList, lists, i);
            }
        }
        return lists;
    }

    private void dfs(int u, int[] height, int[] low, List[] adjList, List<List<Integer>> lists, int parent) {
        h++;
        height[u] = h;
        low[u] = h;
        List<Integer> list = adjList[u];
        for(int v : list) {
            if(v == parent) continue;
            if(height[v] == -1) {
                dfs(v, height, low, adjList, lists, u);
                if(low[v] > height[u]) {
                    lists.add(Arrays.asList(u, v));
                }
            }

            low[u] = Math.min(low[u], low[v]);
        }
    }

    public static void main(String[] args) {
        LC1192 lc1192 = new LC1192();

        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        LinkedList<Integer> l4 = new LinkedList<>();
        l1.add(0);
        l1.add(1);
        l2.add(1);
        l2.add(2);
        l3.add(2);
        l3.add(0);
        l4.add(1);
        l4.add(3);
        list.add(l1);
        list.add(l2);
        //list.add(l3);
        list.add(l4);
        List<List<Integer>> lists = lc1192.criticalConnections(4, list);
        for (List<Integer> integers : lists) {
            System.out.println("This is a critical path from " + integers.get(0) + " to " + integers.get(1));
        }
    }
}
