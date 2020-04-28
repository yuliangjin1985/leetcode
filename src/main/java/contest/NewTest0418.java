package contest;

import java.util.LinkedList;
import java.util.List;

public class NewTest0418 {
    public String reformat(String s) {
        List<Integer> nums = new LinkedList<>();
        List<Integer> letters = new LinkedList<>();
        int j = 0;
        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                letters.add(j++);
            } else {
                nums.add(j++);
            }
        }

        if(Math.abs(nums.size() - letters.size()) > 1) return "";
        String ret = "";
        int len = Math.min(nums.size(), letters.size());
        if(nums.size() > letters.size()) {
            for(int i=0;i<len;i++) {
                ret += ("" + s.charAt(nums.get(i)) + s.charAt(letters.get(i)));
            }
            ret += (s.charAt(nums.get(nums.size()-1)));
        } else {
            for(int i=0;i<len;i++) {
                ret += ("" + s.charAt(letters.get(i)) + s.charAt(nums.get(i)));
            }
            if(letters.size() > nums.size()) {

                ret += (s.charAt(letters.get(letters.size()-1)));
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        NewTest0418 newTest0418 = new NewTest0418();
        System.out.println(newTest0418.reformat("covid2019"));
    }
}
