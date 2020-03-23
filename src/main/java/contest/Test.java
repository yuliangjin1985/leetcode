package contest;

import java.util.*;

public class Test {
    public static void main1(String[] args) {
        int[][] ints = {};
        Arrays.sort(ints, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else {
                return a[0] - b[0];
            }
        });
    }

    public boolean isBeautiful(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        for(int i=25;i>0;i--) {
            if(count[i] > count[i-1]) return false;
        }
        return true;
    }

    String[][] groupsOfAnagrams2(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for(char c : chars) {
                sb.append(c);
            }
            List<String> list = map.getOrDefault(sb.toString(), new LinkedList<>());
            list.add(word);
            map.put(sb.toString(), list);
        }
        int m = map.size();
        int n = 0;
        for(String key : map.keySet()) {
            n = Math.max(n, map.get(key).size());
        }
        String[][] ret = new String[m][n];
        int i = 0;
        for(String key : map.keySet()) {
            int cur = map.get(key).size();
            String[] temp = new String[cur];
            for(int j=0;j<cur;j++) {
                temp[j] = map.get(key).get(j);
            }
            ret[i++] = temp;
        }
        return ret;
    }

    public int countUniqueSumToK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums) {
            int target = k - num;
            if(target == num) {
                if(map.get(target) > 1) {
                    set.add(num + " " + num);
                }
            } else {
                if(map.containsKey(target)) {
                    int a = Math.min(target, num);
                    int b = Math.max(target, num);
                    set.add(a + " " + b);
                }
            }

        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Test().countUniqueSumToK(new int[]{2,3,6,2,8}, 8));
    }

    boolean validBracketSequence(String sequence) {
        Stack<Character> stack = new Stack<>();
        for(char c : sequence.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(c == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                }
                if(c == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                }
                if(c == '}') {
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                }
            }

        }

        return stack.isEmpty();
    }
}
