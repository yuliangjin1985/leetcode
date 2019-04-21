package priorityqueue;

import java.util.PriorityQueue;

public class LC703 {

    int k = 0;
    PriorityQueue<Integer> queue = null;

    public LC703(int k, int[] nums) {
        queue = new PriorityQueue<>();
        if(nums != null && nums.length > 0) {
            for(int n : nums) {
                queue.offer(n);
                if(queue.size() > k) {
                    queue.poll();
                }
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k) {
            queue.poll();
        }

        if(queue.size() == k) return queue.peek();
        return 0;
    }

    public static void main(String[] args) {
        LC703 lc703 = new LC703(1, new int[]{});
        System.out.println(lc703.add(-3));
    }
}
