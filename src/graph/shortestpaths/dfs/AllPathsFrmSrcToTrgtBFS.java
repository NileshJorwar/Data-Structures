package src.graph.shortestpaths.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFrmSrcToTrgtBFS {
    public static void main(String[] args) {
        int[][] graph = {
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
        };
        List<List<Integer>> res = allPathsSourceTarget(graph);
        System.out.println(res);
    }

    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int length = graph.length;
        createAdjListForGraph(adjList, graph, length);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        //starting node
        int src = 0;
        int dest = length - 1;
        current.add(src);
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(src);
        while (!bfsQueue.isEmpty()) {
            int srcNode = bfsQueue.poll();
            current.add(srcNode);
            if (srcNode == dest) {
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
            for (int adjNeighbour : adjList.get(srcNode)
            ) {
                bfsQueue.add(adjNeighbour);
            }
        }

        return result;
    }

    private static void createAdjListForGraph(ArrayList<ArrayList<Integer>> adjList, int[][] graph, int length) {
        for (int i = 0; i < length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }
    }
}
