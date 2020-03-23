package basic;

import java.util.Stack;

public class MaxStack {
    int m = Integer.MIN_VALUE;
    Stack<Integer> s = new Stack<>();
    Stack<Integer> max = new Stack<>();

    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        s.push(x);
        max.push(Math.max(m, x));
        m = Math.max(m, x);
    }

    public int pop() {
        max.pop();
        return s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int m = max.peek();
        Stack<Integer> temp = new Stack<>();
        while(s.peek() != m) {
            temp.push(s.pop());
            max.pop();
        }

        s.pop();
        max.pop();
        if(!temp.isEmpty()) {
            int newMax = max.isEmpty() ? Integer.MIN_VALUE : max.peek();
            while(!temp.isEmpty()) {
                int cur = temp.pop();
                s.push(cur);
                newMax = Math.max(newMax, cur);
                max.push(newMax);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(-5);
        maxStack.popMax();
        maxStack.popMax();
        System.out.println(maxStack.top());
//        System.out.println(maxStack.peekMax());
//        System.out.println(maxStack.popMax());
    }
}
