package binarytree;

import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    int[] a = {0,1,2,3,4,5,6,7,8};
    for (int i : Arrays.copyOfRange(a, 0, 5)) {
      System.out.println(i);
    }
  }
}
