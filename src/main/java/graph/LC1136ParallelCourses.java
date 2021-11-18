package graph;

import java.util.*;

/**
 * Solution: Topology Sorting and BFS
 */

public class LC1136ParallelCourses {
    /**
     * There are n courses, labelled from 1 to n.
     *
     * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
     *
     * In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
     *
     * Return the minimum number of semesters needed to study all courses. If there is no way to study all the courses, return -1.
     *
     *
     * Example 1:
     *
     * Input: n = 3, relations = [[1,3],[2,3]]
     * Output: 2
     * Explanation:
     * In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
     *
     * Example 2:
     *
     * Input: n = 3, relations = [[1,2],[2,3],[3,1]]
     * Output: -1
     * Explanation:
     * No course can be studied because they depend on each other.
     * Note:
     *
     * 1 <= n <= 5000
     * 1 <= relations.length <= 5000
     * relations[i][0] != relations[i][1]
     * There are no repeated relations in the input.
     *
     */

    public int minimumSemesters(int n, int[][] relations) {
        int[] degree = new int[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] relation : relations) {
            int pre = relation[0];
            int cur = relation[1];
            map.computeIfAbsent(pre, key -> new LinkedList<>()).add(cur);
            degree[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++) {
            if(degree[i] == 0) {
                queue.offer(i);
            }
        }

        int N = 0;
        int ret = 0;

        while(!queue.isEmpty()) {
            ret++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int cur = queue.poll();
                N++;
                for(int next : map.remove(cur)) {
                    degree[next]--;
                    if(degree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return N == n ? ret : -1;
    }

}
