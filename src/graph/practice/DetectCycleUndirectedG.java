package src.graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static src.graph.DetectCycleDFS.createAdjList;

public class DetectCycleUndirectedG {
    public static void main(String[] args) {
        int edges[][] = {
                {1, 2},
                {1, 3},
                {3, 4},
                {2, 5},
                {3, 6},
                {5, 7},
                {6, 7}
        };
        int nodes = 7;
        boolean flag = detectCycleBFSPractice(edges, nodes);
        System.out.println("Is Cycle Present: " + flag);
    }

    private static boolean detectCycleBFSPractice(int[][] edges, int nodes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nodes + 1);
        createAdjList(adjList, nodes, edges);
        boolean visited[] = new boolean[nodes+1];
        for (int i = 1; i <= edges.length; i++) {
            if(!visited[i]){
                return detectC(i, nodes, adjList, visited);
            }
        }
        return  false;
    }

    private static boolean detectC(int i, int nodes, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[i]=true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, -1});
        while(!queue.isEmpty()){
            int pair[] = queue.poll();
            int srcNode = pair[0];
            int parent = pair[1];
            for (int adjNode : adjList.get(srcNode)) {
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.add(new int[]{adjNode, parent});
                } else if (parent!=adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
}
