package amazon;

public class LC441 {
    public int arrangeCoins(int n) {
        if(n == 0) return 0;
        int l = 1, r = n;
        while(l < r) {
            int m = r + (r-l)/2;
            if((1+m) * m / 2 <= n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r - 1;
    }
}
