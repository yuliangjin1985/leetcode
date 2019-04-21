package basic;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(new int[]{2,4,9,10,20,23,33,56}, 0, 7, 56));
        System.out.println(new BinarySearch().binarySearch(new int[]{2,4,9,10,20,23,33,56}, 0, 7, 10));
    }

    public int binarySearch(int[] nums, int start, int end, int target) {

        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) {
            return binarySearch(nums, start, mid-1, target);
        } else {
            return binarySearch(nums, mid+1, end, target);
        }
    }
}
