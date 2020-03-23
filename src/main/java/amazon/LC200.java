package amazon;

public class LC200 {
    int m = 0;
    int n = 0;

    int count = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        if(i>0) {
            dfs(grid, i-1, j);
        }
        if(i<m-1) {
            dfs(grid, i+1, j);
        }
        if(j>0) {
            dfs(grid, i, j-1);
        }
        if(j<n-1) {
            dfs(grid, i, j + 1);
        }
    }
}
