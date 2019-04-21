package test;

public class Test1 {

    int getTotalWeight(String[] strings) {
        int total = 0;
        for(String s : strings) {
            total += getWeight(s);
        }
        return total;
    }

    private int getWeight(String s) {
        int n = 0;
        String[] split = s.split(" ");
        for (String s1 : split) {
            int sign = s1.charAt(0) == '+' ? 1 : -1;
            if(s1.indexOf("b") != -1) {
                n += sign * (Integer.valueOf(s1.substring(1, s1.indexOf('b'))))*(Integer.valueOf(s1.substring(s1.indexOf('b') + 1)));
            } else {
                n+= sign * Integer.valueOf(s.substring(1));
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Test1().getWeight("+6b25"));
        System.out.println(new Test1().getWeight("+50"));
        System.out.println(new Test1().getTotalWeight(new String[]{"\\+6b25 -30"}));
    }


}
