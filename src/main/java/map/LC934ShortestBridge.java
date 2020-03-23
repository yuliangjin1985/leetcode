package map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC934ShortestBridge {

    int[][] steps = new int[][]{{0,1}, {0,-1}, {-1,0}, {1, 0}};
    int m = 0;
    int n = 0;
    //union find
    public int shortestBridge(int[][] A) {
        m = A.length;
        n = A[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(A[i][j] == 1) {
                    //dfs
                    enqueue(A, q, visited, i, j);
                    //bfs
                    return flip(A, visited, q);
                }
            }
        }
        return 0;
    }

    public int flip(int[][] A, boolean[][] visited, Queue<int[]> q) {
        int num = 0;
        while(!q.isEmpty()) {
            int l = q.size();
            System.out.println("size: " + q.size());
            for(int i=0;i<l;i++) {
                int[] cur = q.poll();

                for(int[] s : steps) {
                    int x = cur[0] + s[0];
                    int y = cur[1] + s[1];
                    if(x>=0 && x < m && y >=0 && y<n && A[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = 1;
//                        System.out.println("queue size 0: " + q.size());
                        q.offer(new int[]{x, y});
//                        System.out.println("queue size 1: " + q.size());
                    } else if(x >=0 && x < m && y >=0 && y<n && A[x][y] == 1 && !visited[x][y]) {
                        return num;
                    }
                }
            }

            num++;
        }

        return num;

    }

    public void enqueue(int[][] A, Queue<int[]> q, boolean[][] visited, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        visited[i][j] = true;
        stack.push(new int[]{i, j});
        q.offer(new int[]{i, j});
        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            for(int[] step : steps) {
                int x = cur[0] + step[0];
                int y = cur[1] + step[1];
                if(x >=0 && x < m && y >=0 && y<n && A[x][y] == 1 && !visited[x][y]) {
                    q.offer(new int[]{x, y});
                    stack.push(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        System.out.println("Queus init size: " + q.size());

    }

    //[[0,1,0],[0,0,0],[0,0,1]]
    public static void main(String[] args) {
        LC934ShortestBridge lc934ShortestBridge = new LC934ShortestBridge();
        System.out.println(lc934ShortestBridge.shortestBridge(new int[][]{{0,1,0}, {0,0,0}, {0,0,1}}));
    }

}
