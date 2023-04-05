package src.graph;

import java.util.ArrayList;

public class ConnectedCompsGraph {
    static ArrayList<ArrayList<Integer>> edgeList;
    public static void main(String[] args) {
        int nodes = 5;
        edgeList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            edgeList.add(new ArrayList<>());
        }

        addEdge(edgeList, 0, 1);
        addEdge(edgeList, 1, 2);
        addEdge(edgeList, 0, 2);
        addEdge(edgeList, 3, 4);

        System.out.println();
        traversalOfConnectedComps(edgeList, nodes);
    }

    private static void traversalOfConnectedComps(ArrayList<ArrayList<Integer>> edgeList, int nodes) {
        boolean visited[] = new boolean[nodes];
        for (int vertex = 0; vertex < nodes; vertex++) {
            if (!visited[vertex]) {
                dfsTraversal(vertex, visited);
            }
        }
        for (int i=0;i<visited.length;i++) {
            System.out.println("Vertex: " + i +", visited: "+visited[i]);
        }
    }

    private static void dfsTraversal(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int eachVertex: edgeList.get(vertex)) {
                if(!visited[eachVertex])
                {
                    dfsTraversal(eachVertex, visited);
                }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> edgeList, int u, int v) {
        edgeList.get(u).add(v);
        edgeList.get(v).add(u);
    }

}
