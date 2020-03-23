package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1319 {

    public int makeConnected(int n, int[][] conn) {
        int m = conn.length;
        if(m + 1 < n) return -1;
        int[] parent = new int[n];

        for(int[] con : conn) {
            union(con[0], con[1], parent);
        }
        Set<Integer> set = new HashSet<Integer>();

        for(int i=0;i<n;i++) {
            set.add(parent[i]);
        }

        int count = set.size();
        return m >= count - 1 ? count - 1 : -1;
    }


    public int find(int num, int[] parent) {
        if(num == parent[num]) return num;
        parent[num] = find(parent[num], parent);
        return parent[num];
    }

    public void union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);
        if(pa != pb) {
           parent[pb] = pa;
        }
    }

    public void solution(int N) {
        // write your code in Java SE 8
        if(N % 2 == 0 && N % 3 == 0 && N % 5 == 0) {
            System.out.println("CodilityTestCoders");
        } else if( N % 2 == 0 && N % 3 == 0) {
            System.out.println("CodilityTest");
        } else if( N % 2 == 0 && N % 5 == 0) {
            System.out.println("CodilityCoders");
        } else if(N % 3 == 0 && N % 5 == 0) {
            System.out.println("TestCoders");
        } else if(N % 2 == 0) {
            System.out.println("Codility");
        } else if(N % 3 == 0) {
            System.out.println("Test");
        } else if(N % 5 == 0) {
            System.out.println("Coders");
        } else {
            System.out.println(N);
        }
    }

    public static void main(String[] args) {

        new LC1319().solution(1);
    }
}
