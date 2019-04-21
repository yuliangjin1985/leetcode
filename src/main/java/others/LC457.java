package others;

public class LC457 {

    public boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) continue;
            int slow = i, fast = i, count = 0;
            boolean forward = nums[slow] > 0;
            do {
                int tempSlow = slow;
                slow = (slow + nums[slow] + n) % n;

                if(forward && nums[fast] < 0 || !forward && nums[fast] > 0) return false;
                fast = (fast + nums[fast] + n) % n;

                if(forward && nums[fast] < 0 || !forward && nums[fast] > 0) return false;
                fast = (fast + nums[fast] + n) % n;

                nums[tempSlow] = 0;
                count++;

            } while(slow != fast);

            if(count >= 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new LC457().circularArrayLoop(new int[]{-2, -3, -9});
        System.out.println(b);
    }
}
