package contest.d07112020;

import java.util.HashMap;
import java.util.Map;

public class Weekly {
    int cnt = 0;
    int mod = 1000000000 + 7;
    Map<Integer, Integer> map = new HashMap<>();
    public int numSub(String s) {
        dfs(s, 0, 0);
        return cnt;
    }

    public void dfs(String s, int idx, int c) {
        if(idx >= s.length()) return;
        if(s.charAt(idx) == '0' || idx == s.length() - 1) {
            if(idx == s.length() - 1 && s.charAt(idx) == '1') {
                c++;
            }
            if(map.containsKey(c)) {
                cnt += map.get(c);
            } else {
                int temp = 0;
                int cc = c;
                while(cc > 0) {
                    temp += cc--;
                }
                map.put(c, temp);
                cnt += temp;
                cnt %= mod;
            }
            dfs(s, idx + 1, 0);
        } else {
            dfs(s, idx + 1, c + 1);
        }

    }

    public static void main(String[] args) {
        int i = new Weekly().numSub("10011");
        System.out.println(i);
    }
}
