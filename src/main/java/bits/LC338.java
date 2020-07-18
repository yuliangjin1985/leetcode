package bits;

public class LC338 {
    /**
     * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i=1;i<=num;i++) {
            ret[i] = ret[i>>1] + (i & 1);
        }
        return ret;
    }
}
