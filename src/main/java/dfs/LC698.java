package dfs;

public class LC698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<len;i++) {
            sum += nums[i];
        }

        if(sum % k != 0) return false;
        int target = sum / k;

        boolean[] isDone = new boolean[len];

        for(int i=0;i<len;i++) {
            if(nums[i] > target) return false;
            if(!isDone[i]) {
                if(!dfs(nums, isDone, i, target)) return false;
            }
        }

        return true;
    }

    public boolean dfs(int[] nums, boolean[] isDone, int s, int target) {
        if(target == nums[s]) {
            isDone[s] = true;
            return true;
        }
        if(target < nums[s]) return false;
        int num = nums[s];
        for(int i = s + 1; i<nums.length;i++) {
            if(!isDone[i] && dfs(nums, isDone, i, target - num)) {
                isDone[s] = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean isSuccessful = new LC698().canPartitionKSubsets(new int[]{10,10,10,7,7,7,7,7,7,6,6,6}, 3);
        System.out.println(isSuccessful);
    }
}
