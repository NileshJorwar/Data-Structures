package src.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgoBFS {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph

//        int image[][] = {
//                {0, 1, 1, 0},
//                {0, 1, 2, 0},
//                {0, 2, 1, 0},
//                {0, 1, 1, 0},
//                {1, 1, 1, 1},
//        };
        int image[][] = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int ans[][] = floodFillAlgo(sr, sc, newColor, image);

        //Print Ans Image

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] floodFillAlgo(int sr, int sc, int newColor, int[][] image) {
        //starting point
        int initialColor = image[sr][sc];
        Queue<PairOfGraph> queue = new LinkedList<>();
        int rows = image.length;
        int columns = image[0].length;
        //add first with initial color
        queue.add(new PairOfGraph(sr, sc));
        if (initialColor == newColor)
            return image;

        //Get the neighbours in array for traversal
        int neighbours[][] = new int[][]{{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
        boolean visited[][] = new boolean[rows][columns];

        image[sr][sc] = newColor;
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            PairOfGraph pairOfGraph = queue.poll();
            int currentRow = pairOfGraph.row;
            int currentColumn = pairOfGraph.column;
            for (int i = 0; i < neighbours.length; i++) {
                int nrow = currentRow + neighbours[i][0];
                int ncol = currentColumn + neighbours[i][1];
                //check  for validity if neighbour are not index out of bound
                if (nrow < rows && nrow >= 0 &&
                        ncol < columns && ncol >= 0 &&
                        image[nrow][ncol] == initialColor && !visited[nrow][ncol]
                ) {
                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = newColor;
                    queue.add(new PairOfGraph(nrow, ncol));
                }
            }

        }
        return image;
    }

}
