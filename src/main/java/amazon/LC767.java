package amazon;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC767 {
    public String reorganizeString(String S) {
        int[] cs = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            cs[c-'a']++;
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Queue<int[]> temp = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0;i<26;i++) {
            if(cs[i] > 0) {
                q.offer(new int[]{i, cs[i]});
            }
        }
        int id = 0;
        while(!q.isEmpty() || !temp.isEmpty()) {
            if(!temp.isEmpty() ) {
                if(temp.peek()[2] == id) {
                    q.offer(temp.poll());
                } else if(q.isEmpty()) {
                    return "";
                }
            }
            if(!q.isEmpty()) {
                int[] cur = q.poll();
                sb.append((char)(cur[0] + 'a'));
                if(cur[1] > 1) {
                    temp.offer(new int[]{cur[0], cur[1]-1, id + 2});
                }
            }
            id++;
        }
        return sb.toString();
    }

    public String reorganizeStringNew(String S) {
        int[] cs = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            cs[c-'a']++;
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Queue<int[]> temp = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0;i<26;i++) {
            if(cs[i] > 0) {
                q.offer(new int[]{i, cs[i], 0});
            }
        }
        int id = 0;
        while(!q.isEmpty() || !temp.isEmpty()) {
            if(!temp.isEmpty()) {
                if(temp.peek()[2] == id) {
                    q.offer(temp.poll());
                } else if(q.isEmpty()) {
                    return "";
                }
            }
            if(!q.isEmpty()) {
                int[] cur = q.poll();
                sb.append((char)(cur[0] + 'a'));
                if(cur[1] > 1) {
                    temp.offer(new int[]{cur[0], cur[1]-1, id+2});
                }
            }
            id++;
        }
        return sb.toString();
    }
}
