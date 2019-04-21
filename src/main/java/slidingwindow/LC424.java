package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC424 {

    /**
     * 不太懂，还有疑问。。。
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int i=0;
        int K = k + 1;
        int max = 0;
        int currentMaxCount = 0;
        int[] count = new int[26];
        for(int j=0;j<s.length();j++) {
            currentMaxCount = Math.max(currentMaxCount, ++count[s.charAt(j)-'A']);
            while(j - i + 1 - currentMaxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

            max = Math.max(max, j-i+1);
        }

        return max;
    }

    public static void main(String[] args) {
        LC424 lc424 = new LC424();
        System.out.println(lc424.characterReplacement("AABABBACCCCCCCCC", 1));
    }
}
