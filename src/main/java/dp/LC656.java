package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC656 {

    public List<Integer> cheapestJump(int[] A, int B) {
        int len = A.length;
        List<Integer>[] dp = new List[len+1];
        int[] cost = new int[len+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        dp[0] = new LinkedList<Integer>();
        List<Integer> first = new LinkedList<>();
        first.add(1);
        cost[1] = A[0];
        dp[1] = first;
        for(int i=2;i<=len;i++) {
            if(A[i-1] == -1) {
                dp[i] = null;
                continue;
            }

            for(int j=1;j<=B && i-j>0;j++) {
                int c = cost[i-j] + A[i-j];
                if(c < cost[i] && dp[i-j] != null || (c == cost[i] && dp[i-j] != null && dp[i-j].size() > dp[i].size())) {
                    cost[i] = c;
                    List<Integer> temp = new LinkedList<>();
                    if(dp[i-j] != null) {
                        for(int num : dp[i-j]) {
                            temp.add(num);
                        }
                    }
                    temp.add(i);
                    dp[i] = temp;
                }
            }

        }
        return dp[len] != null ? dp[len] : new LinkedList<>();
    }

    public static void main(String[] args) {
        LC656 lc656 = new LC656();
        int[] ints = {33, 90, 57, 39, 42, 45, 29, 90, 81, 87, 88, 37, 58, 97, 80, 2, 77, 64, 82, 41, 2, 33, 34, 95, 85, 77, 92, 3, 8, 15, 71, 84, 58, 65, 46, 48, 3, 74, 4, 83, 23, 12, 15, 77, 33, 65, 17, 86, 21, 62, 71, 55, 80, 63, 75, 55, 11, 34, -1, 64, 81, 18, 77, 82, 8, 12, 14, 6, 46, 39, 71, 14, 6, 46, 89, 37, 88, 70, 88, 33, 89, 92, 60, 0, 78, 10, 88, 99, 20};
        List<Integer> integers = lc656.cheapestJump(ints, 74);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
