package daily;

public class LC365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if( x == z || y == z || x + y == z ) return true;
        return z % gcd(x, y) == 0;
    }

    public int gcd(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        LC365 lc365 = new LC365();
        System.out.println(lc365.getGCD(2, 4));
        System.out.println(lc365.getGCD(2, 5));
        System.out.println(lc365.getGCD(4, 2));
    }

    public int getGCD(int x, int y) {
        while(x != 0) {
            int t = x;
            x = y % x;
            y = t;
        }
        return y;
    }
}
