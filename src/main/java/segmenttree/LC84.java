package segmenttree;

public class LC84 {

    int[] tree = null;
    int n = 0;
    public int largestRectangleArea(int[] h) {
        n = h.length;
        tree = new int[n * 2];
        for(int i=0;i<n;i++) {
            tree[n+i] = i;
        }

        int j = n - 1;
        while(j > 0) {
            int c1 = j << 1;
            int c2 = j << 1 | 1;
            tree[j] = (h[tree[c1]] < h[tree[c2]]) ? tree[c1] : tree[c2];
            j--;
        }
        return largestRectangleArea(h, 0, n-1);
    }

    public int getMin(int l, int r, int[] h) {
        int a = l, b = r;
        if(l == r) return l;
        int min = l;
        l += n;
        r += n;
        while(l < r) {
            if((l & 1) == 1) {
                min = h[tree[l]] < h[tree[min]] ? tree[l] : min;
                l++;
            }

            if((r & 1) == 0) {
                min = h[tree[r]] < h[tree[min]] ? tree[r] : min;
                r--;
            }

            l >>= 1;
            r >>= 1;
        }
        min = h[tree[l]] < h[min] ? tree[l] : min;
        System.out.println("l: " + a + ", r: " + b + ", min: " + min);
        return min;
    }

    public int largestRectangleArea(int[] h, int l, int r) {
        if(l > r) return 0;
        if(l == r) return h[l];
        int id = getMin(l, r, h);
        return Math.max(h[id] * (r - l + 1), Math.max(largestRectangleArea(h, l, id-1), largestRectangleArea(h, id+1, r)));
    }

    public static void main(String[] args) {
        LC84 lc84 = new LC84();
        System.out.println(lc84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
