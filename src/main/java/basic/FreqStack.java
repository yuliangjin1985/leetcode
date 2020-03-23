package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {
    Stack<int[]> s = null;
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> max = new Stack<>();
    int c = 0;

    public FreqStack() {
        s = new Stack<>();
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        s.push(new int[]{x, map.get(x)});
        c = Math.max(c, map.get(x));
        max.push(c);
    }

    public int pop() {
        int cur = max.pop();
        Stack<int[]> temp = new Stack<>();
        while(!s.isEmpty() && s.peek()[1] < cur) {
            temp.push(s.pop());
        }

        int[] tar = s.pop();
        while(!temp.isEmpty()) {
            s.push(temp.pop());
        }

        if(tar[1] > 1) {
            map.put(tar[0], tar[1] - 1);
        } else {
            map.remove(tar[0]);
        }
        c = max.peek();
        return tar[0];
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
//        System.out.println(freqStack.c);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
