package src.graph;

import java.util.*;

// Kahn's Algo -- BFS of TOpo sort using indegree and queue where indegree of nodes calculated and with 0 indegree node are started first
public class TopologicalSortBFSKahnsAlgo {
    public static void main(String[] args) {
        int graph[][] = {
                {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        // 4,5,2,0,3,1
        int nodes = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjList(adjList, nodes, graph);

        // In-degree creation
        int indegree[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int neighbour: adjList.get(i)) {
                indegree[neighbour]++;
            }
        }
        System.out.println(indegree);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }

        //BFS
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            ans.add(currentNode);
            for (int neighbour: adjList.get(currentNode)) {
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }

        System.out.println(ans);
    }

    public static void createAdjList(List<List<Integer>> adjList, int nodes, int[][] graph) {

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        //already given adjList in 2d array

        for (int i = 0; i < graph.length; i++) {
            adjList.get(graph[i][0]).add(graph[i][1]);
        }

    }
}
