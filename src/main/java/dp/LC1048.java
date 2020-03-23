package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1048 {
    Map<String, int[]> map = null;
    public int longestStrChain(String[] w) {
        Arrays.sort(w, (a, b) -> a.length() - b.length());
        map = new HashMap<>();
        for(String s : w) {
            if(map.get(s) == null) {
                int[] c = new int[26];
                for(char cr : s.toCharArray()) {
                    c[cr-'a']++;
                }
                map.put(s, c);
            }
        }

        int n = w.length;
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++) {
            dp[i+1] = 1;
            for(int j=0;j<i;j++) {
                if(isPre(w[j], w[i])) {
                    dp[i+1] = Math.max(dp[i+1], dp[j+1] + 1);
                }
            }
        }

        int max = 1;
        for(int i=1;i<=n;i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean isPre(String pre, String next) {
        if(pre.length() + 1 != next.length()) return false;
        int[] first = map.get(pre);
        int[] second = map.get(next);
        int cnt = 0;
        for(int i=0;i<26;i++) {
            if(second[i] != 0 && second[i] != first[i]) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        LC1048 lc1048 = new LC1048();
        System.out.println(lc1048.longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
//        System.out.println(lc1048.longestStrChain(new String[]{"abc", "aabc"}));
//        System.out.println(lc1048.longestStrChain(new String[]{"aabc", "aaebc"}));
//        System.out.println(lc1048.longestStrChain(new String[]{"caabc", "caaebc"}));
    }
}
