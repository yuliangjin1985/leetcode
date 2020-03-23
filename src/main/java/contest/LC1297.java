package contest;

import java.util.HashMap;
import java.util.Map;

public class LC1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res=0, len=s.length();
        Map<String, Integer> m = new HashMap<>(); // substring -> count
        Integer b; // distinct letters
        for(int l=0; l<len-minSize+1; l++) {
            String sub=s.substring(l,l+minSize);
            b=0;
            for(char c:sub.toCharArray()) b |= 1 << c-'a';
            if(Integer.bitCount(b)>maxLetters) continue;

            // count matching substrings
            if(!m.containsKey(sub)){
                m.put(sub, 1);
                res = Math.max(res,1);
            }else{
                int cur = m.get(sub);
                m.put(sub, cur + 1);
                res = Math.max(res, cur+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(4));
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.bitCount(7));
    }
}
