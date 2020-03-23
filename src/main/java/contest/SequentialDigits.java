package contest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        LinkedList<Integer> integers = new LinkedList<>();
        Set<Integer> set = new HashSet<Integer>();

        int first = low;
        while(first >= 10) {
            first /= 10;
        }

        int one = first;
        int num = first;
        int temp = 1;
        while(one < low && num < 8) {
            num++;
            one *= 10;
            temp *= 10;
            one += num;
        }

        int init = -1;
        if(one <= high) {
            System.out.println(one);
            System.out.println(temp);
            integers.add(one);
            set.add(one);
            init = one;
        }

        if(init != -1) {
            int next = getNext(init, temp);
            while(next <= high && next >= low && set.add(next)) {
                integers.add(next);
                next = getNext(next, temp);
                if(next == -1) break;
            }
        }

        int p = 1;
        while(p < low) {
            p *= 10;
        }


        int newLow = p;
        while(newLow > low &&  newLow <= high) {
            List<Integer> integers1 = sequentialDigits(newLow, high);
            for(int numm : integers1) {
                if(set.add(numm)) {
                    integers.add(numm);
                }
            }
            newLow *= 10;
        }


        p = 1;
        while( p <= high && ((long)p * 10) < Integer.MAX_VALUE) {
            p *= 10;
        }

        newLow = p / 10;
        if(newLow > low) {
            List<Integer> integers1 = sequentialDigits(newLow, high);
            for(int numm : integers1) {
                if(set.add(numm)) {
                    integers.add(numm);
                }
            }

        }


        return integers;
    }

    public int getNext(int init, int temp) {
        int last = init % 10;
        if(last == 9 || temp <= 0) return -1;
        int next = (init % temp) * 10 + (last + 1);
        return next;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        sequentialDigits.sequentialDigits(10, 1000000000);
    }
}
