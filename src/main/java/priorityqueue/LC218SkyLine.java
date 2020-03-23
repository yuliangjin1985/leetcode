package priorityqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC218SkyLine {
    public List<int[]> getSkyline(int[][] buildings) {
        LinkedList<int[]> list = new LinkedList<>();
        LinkedList<int[]> points = new LinkedList<>();
        for(int[] bd : buildings) {
            points.add(new int[]{bd[0], bd[2], 0});//Start point
            points.add(new int[]{bd[1], bd[2], 1});//End point
        }

        Collections.sort(points, (a, b) -> {
            if(a[2] == b[2] && a[2] == 0) {
                return b[1] - a[1];
            } else if(a[2] == b[2] && a[2] == 1) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        return list;
    }
}
