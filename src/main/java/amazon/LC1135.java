package amazon;

import java.util.Arrays;

/*
There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2together.
 (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects
 those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.

 Note:

1 <= N <= 10000
1 <= connections.length <= 10000
1 <= connections[i][0], connections[i][1] <= N
0 <= connections[i][2] <= 10^5
connections[i][0] != connections[i][1]
 */
public class LC1135 {
    int[] parent = null;
    int[] size = null;
    int N = 0;
    int linkNum = 0;
    public int minimumCost(int n, int[][] connections) {
        int cost = 0;
        N = n;
        parent = new int[N+1];
        size = new int[N+1];

        for(int i=0;i<=N;i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        for(int[] conn : connections) {
            int a = conn[0], b = conn[1], c = conn[2];
            if(linkNum == N-1) return cost;//To connect N nodes, at least N - 1 links needed
            if(find(a) != find(b)) {
                union(a, b);
                cost += c;
            }
        }
        return -1;
    }

    public int find(int a) {
        if(parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    public void union(int a, int b) {
        int i = find(a);
        int j = find(b);
        if(size[i] > size[j]) {
            parent[b] = find(a);
            size[i] += size[j];
        } else {
            parent[a] = find(b);
            size[j] += size[i];
        }
        linkNum++;
    }

    public static void main(String[] args) {
        System.out.println(new LC1135().minimumCost(3, new int[][]{{1,2,5},{1,3,6},{2,3,1}}));
        System.out.println(new LC1135().minimumCost(4, new int[][]{{1,2,3},{3,4,4}}));
    }

}
