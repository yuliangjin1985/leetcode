package segmenttree;

public class NumMatrix {
    int m = 0;
    int n = 0;
    int[][] trees = null;

    public NumMatrix(int[][] matrix) {
        if(matrix == null) return;
        m = matrix.length;
        n = matrix[0].length;
        if(m == 0 || n == 0) return;
        trees = new int[m][n * 2];
        System.out.println(m);
        System.out.println(n);
        for(int i=0;i<m;i++) {
            init(trees[i], matrix[i]);
        }
    }

    public void update(int row, int col, int val) {
        update(trees[row], col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++) {
            sum += getSum(trees[i], col1, col2);
        }
        return sum;
    }

    public int getSum(int[] tree, int l, int r) {
        int sum = 0;
        l += n;
        r += n;
        while(l <= r) {
            if((l & 1) > 0) {
                sum += tree[l++];
            }

            if((r & 1) == 0) {
                sum += tree[r--];
            }

            l >>= 1;
            r >>= 1;
        }
        return sum;
    }

    public void init(int[] tree, int[] nums) {
        for(int i=0;i<n;i++) {
            tree[n + i] = nums[i];
        }

        int id = n - 1;
        while(id > 0) {
            tree[id] = tree[id<<1] + tree[id<<1|1];
            id--;
        }

    }

    public void update(int[] tree, int idx, int val) {
        tree[n + idx] = val;
        int j = (n + idx);
        while(j > 1) {
            tree[j>>1] = tree[j] + tree[j^1];
            j>>=1;
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[0][0]);
    }
}
