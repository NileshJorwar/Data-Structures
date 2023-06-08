package src.graph.shortestpaths.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFrmSrcToTrgt {
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
        dfsToFindAllPathsToTarget(current, result, graph, adjList, src, dest);
        return result;
    }

    private static void dfsToFindAllPathsToTarget(List<Integer> current, List<List<Integer>> result, int[][] graph, ArrayList<ArrayList<Integer>> adjList, int src, int dest) {
        if (src == dest) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int adjNode : adjList.get(src)) {
            current.add(adjNode);
            dfsToFindAllPathsToTarget(current, result, graph, adjList, adjNode, dest);
            current.remove(current.size() - 1);
        }

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
