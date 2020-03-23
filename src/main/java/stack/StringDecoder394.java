package stack;

import java.util.Stack;

public class StringDecoder394 {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> counters = new Stack<>();
        Stack<String> intermediate = new Stack<>();
        int cur = 0;
        while (cur < s.length()) {
            if (Character.isDigit(s.charAt(cur))) {
                int count = 0;
                while (Character.isDigit(s.charAt(cur))) {
                    count = 10 * count + (s.charAt(cur) - '0');
                    cur++;
                }
                counters.push(count);
            }
            else if (s.charAt(cur) == '[') {
                intermediate.push(res);
                res = "";
                cur++;
            }
            else if (s.charAt(cur) == ']') {
                StringBuilder temp = new StringBuilder (intermediate.pop());
                int repeatTimes = counters.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                cur++;
            }
            else {
                res += s.charAt(cur++);
            }
        }
        return res;
    }


}
