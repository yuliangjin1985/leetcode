package sort;

import java.util.Arrays;

/**
 * Use merge sort:
 *
 */

public class LC493 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int start, int end){
        if(start>=end) return 0;
        int mid = start + (end-start)/2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        for(int i = start, j = mid+1; i<=mid; i++){
            while(j<=end && nums[i]/2.0 > nums[j]) j++;
            count += j-(mid+1);
        }
        Arrays.sort(nums, start, end+1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
        System.out.println(5/2.0);
        System.out.println(5/3.0);
    }

}
