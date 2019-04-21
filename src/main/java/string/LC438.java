package string;

import bfs.LC417;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC438 {

    public List<Integer> findAnagramsOld(String s, String p) {

        List<Integer> list = new LinkedList<>();

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start=0, end = 0;
        int count = map.size();

        while(end < s.length()) {
            if(map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end))-1);
                if(map.get(s.charAt(end)) == 0) {
                    count--;
                }
            }
            end++;

            while(count == 0) {
                if(end - start == p.length()) {
                    list.add(start);
                }
                char first = s.charAt(start);
                if(map.containsKey(first)) {
                    map.put(first, map.get(first) + 1);
                    if(map.get(first) > 0) {
                        count++;
                    }
                }

                start++;

            }
        }

        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        int[] arr = new int[26];
        for(int i=0;i<p.length();i++) {
            arr[p.charAt(i) - 'a']++;
        }

        int[] temp = new int[26];

        for(int i=0;i<s.length();i++) {
            temp[s.charAt(i)-'a']++;
            if(i>=p.length()) {
                temp[s.charAt(i-p.length())-'a']--;
            }

            if(isEqual(arr, temp)) {
                list.add(i-p.length()+1);
            }
        }
        return list;
    }

    boolean isEqual(int[] arr1, int[] arr2) {
        int len = arr1.length;
        for(int i=0;i<len;i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC438 lc438 = new LC438();

        System.out.println(lc438.findAnagrams("cbaebabacd", "abc"));
    }
}
