package contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0;i<ranges.length;i++) {
            pq.offer(new int[]{ranges[i], i});
        }
        int[] num = new int[n+1];
        Arrays.fill(num, Integer.MAX_VALUE);
        int id = 0;
        for(int range : ranges) {
            if(range == 0) {
                id++;
                continue;
            }
            int left = Math.max(0, id - range);
            int right = Math.min(n, id + range);
            for(int j=left;j<=right;j++) {
                num[j] = Math.min(num[j], left == 0 ? 1 : num[left-1] + 1);
            }
            id++;
        }

        int max = 0;
        for(int i=0;i<=n;i++) {
            if(num[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, num[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MinTaps minTaps = new MinTaps();
//        System.out.println(minTaps.minTaps(5, new int[]{3,4,1,1,0,0}));
//        System.out.println(minTaps.minTaps(3, new int[]{0,0,0,0}));
//        System.out.println(minTaps.minTaps(7, new int[]{1,2,1,0,2,1,0,1}));
//        System.out.println(minTaps.minTaps(8, new int[]{4,0,0,0,0,0,0,0,4}));
//        System.out.println(minTaps.minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}));
        System.out.println(minTaps.minTaps(35, new int[]{1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2}));
    }
}
