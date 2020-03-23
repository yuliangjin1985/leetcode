package segmenttree;

public class Test {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] biTree = new int[n*2];
        for(int i=0;i<n;i++) {
            biTree[i+n] = arr[i];
        }

        int cur = n-1;
        while(cur > 0) {
            biTree[cur] = biTree[cur<<1] ^ biTree[cur<<1|1];
            cur--;
        }

        int m = queries.length;
        int[] ret = new int[m];
        for(int i=0;i<m;i++) {
            ret[i] = get(biTree, queries[i][0], queries[i][1], n);
        }
        return ret;
    }

    public int get(int[] biTree, int s, int e, int n) {
        s += n;
        e += n;
        int ret = 0;
        while(e > s) {
            if((s&1) == 1) {
                ret ^= biTree[s];
                s++;
            }

            if((e&1) == 0) {
                ret ^= biTree[e];
                e--;
            }
            e>>=1;
            s>>=1;
        }


        return  e == s ? ret ^ biTree[e] : ret;
    }

    /**
     * [1,3,4,8]
     * [[0,1],[1,2],[0,3],[3,3]]
     * @param args
     */

    public static void main(String[] args) {
        Test test = new Test();
//        int[] ints = test.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{1, 2}});
        int[] ints = test.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
