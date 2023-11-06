package src.graph.practice;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgoBFSPractice {
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
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        if (initialColor == newColor)
            return image;
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };
        int rows = image.length;
        int cols = image[0].length;

        boolean visited[][] = new boolean[rows][cols];
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {

            int pair[] = queue.poll();
            int current_row = pair[0];
            int current_col = pair[1];

            for (int i = 0; i < neighbours.length; i++) {

                int nrow = current_row + neighbours[i][0];
                int ncol = current_col + neighbours[i][1];
                if (nrow < rows && nrow >= 0 && ncol < cols && ncol >= 0 && image[nrow][ncol] == initialColor &&
                        visited[nrow][ncol] == false
                ) {
                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = newColor;
                    queue.add(new int[]{nrow, ncol});
                }
            }
        }
        return image;
    }

}
