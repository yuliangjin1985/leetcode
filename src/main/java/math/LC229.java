package math;

import java.util.LinkedList;
import java.util.List;

public class LC229 {

    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        int candidate1 = nums[0], candidate2 = nums[1], count1 = 0, count2 = 0;

        for(int num : nums) {
            if(candidate1 == num) {
                count1++;
            } else if(candidate2 == num) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }

            if(num == candidate2) {
                count2++;
            }
        }

        LinkedList<Integer> integers = new LinkedList<>();
        if(count1 > (int)(nums.length / 3)) {
            integers.add(candidate1);
        }

        if(count2 > (int)(nums.length / 3)) {
            integers.add(candidate2);
        }

        return integers;
    }
}
