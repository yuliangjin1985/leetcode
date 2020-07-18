package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC424 {

    /**
     * 不太懂，还有疑问。。。
     * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
     *
     * In one operation, you can choose any character of the string and change it to any other uppercase English character.
     *
     * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
     *
     * Note:
     * Both the string's length and k will not exceed (int)Math.pow(10,4).
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int i=0;
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
