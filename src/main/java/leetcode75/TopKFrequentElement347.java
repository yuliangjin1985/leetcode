package leetcode75;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()) {
            pq.offer(key);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        int[] ret = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            ret[i++] = pq.poll();
        }
        return ret;
    }
}
