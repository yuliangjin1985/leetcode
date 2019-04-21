package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC388 {

//    public int lengthLongestPath(String input) {
//        List<String> list = new LinkedList<>();
//        String[] split = input.split("\n");
//        for(String s : split) {
//            if(s.indexOf('.') != 0) {
//                list.add(s);
//            }
//        }
//
//        int count = 0;
//
//        for(int i=0;i<list.size();i++) {
//            String temp = list.get(i);
////            int n = 0;
////            for(int j=0;j<temp.length();j++) {
////                if(temp.charAt(j) == '\t') {
////                    n++;
////                }
////            }
//            count = Math.max(temp.length(), count);
//        }
//
//        return count;
//    }

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int i = new LC388().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        System.out.println(i);
    }
}
