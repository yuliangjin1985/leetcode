package dp;

import map.LC1013;

import java.util.HashMap;
import java.util.Map;

public class LC1027 {

    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>(); // <difference, <Index of Element for this difference, count of sequence>>
        int max = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i], b = A[j];
                Map<Integer, Integer> diffMap = dp.computeIfAbsent(b - a, c -> new HashMap<>());
                int currMax = Math.max(diffMap.getOrDefault(j, 0), diffMap.getOrDefault(i, 0) + 1); // if the element for the difference is i (variable a = A[i]), then we can add 1 to the count of sequence
                diffMap.put(j, currMax);
                max = Math.max(max, currMax + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC1027 lc1027 = new LC1027();
        System.out.println(lc1027.longestArithSeqLength(new int[]{5,
                78,
                45,
                27,
                75,
                10,
                90,
                77,
                60,
                8,
                43,
                5,
                55,
                47,
                57,
                17,
                8,
                63,
                18,
                69,
                63,
                87,
                35,
                19,
                78,
                42,
                25,
                27,
                24,
                23,
                88,
                56,
                14,
                42,
                16,
                64,
                8,
                62,
                48,
                76,
                66,
                75,
                59,
                43,
                16,
                11,
                15,
                41,
                20,
                34,
                69,
                69,
                58,
                42,
                22,
                27,
                79,
                81,
                63,
                59,
                57,
                51,
                11,
                48,
                89,
                29,
                30,
                79,
                40,
                87,
                17,
                24,
                16,
                82,
                18,
                9,
                86,
                9,
                90,
                74,
                17,
                21,
                8,
                18,
                24,
                62,
                8,
                31,
                84,
                56,
                70,
                59,
                55,
                22,
                44,
                31,
                11,
                82,
                80,
                38}));
    }
}
