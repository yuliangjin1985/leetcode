package others;

import java.util.HashSet;
import java.util.Set;

public class LC1001 {

    //Could not create the 2D array. Because it will explode the memory, use parse
    //Set to store all the turned off lamp positions.


    /**
     * - 1 <= N <= 10^9
     * - 0 <= lamps.length <= 20000
     * - 0 <= queries.length <= 20000
     * - lamps[i].length == queries[i].length == 2
     *
     * @param N
     * @param lamps
     * @param queries
     * @return
     */

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] res = new int[queries.length];
        Set<Long> offSet = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];

            for (int j = 0; j < lamps.length; j++) {
                int id = lamps[j][0] * N + lamps[j][1];
                if (offSet.contains((long) id)) continue;
                if (x == lamps[j][0] || y == lamps[j][1] ||
                        x - lamps[j][0] == y - lamps[j][1] ||
                        x - lamps[j][0] == -y + lamps[j][1]) {
                    res[i] = 1;
                    break;
                }
            }
            offSet.add((long) x * N + y);
            offSet.add((long) (x) * N + (y - 1));
            offSet.add((long) (x) * N + (y + 1));
            offSet.add((long) (x - 1) * N + y);
            offSet.add((long) (x - 1) * N + (y - 1));
            offSet.add((long) (x - 1) * N + (y + 1));
            offSet.add((long) (x + 1) * N + (y - 1));
            offSet.add((long) (x + 1) * N + (y + 1));
            offSet.add((long) (x + 1) * N + (y));
        }
        return res;
    }
}
