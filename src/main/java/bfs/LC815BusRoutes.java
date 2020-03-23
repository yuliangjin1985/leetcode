package bfs;

import java.util.*;

public class LC815BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        HashMap<Integer, HashSet<Integer>> toRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                if (!toRoutes.containsKey(j))
                    toRoutes.put(j, new HashSet<Integer>());
                toRoutes.get(j).add(i);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {S, 0});
        HashSet<Integer> seen = new HashSet<>();
        seen.add(S);
        boolean[] seen_routes = new boolean[n];
        while (!queue.isEmpty()) {
            int stop = queue.peek()[0], bus = queue.peek()[1];
            queue.poll();
            if (stop == T) return bus;
            for (int i : toRoutes.get(stop)) {
                if (seen_routes[i]) continue;
                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        queue.offer(new int[] {j, bus + 1});
                    }
                }
                seen_routes[i] = true;
            }
        }
        return -1;
    }
}
