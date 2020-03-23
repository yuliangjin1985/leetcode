package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC847ShortestPathVisitingAllNode {
    public int shortestPathLength(int[][] graph) {
        if(graph.length==1)
            return 0;
        int ansBit = (1 << graph.length) - 1;
        int [][] visitedMap = new int [graph.length][ansBit+1]; //[How many nodes][each node may have 2^n visited bit]
        Queue<int []> queue = new LinkedList<>();
        for(int i=0; i<graph.length; i++)
            queue.add(new int [] {i, 1 << i}); //Adding all nodes initially because we can start anywhere.
            //{0,0}, {1,10}, {2,100}, {3,1000}
        int len = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            len++;
            for(int i=0; i<size; i++){
                int [] state = queue.poll();
                int nodeId = state[0];
                int currentBits = state[1];
                for(int neighborId : graph[nodeId]){
                    int newBits = currentBits | (1 << neighborId);//Adding neighbor node to currentBits. Add 2^nodeId using bit OR.  001 | 010 --> 011. Visited node 0 and 1.
                    if(visitedMap[neighborId][newBits] == 1) //If the same node was visited again with same currentBits, it means this node doesn't
                        continue;//need to be visited again.  For example: 1->0->1->0.  First 1 we have {1, 10}, then we have {0, 11}, then we will have {1, 11}.
                    visitedMap[neighborId][newBits] = 1;//Lastly, we have {0, 11} which is a state we already had before. So we don't visit this again.
                    if(newBits==ansBit)
                        return len;
                    queue.add(new int [] {neighborId, newBits});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC847ShortestPathVisitingAllNode cur = new LC847ShortestPathVisitingAllNode();
        System.out.println(cur.shortestPathLength(new int[][]{{1,2,3}, {0}, {0}, {0}}));
    }
}
