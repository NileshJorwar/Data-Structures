package src.graph;

import java.util.*;

public class EventualSafeStatesBFSTopoSort {

    /*
     * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
     * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
     * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
     * Eventual Safe states --- terminal nodes are safe nodes, path from any node to terminal node is safe if that node is not part of cycle
     * Hence, use in-degrees of nodes to check that
     * to have in-degrees, change the direction of nodes , reverse them and perform the topo sort ,topo sort will leave out cycles
     *
     * */
    public static void main(String[] args) {
        int graph[][] = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        List<Integer> res = new EventualSafeStatesBFSTopoSort().eventualSafeNodes(graph);
        System.out.println(res);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int nodes = graph.length;
        createAdjList(adjList, nodes, graph);
        List<Integer> result = new ArrayList<>();

        // find in-degrees of nodes

        int indegree[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int neighbour : adjList.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for (int neighbour: adjList.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }

        }
        Collections.sort(result);
        return result;
    }


    public void createAdjList(ArrayList<ArrayList<Integer>> adjList, int nodes, int[][] graph) {
        //reverse the edges for topo sort

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(graph[i][j]).add(i);
            }
        }
    }
}
