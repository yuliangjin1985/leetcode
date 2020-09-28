package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC743Djikstra {

    /**
     * There are N network nodes, labelled 1 to N.
     *
     * Given times, a list of travel times as directed edges times[i] = (u, v, w),
     * where u is the source node, v is the target node, and w is the time it takes for a
     * signal to travel from source to target.
     *
     * Now, we send a signal from a certain node K. How long will it take for all nodes to receive
     * the signal? If it is impossible, return -1.
     *
     * Note:
     *
     * N will be in the range [1, 100].
     * K will be in the range [1, N].
     * The length of times will be in the range [1, 6000].
     * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
     *
     *
     * @param times
     * @param N
     * @param K
     * @return
     */

    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times.length == 0) return -1;
        Map<Integer, HashMap<Integer, Integer>> path = new HashMap<>();
        for(int[] p : times) {
            path.putIfAbsent(p[0], new HashMap<>());
            HashMap<Integer, Integer> map = path.get(p[0]);

            if(!map.containsKey(p[1]) || p[2] < map.get(p[1])) {
                map.put(p[1], p[2]);
            }
        }

        Map<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(K, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {return i1[1] - i2[1];});
        pq.offer(new int[]{K, 0});
        int max = -1;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int distance = cur[1];

            if(distanceMap.containsKey(node) && distanceMap.get(node) < distance) {
                continue;
            }

            Map<Integer, Integer> sourceMap = path.get(node);
            if(sourceMap == null) continue;

            for(Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {
                int absoluteDistence = distance + entry.getValue();
                int targetNode = entry.getKey();
                if(distanceMap.containsKey(targetNode) && distanceMap.get(targetNode) <= absoluteDistence){
                    continue;
                }
                distanceMap.put(targetNode, absoluteDistence);

                pq.offer(new int[]{targetNode, absoluteDistence});
            }
        }

        for(int val : distanceMap.values()){
            if(val > max){
                max = val;
            }
        }
        return distanceMap.size() == N ? max : -1;
    }

    public static void main(String[] args) {
        int delayTime = new LC743Djikstra().networkDelayTime(new int[][]{{1, 3, 2}, {1, 2, 8}, {3, 2, 1}}, 3, 1);
        System.out.println(delayTime);
    }
}
