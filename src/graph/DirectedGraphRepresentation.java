package src.graph;

import java.util.ArrayList;

class Pair {
    int weight;
    int vertex;

    Pair(int weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}

public class DirectedGraphRepresentation {
    public static void main(String[] args) {
        //directed graph
        int nodes = 5, edges = 6;
        ArrayList<ArrayList<Pair>> edgeList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            edgeList.add(new ArrayList<>());
        }
        addEdge(edgeList, 0, 1, 1);
        addEdge(edgeList, 0, 2, 3);
        addEdge(edgeList, 1, 2, 2);
        addEdge(edgeList, 1, 4, 3);
        addEdge(edgeList, 3, 2, 3);
        addEdge(edgeList, 3, 0, 4);
        addEdge(edgeList, 4, 3, 5);
        System.out.println();
        printGraph(edgeList);
        printMatrix(edgeList, nodes);
    }

    private static void printMatrix(ArrayList<ArrayList<Pair>> edgeList, int nodes) {
        int maxtrix[][] = new int[nodes][nodes];
        for (int i = 0; i < edgeList.size(); i++) {
            int u = i;
            for (int j = 0; j < edgeList.get(i).size(); j++) {
                Pair p = edgeList.get(i).get(j);
                maxtrix[u][p.vertex] = p.weight;
            }
        }

        for (int i = 0; i < maxtrix.length; i++) {
            for (int j = 0; j < maxtrix.length; j++) {
                System.out.print(maxtrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printGraph(ArrayList<ArrayList<Pair>> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            System.out.println("Adjacency list of vertex: " + i);
            for (int j = 0; j < edgeList.get(i).size(); j++) {
                System.out.print(i + "");
                System.out.print("->" + edgeList.get(i).get(j).vertex + " (" + edgeList.get(i).get(j).weight+ ")");
                System.out.println();
            }
            System.out.println();
        }
    }

    static void addEdge(ArrayList<ArrayList<Pair>> edgeList, int u, int v, int weight) {
        edgeList.get(u).add(new Pair(weight, v));
    }

}
