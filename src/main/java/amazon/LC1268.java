package amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC1268 {


    public List<List<String>> suggestedProducts(String[] ps, String searchWord) {
        Arrays.sort(ps);
        int n = searchWord.length();
        List<List<String>> ret = new LinkedList<>();
        for(int i=0;i<n;i++) {
            List<String> list = new LinkedList<>();
            String pre = searchWord.substring(0, i+1);
            int idx = get(ps, pre);
            if(idx == -1) {
                ret.add(list);
                continue;
            }
            for(int j=idx; j >= 0 && j<idx + 3 && j < ps.length; j++) {
                System.out.println(j);
                if(ps[j].startsWith(pre)) {
                    list.add(ps[j]);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    public int get(String[] ps, String pre) {
        int n = ps.length;
        int l = 0, r = n-1;
        while(l < r) {
            int m = l + (r-l)/2;
            if(ps[m].compareTo(pre) < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return ps[l].startsWith(pre) ? l : -1;
    }


}
