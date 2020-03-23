package amazon;

public class LC255 {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        return helper(preorder, 0, preorder.length - 1);

    }

    public boolean helper(int[] arr, int first, int end) {
        if (arr == null || end - first < 1) {
            return true;
        }
        int root = arr[first];
        int index = first + 1;
        while (index <= end && arr[index] < root) {
            index++;
        }
        int tmp = index;
        while (index <= end) {
            if (arr[index] < root) {
                return false;
            }
            index++;
        }
        boolean left = helper(arr, first + 1, tmp - 1);
        boolean right = helper(arr, tmp, end);
        return left && right;
    }
}
