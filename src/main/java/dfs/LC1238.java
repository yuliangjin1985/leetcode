package dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC1238 {

    int N = 0;
    public List<Integer> circularPermutation(int n, int start) {
        N = (int)Math.pow(2, n) - 1;
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        list.add(start);
        set.add(start);
        dfs(0, n, list, set, start, start);
        return list;
    }

    public boolean dfs(int id, int n, List<Integer> list, Set<Integer> set, int start, int cur) {
        if(id == N) {
            if(Integer.bitCount(start ^ cur) == 1) return true;
            return false;
        } else {
            for(int i=0;i<n;i++) {
                int next = cur ^ (1 << i);
                if(set.add(next)) {
                    list.add(next);

                    if(dfs(id + 1, n, list, set, start, next)) {
                        return true;
                    } else {
                        list.remove(list.size()-1);
                        set.remove(next);
                    }
                }
            }
        }

        return false;
    }

    //bit运算，
    // 求一个数的与其二进制表示只有一位不一样的数，实用异或。^
    // 求一个数的二进制表示有几个1，使用 Integer.bitCount(num)
}
