package daily;

import java.util.HashMap;
import java.util.Map;

public class LC914 {
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        System.out.println(LC914.gcd(2,0));
    }
}
