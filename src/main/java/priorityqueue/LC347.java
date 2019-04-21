package priorityqueue;

import java.util.*;

public class LC347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for(int num : nums) {
            int count = counterMap.getOrDefault(num, 0);
            counterMap.put(num, count+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> counterMap.get(a)-counterMap.get(b));

        for(Integer key : counterMap.keySet()) {
            pq.offer(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> res = new LinkedList<>();
        int size = pq.size();
        for(int i=0;i< size;i++) {
            res.add(0, pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = new LC347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}