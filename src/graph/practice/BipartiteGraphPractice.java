package graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphPractice {
    public static void main(String[] args) {
        int graph[][] = {
                {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
        };

        boolean isBipartiteGraph = checkBipartite(graph);
        System.out.println("Is Bipartite: ?" + isBipartiteGraph);
    }

    private static boolean checkBipartite(int[][] graph) {

        List<List<Integer>> adjList = new ArrayList<>();
        createAdjListForBipartite(adjList, graph);
        int rows = graph.length;
        int[] colorsVisited = new int[rows];
        //initially color all nodes with -1
        for (int i = 0; i < rows; i++) {
            colorsVisited[i] = -1;
        }
        //check for each node
        for (int node = 0; node < rows; node++) {
            if(colorsVisited[node]==-1){
                if(checkBipartiteBFS(colorsVisited, adjList, node)==false)
                    return false;
            }
        }
        return true;

    }

    private static boolean checkBipartiteBFS(int[] colorsVisited, List<List<Integer>> adjList, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        //start node added which is 0
        queue.add(startNode);
        //color the start node with 0
        colorsVisited[startNode] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int adjNode : adjList.get(currentNode)) {

                //if adj node not visited or colored yet, color it with opposite color of parent node
                if (colorsVisited[adjNode] == -1) {
                    colorsVisited[adjNode] = 1 - colorsVisited[currentNode];
                    queue.add(adjNode);
                }
                // if adj node color is same as parent node color ; then this not bipartite graph
                else if (colorsVisited[adjNode] == colorsVisited[currentNode]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void createAdjListForBipartite(List<List<Integer>> adjList, int[][] graph) {

        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[1].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }
    }
}
