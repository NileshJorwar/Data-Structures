package src.graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {

    /*
    * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
    * */
    public static void main(String[] args) {
        int graph[][] = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        new EventualSafeStates().eventualSafeNodes(graph);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int nodes = graph.length;
        createAdjList(adjList, nodes, graph);
        int visited[] = new int[nodes];
        int pathVisited[] = new int[nodes];
        int checkNode[] = new int[nodes];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            if (visited[i] == 0)
                dfsCheck(i, checkNode, adjList, visited, pathVisited);
        }
        for (int i = 0; i < nodes; i++) {
            if (checkNode[i] == 1)
                result.add(i);
        }
        return result;
    }

    public boolean dfsCheck(int currentNode, int checkNode[], ArrayList<ArrayList<Integer>> adjList, int visited[], int pathVisited[]) {
        visited[currentNode] = 1;
        pathVisited[currentNode] = 1;
        // checkNode[currentNode] = 0;
        for (int neighbour : adjList.get(currentNode)) {
            if (visited[neighbour] == 0 && pathVisited[neighbour] == 0) {
                if (dfsCheck(neighbour, checkNode, adjList, visited, pathVisited) == true)
                    // checkNode[currentNode] = 0;
                    return true;
            }
            //means cycle below
            else if (pathVisited[neighbour] == 1 && visited[neighbour] == 1) {
                // checkNode[currentNode] = 0;
                return true;
            }

        }
        checkNode[currentNode] = 1;
        pathVisited[currentNode] = 0;
        return false;
    }

    public void createAdjList(ArrayList<ArrayList<Integer>> adjList, int nodes, int[][] graph) {

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        //already given adjList in 2d array

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i].length != 0)
                    adjList.get(i).add(graph[i][j]);
            }
        }

    }
}
