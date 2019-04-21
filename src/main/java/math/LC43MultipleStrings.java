package math;

public class LC43MultipleStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for(int i=len1-1;i>=0;i--) {
            for(int j=len2-1;j>=0;j--) {
                int multip = (num1.charAt(i)-'0') * (num2.charAt(j) -'0');
                int sum = multip + result[i+j+1];
                result[i+j] += sum / 10;
                result[i+j + 1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len1 + len2;i++) {
            sb.append(result[i]);
        }

        return sb.toString().charAt(0) == '0' ? sb.toString().substring(1) : sb.toString();

    }

    public static void main(String[] args) {
        String multiply = new LC43MultipleStrings().multiply("123", "456");
        System.out.println(multiply);
    }
}
