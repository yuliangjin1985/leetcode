package amazon;

import java.util.Arrays;
import java.util.Stack;

public class Test {

    public boolean parseBoolExpr(String e) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i=0;i<e.length();i++) {
            char c = e.charAt(i);
            if(c == '|' || c == '&' || c == '!') {
                s1.push(c);
            } else if(c == '(' || c == 't' || c == 'f') {
                s2.push(c);
            } else if(c == ',') {
                continue;
            } else if(c == ')') {
                calculate(s1, s2);
            }
        }

        if(!s1.isEmpty()) {
            return s2.peek() == 't' ? false : true;
        } else {
            return s2.peek() == 't' ? true : false;
        }
    }

    public void calculate(Stack<Character> s1, Stack<Character> s2) {
        char c1 = s1.pop();
        boolean ret = c1 == '&' ? true : false;
        while(s2.peek() != '(') {
            char c2 = s2.pop();
            if(c1 == '|') {
                ret = ret || (c2 == 't' ? true : false);
            } else if(c1 == '&') {
                ret = ret && (c2 == 't' ? true : false);
            } else if(c1 == '!') {
                ret = c2 == 't' ? false : true;
            }
        }

        s2.pop();
        s2.push( ret ? 't' : 'f');
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.minMeetingRooms(new int[][]{{2,15},{36,45},{9,29},{16,23},{4,9}}));
    }

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        boolean[] done = new boolean[n];
        Arrays.fill(done, false);
        int cnt = 0;
        int room = 0;
        while(cnt < n) {
            System.out.println(cnt);
            int end = 0;
            for(int i=0;i<n;i++) {
                if(done[i]) continue;
                if(end == 0) {
                    cnt++;
                    done[i] = true;
                    end = intervals[i][1];
                    room++;
                } else {
                    if(intervals[i][0] >= end) {
                        cnt++;
                        done[i] = true;
                        end = intervals[i][1];
                    }
                }
            }
        }
        return room;
    }
}
