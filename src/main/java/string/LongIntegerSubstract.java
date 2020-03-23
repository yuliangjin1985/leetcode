package string;

public class LongIntegerSubstract {

    String sub(String s1, String s2) {
        int carry = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int i1 = len1 - 1, i2 = len2 - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while(i1 >=0 && i2 >= 0) {
            char a = s1.charAt(i1);
            if(a - '0' + carry > 0) {
                stringBuilder.append(a - '0' + carry - (s2.charAt(i2) - '0'));
                carry = 0;
            } else if(a - '0' + carry == 0) {
                if(s2.charAt(i2)-'0' == 0) {
                    stringBuilder.append("0");
                    carry = 0;
                } else {
                    stringBuilder.append(a - '0' + carry + 10 - (s2.charAt(i2) - '0'));
                    carry = -1;
                }
            } else {
                stringBuilder.append(a - '0' + carry + 10 - (s2.charAt(i2) - '0'));
                carry = -1;
            }
            i1--;
            i2--;
        }

        while(i1 >= 0) {
            if(s1.charAt(i1--)-'0' + carry < 0) {
                stringBuilder.append("9");
                carry = -1;
            }
        }
        int start = 0;

        String s = stringBuilder.reverse().toString();
        while(start <s.length() && s.charAt(start) == '0') {
            start++;
        }

        String substring = s.substring(start);
        if(substring == null || substring.length() == 0) return "0";
        return substring;
    }

    public static void main(String[] args) {
        LongIntegerSubstract longIntegerSubstract = new LongIntegerSubstract();
        System.out.println(longIntegerSubstract.sub("100", "100"));
        System.out.println(longIntegerSubstract.sub("100", "89"));
    }
}
