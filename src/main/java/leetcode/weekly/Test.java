package leetcode.weekly;

public class Test {
    public int numRollsToTarget(int d, int f, int t) {
        int MOD = 1000000007;
        //dp[d][f][t]
        int[][] dp = new int[d+1][t+1];
        for(int i=1;i<=t;i++) {
            dp[1][i] = i <= f ? 1 : 0;
        }

        for(int i=2;i<=d;i++) {
            for(int j=1;j<=t;j++) {
                for(int k=1;k<=f;k++) {
                    dp[i][j] += j > k ? dp[i-1][j-k] : 0;
                    dp[i][j] %= MOD;
                }
            }
        }
        return dp[d][t];
    }

    public static void main(String[] args) {
        int i = new Test().numRollsToTarget(30, 30, 500);
        System.out.println(i);
    }
}
