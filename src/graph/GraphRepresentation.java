package src.graph;

import java.util.ArrayList;

public class GraphRepresentation {
    public static void main(String[] args) {
        //undirected graph
        int nodes = 5, edges = 6;
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            edgeList.add(new ArrayList<>());
        }
        addEdge(edgeList, 0, 1);
        addEdge(edgeList, 0, 4);
        addEdge(edgeList, 1, 2);
        addEdge(edgeList, 1, 3);
        addEdge(edgeList, 1, 4);
        addEdge(edgeList, 2, 3);
        addEdge(edgeList, 3, 4);
        System.out.println();
        printGraph(edgeList);
        printMatrix(edgeList, nodes);
    }

    //adjacency list to matrix
    private static void printMatrix(ArrayList<ArrayList<Integer>> edgeList, int nodes) {
        int maxtrix[][] = new int[nodes][nodes];
        for (int i = 0; i < edgeList.size(); i++) {
            int u = i;
            for (int j = 0; j < edgeList.get(i).size(); j++) {
                int v = edgeList.get(i).get(j);
                maxtrix[u][v] = 1;
                maxtrix[v][u] = 1;
            }
        }

        for (int i = 0; i < maxtrix.length; i++) {
            for (int j = 0; j < maxtrix.length; j++) {
                System.out.print(maxtrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            System.out.println("Adjacency list of vertex: " + i);
            for (int j = 0; j < edgeList.get(i).size(); j++) {
                System.out.print(i + "");
                System.out.print("->" + edgeList.get(i).get(j));
                System.out.println();
            }
            System.out.println();
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> edgeList, int u, int v) {
        edgeList.get(u).add(v);
        edgeList.get(v).add(u);
    }

}
