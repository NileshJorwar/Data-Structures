package src.graph.shortestpaths.bfs;

import java.util.*;

public class ShortestAltPathsRedBlueColor {
    public static void main(String[] args) {
        int n = 3;
        int redEdges[][] = {
//                {0, 1}, {1, 2}
                {0, 1}
        };
//        int blueEdges[][] = {};
        int blueEdges[][] = {{2, 1}};
        int ans[] = new ShortestAltPathsRedBlueColor().shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println("Shortest Alt Paths:");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        /**
         * A breadth-first search is a good algorithm to use if we want to find
         * the shortest path in an unweighted graph.
         * The property of BFS is that the first time a node is reached during the traversal,
         * it was reached in the minimum possible steps from the source.
         */
        Map<Integer, List<List<Integer>>> adjMap = new HashMap<>();
        createAdjListForAltPaths(adjMap, redEdges, blueEdges, n);
        boolean visited[][] = new boolean[n][2];

        //marking red and blue node visited ; at first node 0 being visited true

        //Queue with node, steps and color
        Queue<int[]> queue = new LinkedList<>();

        visited[0][1] = visited[0][0] = true;
        //starting node 0 with 0 steps and no color
        queue.add(new int[]{0, 0, -1});

        int answer[] = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;

        while (!queue.isEmpty()) {
            int currentArr[] = queue.poll();
            int current_node = currentArr[0];
            int steps = currentArr[1];
            int color = currentArr[2];

            if (!adjMap.containsKey(current_node)) {
                continue;
            }
            for (List<Integer> adj : adjMap.get(current_node)) {
                int neighbour = adj.get(0);
                int neighbour_color = adj.get(1);

                if (!visited[neighbour][neighbour_color] && neighbour_color != color) {

                    if (answer[neighbour] == -1) {
                        answer[neighbour] = 1 + steps;
                    }
                    visited[neighbour][neighbour_color] = true;
                    queue.add(new int[]{neighbour, 1 + steps, neighbour_color});
                }
            }
        }
        return answer;
    }

    private void createAdjListForAltPaths(Map<Integer, List<List<Integer>>> adjMap, int[][] redEdges, int[][] blueEdges, int n) {

        //red edge = 0
        for (int[] edge : redEdges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(Arrays.asList(edge[1], 0));
        }
        //Blue edge = 0
        for (int[] edge : blueEdges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(Arrays.asList(edge[1], 1));
        }
    }
}
