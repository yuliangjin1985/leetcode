package array;

public class OneEditDistance {

  public static boolean isOneEditDistance(String s, String t) {
    int lenS = s.length(), lenT = t.length();

    if(Math.abs(lenS - lenT) >= 2) return false;

    for(int i=0; i<Math.min(lenS, lenT); i++) {
      if(s.charAt(i) != t.charAt(i)) {
        if(lenS == lenT) return s.substring(i+1).equals(t.substring(i+1));
        else if(lenS < lenT) return s.substring(i).equals(t.substring(i+1));
        else return s.substring(i + 1).equals(t.substring(i));
      }
    }
    return Math.abs(lenS - lenT) == 1;
  }

  public static void main(String[] args) {
    System.out.println(isOneEditDistance("helo", "heloe"));
    System.out.println(isOneEditDistance("helo", "hloe"));
    System.out.println(isOneEditDistance("helo", "hplo"));
    System.out.println(isOneEditDistance("hplop", "hplo"));
    System.out.println(isOneEditDistance("hplop", "hplopd"));
    System.out.println(isOneEditDistance("hplop", "haplop"));
  }
}
