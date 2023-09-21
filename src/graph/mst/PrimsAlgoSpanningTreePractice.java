package src.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgoSpanningTreePractice {
    public static void main(String[] args) {
//        int edges[][] = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        int edges[][] = {{1,2,5}, {1,3,6}, {2,3,1}};
//        int edges[][] = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int node = 3;
        primsAlgoSpanningTree(edges, node);
    }

    private static void primsAlgoSpanningTree(int[][] edges, int nodes) {
        List<List<int[]>> adjList = new ArrayList<>();
        //adj list with node and weight
        createAdjListForPrimsAlgo(adjList, nodes, edges);
        //create a priority queue to store the weight, node, parent
        PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<>((x,y)->x[0]-y[0]);
        //store starting first node with 0 weight and -1 as parent
        priorityQueue.add(new int[]{0, 0, -1});
        int mstSum = 0;
        //store the MST of nodes
        List<int[]> mstArr = new ArrayList<>();

        //visited array
        boolean visited[] = new boolean[nodes];
        while (!priorityQueue.isEmpty()) {
            int current[] = priorityQueue.poll();
            int weight = current[0];
            int currentNode = current[1];
            int parent = current[2];

            if (visited[currentNode])
                continue;
            visited[currentNode] = true;
            mstSum += weight;
            if (parent != -1)
                mstArr.add(new int[]{currentNode, parent});
            for (int neighbours[] : adjList.get(currentNode)) {
                int neighbour = neighbours[0];
                int neighbourWeight = neighbours[1];
                if(!visited[neighbour]){
                    priorityQueue.add(new int[]{neighbourWeight,neighbour,currentNode});
                }
            }
        }

        System.out.println("MST: " + mstSum);
        for (int i = 0; i < mstArr.size(); i++) {
            System.out.println(mstArr.get(i)[0]+ "-->" + mstArr.get(i)[1]);
        }
        System.out.println("MST Array: " + mstArr);

    }

    private static void createAdjListForPrimsAlgo(List<List<int[]>> adjList, int nodes, int[][] edges) {
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjList.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
    }
}
