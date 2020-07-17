package tech;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     *
     * The solution set must not contain duplicate triplets.
     */

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new LinkedList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for(int i=0;i + 2<n;i++) {
                if(i > 0 && nums[i] == nums[i-1]) continue;
                int cur = nums[i];
                int l = i + 1;
                int r = n - 1;
                while(l < r) {
                    if(nums[l] + nums[r] == - cur) {
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    } else if(nums[l] + nums[r] > - cur) {
                        r--;
                    } else {
                        l++;
                    }

                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SumIssues().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
