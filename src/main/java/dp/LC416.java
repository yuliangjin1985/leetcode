package dp;

public class LC416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }

        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int cur : nums) {
            for(int i = target;i>0;i--) {
                dp[i] = (i >= cur ? dp[target-cur] : false) || dp[i];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
//        LC416 lc416 = new LC416();
//        System.out.println(lc416.canPartition(new int[]{1,2,5}));
        int n = Integer.MIN_VALUE;
        System.out.println(-n);
    }
}
