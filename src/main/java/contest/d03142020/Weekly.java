package contest.d03142020;

import java.util.LinkedList;
import java.util.List;

public class Weekly {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}

class CustomStack {
    int size = 0;
    int max = 0;
    List<Integer> list = new LinkedList<>();
    public CustomStack(int maxSize) {
        if(size < maxSize) {
            max = maxSize;
        }
    }

    public void push(int x) {
        if(size < max) {
            size++;
            list.add(x);
        }
    }

    public int pop() {
        if(size == 0) return -1;
        int top = list.get(size-1);
        list.remove(size-1);
        size--;
        return top;
    }

    public void increment(int k, int val) {
        for(int i=0;i<Math.min(size, k);i++) {
            list.set(i, list.get(i) + val);
        }
    }
}
