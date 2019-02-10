package math;


public class LC991BrokenCalculator {


    /**
     *
     * On a broken calculator that has a number showing on its display, we can perform two operations:
     *
     * Double: Multiply the number on the display by 2, or;
     * Decrement: Subtract 1 from the number on the display.
     * Initially, the calculator is displaying the number X.
     *
     * Return the minimum number of operations needed to display the number Y.
     *
     */

    public static int brokenCalculator(int x, int y) {
        if(x >= y) return x - y;

        int count = 0;
        while(x < y) {
            y = y % 2 == 0 ? y / 2 : y + 1;
            count++;
        }

        return x - y + count;
    }


    public static void main(String[] args) {

    }

    /**
       Intuition:
       Considering how to change Y to X
       Operation 1: Y = Y / 2 if Y is even
       Operation 2: Y = Y + 1

       Explanation:
       Obviously,
       If Y <= X, we won't do Y / 2 anymore.
       We will increase Y until it equals to X

       So before that, while Y > X, we'll keep reducing Y, until it's smaller than X.
       If Y is odd, we can do only Y = Y + 1
       If Y is even, if we plus 1 to Y, then Y is odd, we need to plus another 1.
       And because (Y + 1 + 1) / 2 = (Y / 2) + 1, 3 operations are more than 2.
       We always choose Y / 2 if Y is even.

       Why it's right
       Actually, what we do is:
       If Y is even, Y = Y / 2
       If Y is odd, Y = (Y + 1) / 2

       We reduce Y with least possible operations, until it's smaller than X.

       And we know that, we won't do Y + 1 twice in a row.
       Becasue we will always end with an operation Y / 2.

       2N times Y + 1 and once Y / 2 needs 2N + 1 operations.
       Once Y / 2 first and N times Y + 1 will end up with same result, but needs only N + 1 operations.

       Time complexity
       We do Y/2 all the way until it's smaller than X,
       time complexity is O(log(Y-X)).
     */
}
