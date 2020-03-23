package map;

import java.util.PriorityQueue;

public class TrappingRainWater {
    public int trapRainWater(int[][] hm) {
        if(hm.length == 0) return 0;

        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][]  visited = new boolean[hm.length][hm[0].length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
        for(int i = 0; i < hm[0].length; i++) {
            pq.offer(new int[]{0, i, hm[0][i]});
            pq.offer(new int[]{hm.length - 1, i, hm[hm.length - 1][i]});
            visited[0][i] = true;
            visited[hm.length - 1][i] = true;
        }

        for(int i = 0; i < hm.length; i++) {
            pq.offer(new int[]{i, 0, hm[i][0]});
            pq.offer(new int[]{i, hm[0].length - 1, hm[i][hm[0].length - 1]});
            visited[i][0] = true;
            visited[i][hm[0].length - 1] = true;
        }

        int max = 0, ret = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            max = Math.max(max, node[2]);

            for(int[] step : steps) {
                int x = node[0] + step[0];
                int y = node[1] + step[1];

                if(x < 0 || x >= hm.length ||
                        y < 0 || y >= hm[0].length || visited[x][y]) continue;

                visited[x][y] = true;
                pq.offer(new int[]{x, y, hm[x][y]});

                if(hm[x][y] < max) ret += max - hm[x][y];
            }
        }

        return ret;
    }
}
