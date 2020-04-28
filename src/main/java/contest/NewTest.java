package contest;

public class NewTest {

    int N = 0;
    public int numTeams(int[] r) {
        dfs(r, -1, 3, true);
        dfs(r, -1, 3, false);
        return N;
    }

    public void dfs(int[] r, int cur, int left, boolean isInc) {
        if(left == 0) {
            N++;
            return;
        }
        if(cur == r.length - 1) return;
        for(int next = cur+1;next<r.length;next++) {
            if(cur >=0) {
                if(isInc && r[next] > r[cur]) {
                    dfs(r, next, left -1, isInc);
                } else if(!isInc && r[next] < r[cur]) {
                    dfs(r, next, left -1, isInc);
                }
            } else {
                dfs(r, next, left-1, isInc);
            }
        }
    }

    public static void main(String[] args) {
        NewTest newTest = new NewTest();
//        System.out.println(newTest.numTeams(new int[]{2,5,3,4,1}));
//        System.out.println(newTest.numTeams(new int[]{2,1,3}));
        System.out.println(newTest.numTeams(new int[]{1,2,3,4}));

    }
}
