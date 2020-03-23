package segmenttree;

public class NumArray {

    int[] biTree = null;
    int N = 0;

    public NumArray(int[] nums) {
        int n = nums.length;
        biTree = new int[n * 2];
        N = n;
        for(int i=0;i<n;i++) {
            biTree[n+i] = nums[i];
        }
        for(int i=n-1;i>0;i--) {
            biTree[i] = biTree[i<<1] + biTree[i<<1|1];
        }
    }

    public void update(int i, int val) {
        biTree[N+i] = val;
        i = N + i;
        for(int j=i;j>1;j>>=1) {
            biTree[j>>1] = biTree[j] + biTree[j^1];
        }
    }

    public int sumRange(int i, int j) {
        int ret = 0;
        j += 1;
        for(i+=N, j+=N; i<j; i>>=1, j>>=1) {
            if ((i & 1) > 0)
                ret += biTree[i++];

            if ((j & 1) > 0)
            ret += biTree[--j];
        }
        return ret;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0,2));
        numArray.update(0, 5);
        System.out.println(numArray.sumRange(0,2));
    }

}
