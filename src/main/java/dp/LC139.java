package dp;

import java.util.Set;

public class LC139 {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    public boolean wordBreakNew(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return true;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                String temp = s.substring(j, i + 1);
                if(dict.contains(temp) && dp[j]) {
                    dp[i+1] = true;
                }
            }
        }
        return dp[n];
    }
}
