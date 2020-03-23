package dfs;

public class LC576 {

    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = 1000000007;
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(N == 0) return 0;

        int num = 0;
        if(i-1<0) {
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i-1, j);
        }

        if(i+1>=m) {
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i+1, j);
        }

        if(j-1<0) {
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i, j-1);
        }

        if(i+1>=n) {
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i, j+1);
        }

        return num % MOD;
    }

    public static void main(String[] args) {
        LC576 lc576 = new LC576();
        System.out.println(lc576.findPaths(1,3,3,0,1));
    }
}
