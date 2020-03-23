package amazon;

import java.util.LinkedList;
import java.util.List;

public class LC17 {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> lists = new LinkedList<>();
        int n = digits.length();
        dfs("", 0, lists, n, digits);
        return lists;

    }

    private void dfs(String pre, int i, List<String> lists, int size, String digits) {
        if(i == size) {
            lists.add(pre);
            return;
        }

        int num = digits.charAt(i) - '0';
        for(char c : KEYS[num].toCharArray()) {
            dfs(pre + c, i+1, lists, size, digits);
        }
    }

    public void dfs(String pre, int idx, int len, List<String> list, String digits) {
        if(idx == len) {
            list.add(pre);
            return;
        }

        String str = KEYS[digits.charAt(idx)-'0'];
        for(int i=0;i<str.length();i++) {
            dfs(pre + str.charAt(i), idx + 1, len, list, digits);
        }
    }
}
