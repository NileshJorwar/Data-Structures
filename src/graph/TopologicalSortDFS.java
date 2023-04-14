package src.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        int graph[][] = {
                {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        int nodes = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjList(adjList, nodes, graph);

        int visited[] = new int[nodes];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nodes; i++) {
            if (visited[i] == 0) {
                dfsTopSort(visited, stack, adjList, i);
            }
        }
        System.out.println(stack);
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            int x = stack.pop();
            ans.add(x);
        }
        System.out.println(ans);
    }

    public static void dfsTopSort(int visited[], Stack<Integer> stack, List<List<Integer>> adjList, int currentNode) {
        visited[currentNode] = 1;
        for (int neighbour : adjList.get(currentNode)) {
            if(visited[neighbour]==0){
                dfsTopSort(visited, stack, adjList, neighbour);
            }
        }
        stack.push(currentNode);
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
