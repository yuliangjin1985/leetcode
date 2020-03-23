package contest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C134 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ret = new int[2];
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = (a != max && a != min) ? a : (b != max && b!= min ? b : c);
        ret[1] = max - mid - 1 + mid - min - 1;

        if(min + 1 == mid && mid + 1 == max) {
            ret[0] = 0;
        }

        else if(min + 2 == mid || mid + 2 == max || min + 1 == mid || mid + 1 == max) {
            ret[0] = 1;
        } else {
            ret[0] = 2;
        }
        return ret;
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int la = A.length;
        int lb = B.length;

       if(la > lb) {
           int[] temp = B;
           B = A;
           A = temp;
       }

       for(int i=0;i<B.length;i++) {

       }
        return 0;
    }

    public static void main(String[] args) {
        C134 c134 = new C134();
        c134.colorBorder(new int[][]{{1,1,1}, {1,1,1}, {1,1,1}}, 1,1,2);
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int[][] steps = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] blockgrid = new boolean[999999 + 1][999999 + 1];
        boolean[][] visited = new boolean[999999 + 1][999999 + 1];
        for(int[] block : blocked) {
            blockgrid[block[0]][block[1]] = true;
        }

        visited[source[0]][source[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0] == target[0] && poll[1]==target[1]) return true;
            for (int[] step : steps) {
                int a = poll[0] + step[0];
                int b = poll[1] + step[1];
                if(a >=0 && a <= 999999 && b >=0 && b <= 999999 && !visited[a][b] && !blockgrid[a][b] ) {
                    visited[a][b] = true;
                    queue.offer(new int[]{a, b});
                }
            }
        }
        return false;
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int[][] steps = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] ret = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        List<int[]> l = new LinkedList<>();
        l.add(new int[]{r0, c0});
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            l.add(poll);
            for (int[] step : steps) {
                int a = poll[0] + step[0];
                int b = poll[1] + step[1];
                if(a >=0 && a < m && b >=0 && b < n && !visited[a][b] && grid[a][b] == grid[r0][c0]) {
                    visited[a][b] = true;
                    queue.offer(new int[]{a, b});
                }
            }
        }

//        for(int[] step : steps)

        for (int[] ints : l) {
            if(ints[0] ==0 || ints[0] == m-1 || ints[1] == 0 || ints[1] == n-1) {
                grid[ints[0]][ints[1]] = color;
                continue;
            }
            for(int[] step : steps) {
                int a = ints[0] + step[0];
                int b = ints[1] + step[1];
                if(a >=0 && a < m && b >=0 && b < n && !visited[a][b]) {
                   grid[ints[0]][ints[1]] = color;
                   break;
                }
            }


        }

        return grid;
    }
}
