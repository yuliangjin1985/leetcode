package binarytree;

public class LC927 {

    /**
     * For example, [1,1,0] represents 6 in decimal, not 3.  Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
     * Tailing zeros have to be the part of the binary tree.
     * @param ints
     * @return
     */

    public int[] threeEqualParts(int[] ints) {
        int ones = 0;
        int len = ints.length;
        for (int i = 0; i < len; i++)
            ones += ints[i];

        if (ones == 0)
            return new int[]{0, len-1};

        if (ones % 3 != 0)
            return new int[]{-1,-1};

        int k = ones / 3;

        int i;
        //Found the start of the first sub array.
        for (i = 0; i < len; i++)
            if (ints[i] == 1) break;
        int first = i;

        //Find the start of the second sub array.
        int second = 0;
        for (i = 0; i < len; i++){
            second += ints[i];
            if (second == k+1) break;
        }
        second = i;

        //Find the start of the third sub array.
        int third = 0;
        for (i = 0; i < ints.length; i++){
            third += ints[i];
            if (third == 2*k+1) break;
        }
        third = i;

        //Now we have found the beginning of each interval, let's see if we have a match.
        while (third < len && ints[first] == ints[second] && ints[second] == ints[third]){
            first++;
            second++;
            third++;
        }

        if(third == len) return new int[]{first - 1, second};

        return new int[]{-1,-1};
    }

}
