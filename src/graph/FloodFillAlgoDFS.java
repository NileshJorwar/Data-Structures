package src.graph;


import java.util.ArrayList;

public class FloodFillAlgoDFS {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph

        int image[][] = {
                {0, 1, 1, 0},
                {0, 1, 2, 0},
                {0, 2, 1, 0},
                {0, 1, 1, 0},
                {1, 1, 1, 1},
        };
        int sr = 4, sc = 0, newColor = 3;
        int ans [][] = floodFillAlgo(sr, sc, newColor, image);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] floodFillAlgo(int sr, int sc, int newColor, int[][] image) {

        int initialColor = image[sr][sc];

//        int ansImage[][] = new int[image.length][];
//        for (int i = 0; i < image.length; i++) {
//            ansImage[i] = image[i].clone();
//        }
        //or
        int ansImage[][] = image;
        //to get neighbours vertically and horizontally
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        dfs(sr, sc, newColor, image, initialColor, ansImage, delRow, delCol);

        return ansImage;
    }

    private static void dfs(int sr, int sc, int newColor, int[][] image, int initialColor, int[][] ansImage, int delRow[], int delCol[]) {
        ansImage[sr][sc] = newColor;
        int rows = image.length;
        int cols = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];
            if (nrow >= 0 && nrow < rows &&
                    ncol >= 0 && ncol < cols &&
                    image[nrow][ncol] == initialColor &&
                    ansImage[nrow][ncol] != newColor
            ) {
                dfs(nrow,ncol,newColor,image,initialColor,ansImage,delRow,delCol);
            }
        }
    }

}
