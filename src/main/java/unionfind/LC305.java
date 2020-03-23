package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC305 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] parent = new int[m*n], rank = new int[m*n];
        Arrays.fill(parent, -1);
        int numIslands = 0;

        for(int i = 0; i<positions.length; i++){
            int x = positions[i][0];
            int y = positions[i][1];
            int offset = x*n + y;
            if(parent[offset] >= 0) {
                ans.add(ans.get(ans.size()-1));
                continue;
            }
            parent[offset] = offset;
            numIslands++;

            if(x > 0 && parent[offset-n] >= 0 && union(parent, rank, offset, offset-n)){
                numIslands--;    //check the grid on top of current grid
            }
            if(x < m-1 && parent[offset+n] >= 0 && union(parent, rank, offset, offset+n) ){
                numIslands--; // check the grid below current grid
            }
            if(y > 0 && parent[offset-1] >= 0 && union(parent, rank, offset, offset-1) ){
                numIslands--; // check the grid to the left of the current grid
            }
            if(y < n-1 && parent[offset+1] >= 0 && union(parent, rank, offset, offset+1) ){
                numIslands--; // check the grid to the right of the current grid
            }
            ans.add(numIslands);
        }
        return ans;
    }

    private int find(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return find(parent, parent[x]);
    }

    private boolean union(int[] parent, int[] rank, int x, int y){
        int xparent = find(parent, x);
        int yparent = find(parent, y);
        if(xparent == yparent){
            return false;
        }
        if(rank[xparent] == rank[yparent]){
            parent[xparent] = yparent;
            rank[yparent]++;
        }
        else if(rank[xparent] < rank[yparent]){
            parent[xparent] = yparent;
        }
        else{
            parent[yparent] = xparent;
        }


        return true;
    }
}
