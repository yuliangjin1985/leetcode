package array;

public class LC414 {
  public static int thirdMax(int[] nums) {
    int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=Integer.MIN_VALUE;
    boolean isMax3 = false;

    for(int i=0;i<nums.length;i++) {

      if(nums[i] == max1 || nums[i] == max2) {
        continue;
      }
      if(nums[i] > max1) {
        if(max3 != max2) {
          isMax3 = true;
        }
        max3 = max2;
        max2 = max1;
        max1 = nums[i];
      }  else if(nums[i] > max2) {
        if(max3 != max2) {
          isMax3 = true;
        }
        max3 = max2;
        max2 = nums[i];
      }  else if(nums[i] >= max3) {
        isMax3 = true;
        max3 = nums[i];
      }
    }


    // if(max3 > Integer.MIN_VALUE) return max3;
    // return max1;
    return isMax3 ? max3 : max1;
  }

  public static int thirdMax2(int[] nums) {
    Integer max1 = null;
    Integer max2 = null;
    Integer max3 = null;

    for(Integer num: nums) {
      if(num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;

      if(max1 == null || num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if(max2 == null || num > max2) {
        max3 = max2;
        max2 = num;
      } else if(max3 == null || num > max3) {
        max3 = num;
      }
    }

    return max3 == null ? max1 : max3;
  }

  public static void main(String[] args) {
//    int test = thirdMax(new int[] {1, 2, -2147483648});
    int test2 = thirdMax2(new int[] {5, 2, 2});
    System.out.println(test2);
  }
}
