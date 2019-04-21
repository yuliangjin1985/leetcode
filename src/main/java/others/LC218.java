package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class LC218 {

    public static void main(String[] args) {
        System.out.println('!' - '=');
    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];

        int index = 0;
        for (int[] building : buildings) {
            buildingPoints[index] = new BuildingPoint(building[0], true, building[2]);
            buildingPoints[index+1] = new BuildingPoint(building[1], false, building[2]);
            index += 2;
        }

        Arrays.sort(buildingPoints);

        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(0, 1);
        int preMaxHeight = 0;
        List<int[]> list = new ArrayList<>();

        for (BuildingPoint buildingPoint : buildingPoints) {
            if(buildingPoint.isStart) {
                treeMap.compute(buildingPoint.height, (k, v) -> {
                    if(v != null) {
                        return v + 1;
                    }
                    return 1;
                });
            } else {
                treeMap.compute(buildingPoint.height, (k, v) -> {
                    if(v == 1) {
                        return null;
                    }

                    return v - 1;
                });
            }

            int currentMaxHeight = treeMap.lastKey();

            if(preMaxHeight != currentMaxHeight) {
                list.add(new int[]{buildingPoint.x, currentMaxHeight});
                preMaxHeight = currentMaxHeight;
            }
        }

        return list;

    }


}

class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;
    public BuildingPoint(int x, boolean isStart, int height) {
        this.x = x;
        this.isStart = isStart;
        this.height = height;
    }

    public int compareTo(BuildingPoint o) {
            if(this == o) {
                return 0;
            }

            if(this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
}



