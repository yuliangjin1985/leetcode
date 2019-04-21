package map;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 * https://www.geeksforgeeks.org/topological-sorting/
 */
public class TopologicalSorting {


}

class Graph {
    private int v;
    private List<Integer>[] adjacentList;

    public Graph(int v) {
        this.v = v;
        this.adjacentList = new List[v];
        for(int i=0;i<v;i++) {
            adjacentList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int u, int v) {
        adjacentList[u].add(v);
    }

    void topologicalSortUtil(int u, boolean[] visited, Stack<Integer> stack) {
        if(visited[u]) return;

        visited[u] = true;
        for(int v : adjacentList[u]) {
            if(visited[v]) continue;
            topologicalSortUtil(v, visited, stack);
        }

        stack.push(u);
    }

    List<Integer> topologicalSort() {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v;i++) {
            topologicalSortUtil(i, visited, stack);
        }

        LinkedList<Integer> list = new LinkedList<>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topologicalSort = graph.topologicalSort();
        for (Integer integer : topologicalSort) {
            System.out.println(integer);
        }
    }
}
