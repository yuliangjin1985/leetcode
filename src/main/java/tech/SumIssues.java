package tech;

import java.util.Arrays;

public class SumIssues {

    /**
     * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
     * For example, given nums = [-2, 0, 1, 3], and target = 2.
     * Return 2. Because there are two triplets which sums are less than 2:
     * @param nums
     * @param target
     * @return
     */

    //Why we can sort first? Cause 0 <= i < j < k < n means nothing but three different numbers from the array.
    //The logic to resolve this in O(n*n) is to find three numbers, after ordering, we choose the first two first, n1, n2, and then from the higher end of this array to find the
    // first one that make n1 + n2 + last number < target, so in between n2 and last number, all numbers with n1, n2 can make a valid triple.
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int ret = 0;
        for(int i=0;i<len-2;i++) {
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] < target) {
                    ret += k - j;
                    j++;// change the second number
                } else {
                    k--;//discard the largest, it's too big to make n1 + n2 + itself < target
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new SumIssues().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
