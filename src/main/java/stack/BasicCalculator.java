package stack;

import java.util.Map;
import java.util.Stack;
import java.util.function.DoubleToLongFunction;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Long> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(c == '(' || c == '+' || c == '-') {
                op.push(c);
            } else if(c == ')') {
                long temp = num.pop();
                while(op.peek() != '(') {
                    long next = num.pop();
                    temp = (op.pop() == '+' ? (temp) : (-temp)) + next;
                }
                num.push(temp);
                op.pop();
            } else {
                long n = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    n *= 10;
                    n += c - '0';
                    i++;
                }
                i--;
                long next = 0;
                if(!op.isEmpty() && op.peek() != '(') {
                    next = num.pop();
                    n = next + (op.pop() == '+' ? n : -n);
                }
                num.push(n);
            }
        }

        long cur = num.pop();
        while(!op.isEmpty()) {
            long next = num.pop();
            cur = next + (op.pop() == '+' ? cur : -cur);
        }
        return (int)cur;
    }


}
