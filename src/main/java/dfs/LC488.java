package dfs;

public class LC488 {

    public int findMinStep(String board, String hand) {
        int[] balls = new int[26];
        for(int i=0;i<hand.length();i++) {
            balls[hand.charAt(i)-'A']++;
        }
        return dfs(board, balls);
    }

    private int dfs(String board, int[] balls) {
        if(board.length() == 0) return 0;
        int steps = Integer.MAX_VALUE;
        int i=0, j=0;
        while(i<board.length()) {
            while(j<board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            int need = 3 - (j - i);
            if(balls[board.charAt(i) - 'A'] >= need) {
                balls[board.charAt(i) - 'A'] -= need;
                //more could be -1, so will not update the total steps if next dfs return -1.
                int more = dfs(update(board.substring(0,i) + board.substring(j)), balls);
                if(more >= 0) {
                    steps = Math.min(steps, more + need);
                }
                balls[board.charAt(i) - 'A'] += need;
            }

            i = j;
        }
        return steps == Integer.MAX_VALUE ? -1 : steps;
    }

    /**
     * zuma clapse the initial string
     * @param str
     * @return
     */
    public String update(String str) {
        if(str.length() == 0) return str;
        int i=0;
        while(i < str.length()) {
            int j=i;
            while(j<str.length() && str.charAt(j) == str.charAt(i)) j++;
            if(j - i >=3) {
                str = str.substring(0, i) + str.substring(j);
                i=0;
            } else {
                i = j;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        try{
            System.out.println("Processing the try block.");
            throw new RuntimeException("Exception from try");
        } catch (RuntimeException e) {
            System.out.println("Processing...");
            throw new RuntimeException("Exception from catch block");
        } catch (Exception e) {
            System.out.println("Catch exception from previous catch block!");
        } finally {
            System.out.println("Finally block");
//            throw new RuntimeException("Exception from finally block");
        }
    }
}
