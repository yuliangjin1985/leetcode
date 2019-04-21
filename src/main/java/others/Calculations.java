package others;

import java.util.HashSet;
import java.util.Stack;

public class Calculations {

    /**
     * (* 1 2 3 (+ 1 2 3)) => 36
     * @param str
     * @return
     */

    int getResult(String str) {
        Stack<String> stack = new Stack<>();
        int len = str.length();
        for(int i=0;i<len;i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(String.valueOf(c));
            } else if(Character.isDigit(c)) {
                int start = i;
                while(i<len-1 && Character.isDigit(str.charAt(i+1))) {
                    i++;
                }
                stack.push(str.substring(start, i+1));
            } else if(c == ' ') {
                continue;
            } else {
                HashSet<Integer> integers = new HashSet<>();
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    String s = stack.pop();
                    if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                        if(!stack.isEmpty()) {
                            stack.pop();
                            stack.push(getValue(s, integers));
                            break;
                        }
                    } else {
                        integers.add(Integer.valueOf(s));
                    }
                }
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private String getValue(String s, HashSet<Integer> integers) {

        if(s.equals("+")) {
            int sum = 0;
            for (Integer integer : integers) {
                sum += integer;
            }
            return String.valueOf(sum);
        } else if(s.equals("-")) {
            int sum = 0;
            for (Integer integer : integers) {
                sum -= integer;
            }
            return String.valueOf(sum);
        } else if(s.equals("*")) {
            int sum = 1;
            for (Integer integer : integers) {
                sum *= integer;
            }
            return String.valueOf(sum);
        }else if(s.equals("/")) {
            int sum = 0;
            for (Integer integer : integers) {
                sum /= integer;
            }
            return String.valueOf(sum);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Calculations().getResult("(* 1 2 3 (+ 1 2 3) (- 19 8 1))"));
    }
}
