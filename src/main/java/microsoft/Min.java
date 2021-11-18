package microsoft;

import java.util.Arrays;
import java.util.Collections;

//Min Steps to Make Piles Equal Height
//https://leetcode.com/discuss/interview-question/364618/
public class Min {
    //Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack. Determine the minimum number of steps required to make all of the piles equal in height.
    public static int step(Integer[] input){
        if(input == null || input.length == 0){
            return 0;
        }
        int steps = 0;
        Arrays.sort(input, Collections.reverseOrder());

        for( int i=1; i<input.length; i++){
            if(input[i] < input[i-1]){
                steps += i;
            }
        }
        return steps;
    }
}
