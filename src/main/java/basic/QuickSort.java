package basic;

public class QuickSort {

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] nums, int l, int r) {
        if(r <= l) return;
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot - 1);
        quickSort(nums, pivot + 1, r);
    }

    //The purpose of this is to find a final index where on the left sides all numbers are smaller(or equal), on the right side all numbers are greater than pivot.
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        //poz is the position of current small num, why initialized to be l - 1? Cause [l, r], there might be no number smaller than pivot, so logic becomes to be: if a smaller was found
        //then increase the poz, and switch. And always process the pivot separately, it's a lot easier to understand.
        //Or set initialize the poz on the first element of the array. Both works.
        int poz = l;
        for(int j=l;j<r;j++) {
            if(nums[j] <= pivot) {
                int temp = nums[poz];
                nums[poz] = nums[j];
                nums[j] = temp;
                poz++;
            }
        }
        nums[r] = nums[poz];
        nums[poz] = pivot;
        return poz;
    }

    public static void main(String[] args) {
        int[] ints = {23, 9, 1, 0, -8, 33, 2, 9, 1, 2, 9};
        new QuickSort().quickSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
