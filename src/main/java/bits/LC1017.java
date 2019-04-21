package bits;

public class LC1017 {

    public String baseNeg2(int N) {
        String res = "";
        while (N != 0) {
            res = Integer.toString(N & 1) + res;
            N = -(N >> 1);
            System.out.println(N);
        }
        return res == ""  ? "0" : res;
    }

    public static void main(String[] args) {
        LC1017 lc1017 = new LC1017();
        System.out.println(lc1017.baseNeg2(40));
    }
}
