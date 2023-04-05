package src.graph;

import java.util.ArrayList;

public class AdjacencyListCreationMethods {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1}
        };
        //TODO: if not given 0th row, increase adj list size to have extra null list for 0
        ArrayList<ArrayList> adjList = new ArrayList<>(matrix.length);
        createAdjListUsingMatrix(matrix, adjList);
        int nodes = 9;
        int edges[][] = {
                {1, 2}, {1, 6}, {2, 3}, {2, 4}, {6, 7}, {6, 9}, {4, 5}, {7, 8}, {5, 8}
        };

        ArrayList<ArrayList> adjList2 = new ArrayList<>(edges.length);
        createAdjListUsingEdges(nodes, edges, adjList2);
    }

    public static void createAdjListUsingMatrix(int[][] matix, ArrayList<ArrayList> adjList) {
        for (int i = 0; i < matix.length; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < matix.length; i++) {
            for (int j = 0; j < matix[0].length; j++) {
                if (matix[i][j] != 0 && i != j)
                    adjList.get(i).add(j);
            }
        }
        System.out.println();
    }

    public static void createAdjListUsingEdges(int nodes, int[][] edges, ArrayList<ArrayList> adjList) {
        for (int i = 0; i < nodes + 1; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println();
    }
}
