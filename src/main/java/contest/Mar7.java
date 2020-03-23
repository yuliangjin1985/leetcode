package contest;

import java.util.*;

public class Mar7 {
    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        int[] dp = new int[n];
        boolean flag = false;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        int num = 0;

        for(int cur : light) {
            if(cur == 1) {
                dp[0] = 2;
                if(!flag) {flag = true;}
                while(!q.isEmpty() && q.peek() == cur + 1) {
                    int next = q.poll();
                    dp[next-1] = 2;
                    cur = next;
                }
            } else {
                if(dp[cur-2] == 2) {
                    dp[cur-1] = 2;
                    if(!flag) {flag = true;}
                    while(!q.isEmpty() && q.peek() == cur + 1) {
                        int next = q.poll();
                        dp[next-1] = 2;
                        cur = next;
                    }
                } else {
                    dp[cur-1] = 1;
                    q.offer(cur);
                }
            }
            if(flag && q.isEmpty()) {
                num++;
            }
        }

        return num;

    }

    //[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]

    /*
            11
            4
            [5,9,6,10,-1,8,9,1,9,3,4]
            [0,213,0,253,686,170,975,0,261,309,337]
            2560
    */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            List<Integer> l = map.getOrDefault(manager[i], new LinkedList<>());
            l.add(i);
            map.put(manager[i], l);
        }

        int[] finalTime = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(headID);
        int time = 0;
        while(!q.isEmpty()) {
            int count = q.size();
            int temp = 0;
            while(count > 0) {
                count--;
                int cur = q.poll();
                List<Integer> sub = map.get(cur);
                if(sub == null) continue;
                for(int s : sub) {
                    q.offer(s);
                    finalTime[s] = finalTime[cur] + informTime[cur];
                    time = Math.max(time, finalTime[s]);
                }
            }
        }

        return time;


    }

    public static void main(String[] args) {
        Mar7 mar7 = new Mar7();
        System.out.println(mar7.numOfMinutes(11,4, new int[]{5,9,6,10,-1,8,9,1,9,3,4}, new int[]{0,213,0,253,686,170,975,0,261,309,337}));
    }
}
