package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Subsequence {
    /**
     * 题目 source string “abc” 用它的subsequences 是否可以组成 target string “abcab”; 答：yes； 解释：因为a,b,c,ab,ac,abc,bc
     * Follow up : 最少用几个subsequences 可以组成target string
     * 思路: 把targetstring(abcab) 中的字符在abc中能找到即可;
     *
     * 在数学中，某个序列的子序列是从最初序列通过去除某些元素但不破坏余下元素的相对位置（在前或在后）而形成的新序列。
     * @param source
     * @param target
     * @return
     */


    public int getMin(String source, String target) {
        HashMap<Character, List<Integer>> listHashMap = new HashMap<Character, List<Integer>>();

        int len = source.length();

        for(int i=0;i<len;i++) {
            listHashMap.putIfAbsent(source.charAt(i), new LinkedList<>());
            listHashMap.get(source.charAt(i)).add(i);
        }

        int num = 1;
        int pre = getMin(listHashMap.get(target.charAt(0)), 0);
        for(int i=1;i<target.length();i++) {
            int next = getMin(listHashMap.get(target.charAt(i)), pre);
            if(next != 0) {
                pre = next;
            } else {
                num++;
                pre = getMin(listHashMap.get(target.charAt(i)), 0);
            }
        }

        return num;
    }

    private int getMin(List<Integer> integers, int start) {

        if(start == 0) {
            return integers.get(0);
        } else {
            for(int i=0;i<integers.size();i++) {
                if(integers.get(i) >= start) return integers.get(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Subsequence().getMin("abc", "abca") == 2);
        System.out.println(new Subsequence().getMin("abc", "abcaa") == 3);
        System.out.println(new Subsequence().getMin("abcdda", "abcda") == 1);
        System.out.println(new Subsequence().getMin("abc", "aaaaabac") == 6);
        System.out.println(new Subsequence().getMin("abc", "abca") == 2);
        System.out.println(new Subsequence().getMin("abc", "abca") == 2);
    }


}
