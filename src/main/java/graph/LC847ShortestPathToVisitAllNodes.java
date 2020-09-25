package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC847ShortestPathToVisitAllNodes {

    //Instead use Set<String> to check the existing path, we can use a boolean[s][1<<N] to store the existing path.
    //0, 1, 10, 11, 100, 101, 110, 111, 1000

    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][1 << N];
        for(int i=0;i<N;i++) {
            queue.add(new int[]{i, 1 << i});
            visited[i][1<<i] = true;
        }

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] cur = queue.poll();
                int id = cur[0];
                if(cur[1] == (1 << N) - 1) {
                    return level;
                }
                for(int next : graph[id]) {
                    int temp = cur[1] | (1 << next);
                    if(!visited[next][temp]) {
                        queue.offer(new int[]{next, temp});
                        visited[next][temp] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
