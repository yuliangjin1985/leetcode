package map;

import java.util.LinkedList;
import java.util.Queue;

public class LC994 {

    int m = 0;
    int n = 0;
    int[][] grid = null;
    boolean[][] visited = null;
    int[][] steps = new int[][]{{-1, 0}, {1,0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int good = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) good++;
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 1});
                    visited[i][j] = true;
                }
            }
        }

        if(good == 0) return 0;

        return bfs(queue, good);
    }

    private int bfs(Queue<int[]> queue, int good) {

        boolean isnotFinished = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int num = 0;
            while(size > 0) {
                int[] rotten = queue.poll();
                num = rotten[2];
                for(int[] step : steps) {
                    int x = rotten[0] + step[0];
                    int y = rotten[1] + step[1];
                    if(x >= 0 && x < m && y >= 0 && y < n) {
                        if(!visited[x][y]) {
                            visited[x][y] = true;
                            if(grid[x][y] == 1) {
                                good--;
                                isnotFinished = false;
                                grid[x][y] = 2;
                                queue.offer(new int[]{x, y, rotten[2]+1});
                            }
                        }
                    }
                }
                size--;
            }

            if(isnotFinished && good > 0) {
                return -1;
            }

            if(!isnotFinished && good == 0) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int orangesRotting = new LC994().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        int orangesRotting = new LC994().orangesRotting(new int[][]{{2,2,2,1,1}});
        System.out.println(orangesRotting);
    }

}
