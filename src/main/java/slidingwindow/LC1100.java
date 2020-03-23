package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC1100 {

    public int numKLenSubstrNoRepeats(String S, int K) {
        char[] cs = S.toCharArray();
        int n = cs.length;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int num = 0;
        for(int i=0;i<n && i - l < K;i++) {
            char cur = cs[i];
            if(map.containsKey(cur)) {
                int right = map.get(cur);
                for(int j = l;j<= right;j++) {
                    map.remove(cs[j]);
                }
                l = right + 1;
            }
            map.put(cur, i);
            if(i - l == K - 1) {
                num++;
                map.remove(cs[l]);
                l++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LC1100 lc1100 = new LC1100();
        System.out.println(lc1100.numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
}
