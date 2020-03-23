package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char c : tasks) {
            arr[c-'A']++;
        }

        int time = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i=0;i<26;i++) {
            if(arr[i] > 0) {
                queue.offer(new int[]{i, arr[i]});
            }
        }
        Map<Integer, Integer> coolDown = new HashMap<>();
        while(!queue.isEmpty() || !coolDown.isEmpty()) {
            if(coolDown.containsKey(time)) {
                int ready = coolDown.get(time);
                queue.offer(new int[]{ready, arr[ready]});
                coolDown.remove(time);
            }

            if(!queue.isEmpty()) {
                int[] cur = queue.poll();
                arr[cur[0]]--;
                if(arr[cur[0]] > 0) {
                    coolDown.put(time + n, cur[0]);
                }
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        LC621 lc621 = new LC621();
        System.out.println(lc621.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
