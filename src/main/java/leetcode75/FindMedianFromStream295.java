package leetcode75;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromStream295 {
    /** initialize your data structure here. */
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    boolean even = true;
    public FindMedianFromStream295() {
    }

    public void addNum(int num) {
        if(even) {
            left.offer(num);
            right.offer(left.poll());
        } else {
            right.offer(num);
            left.offer(right.poll());
        }
        even = !even;

    }

    public double findMedian() {
        if(even) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek();
        }
    }
}
