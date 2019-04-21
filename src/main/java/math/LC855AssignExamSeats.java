package math;

import java.util.LinkedList;
import java.util.List;

public class LC855AssignExamSeats {

    int n;
    List<Integer> seated = new LinkedList<>();

    public LC855AssignExamSeats(int N) {
        n = N;
    }

    public int seat() {
        if(seated.size() == 0) {
            seated.add(0);
            return 0;
        }

        int d = 0;
        int size = seated.size();

        if(seated.get(0) != 0) {
            d = Math.max(d, seated.get(0));
        }

        for(int i=0;i<size-1;i++) {
            d = Math.max(d, (seated.get(i+1) - seated.get(i)) / 2);
        }

        d = Math.max(d, n - 1 - seated.get(size-1));

        if(d == seated.get(0)) {
            seated.add(0, 0);
            return 0;
        }

        for(int i=0;i<size-1;i++) {
            if((seated.get(i+1) - seated.get(i)) / 2 == d) {
                seated.add(i+1, (seated.get(i+1) + seated.get(i))/2);
                return seated.get(i+1);
            }
        }

        seated.add(n-1);
        return n-1;

    }

    public void leave(int p) {
        for(int i=0;i<seated.size();i++) {
            if(seated.get(i) == p) {
                seated.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        LC855AssignExamSeats examSeats = new LC855AssignExamSeats(10);

        System.out.println(examSeats.seat());
        System.out.println(examSeats.seat());
        System.out.println(examSeats.seat());
        System.out.println(examSeats.seat());
        examSeats.leave(4);
        System.out.println(examSeats.seat());
    }

}
