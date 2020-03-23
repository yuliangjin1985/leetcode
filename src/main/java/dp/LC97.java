package dp;

public class LC97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1 + n2 != n3) return false;
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        for(int i=1;i<=n2;i++) {
            dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1) ? dp[0][i-1] : false;
        }
        for(int i=1;i<=n1;i++) {
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) ? dp[i-1][0] : false;
        }
        for(int i=1;i<=n1;i++) {
            for(int j=1;j<=n2;j++) {
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }
    public static void main(String[] args) {
        LC97 lc97 = new LC97();
        System.out.println(lc97.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(lc97.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
