package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    //This could be solved using dfs as well

    public static void main(String[] args) {
        int graph[][] = {
//                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
                {1, 0, 0}, {0, 1, 0}, {0, 0, 1}
        };

        int np = noOfProvinces(graph);
        System.out.println("No of provinces using DSU:" + np);
    }

    public static int noOfProvinces(int[][] isConnected) {
        int count = 0;
        int len = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjListForProvinces(adjList, isConnected);
        DisjointSetsPractice disjointSetsPractice = new DisjointSetsPractice(len);
        for (int i = 1; i <= len; i++) {
            for (int adj : adjList.get(i)) {
                disjointSetsPractice.unionBySize(i, adj);
            }
        }

        for (int i = 1; i <= len; i++) {
            if (disjointSetsPractice.findUltimateParent(i) == i)
                count++;
        }

        System.out.println();
        return count;
    }

    private static void createAdjListForProvinces(List<List<Integer>> adjList, int[][] isConnected) {
        for (int i = 0; i < isConnected.length + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i + 1).add(j + 1);
                }
            }
        }
    }


}
