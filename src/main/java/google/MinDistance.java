package google;

import java.util.LinkedList;
import java.util.Queue;

public class MinDistance {

    public static void main(String[] args) {
        char[][] chars1 = {
                {'X', 'Y', 'O'},
                {'X', 'Y', 'O'},
                {'X', 'Y', 'O'}};
        char[][] chars2 = {
                {'X', 'O', 'O'},
                {'X', 'O', 'O'},
                {'X', 'O', 'Y'}};
        char[][] chars3 = {
                {'X', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'Y'}};
        char[][] chars4 = {
                {'Y', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'X'}};
        System.out.println(new MinDistance().getMinDistance(chars1));
        System.out.println(new MinDistance().getMinDistance(chars2));
        System.out.println(new MinDistance().getMinDistance(chars3));
        System.out.println(new MinDistance().getMinDistance(chars4));
    }

    int[][] steps = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int m = 0;
    public int n = 0;

    int getMinDistance(char[][] inputs) {

        m = inputs.length;
        n = inputs[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(inputs[i][j] == 'X') {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        return bfs(inputs, queue, visited);
    }

    public int bfs(char[][] inputs, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if(inputs[node[0]][node[1]] == 'Y') return node[2];
            for(int[] step : steps) {
                int i = node[0] + step[0];
                int j = node[1] + step[1];
                if(i >= 0 && i<inputs.length && j >= 0 && j < inputs[0].length && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, node[2] + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
