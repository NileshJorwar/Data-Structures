package src.graph.shortestpaths;

public class FloydWarshallAlgo {
    public static void main(String[] args) {
        int matrix[][] = {
                {}
        };
        shortestDistance(matrix);
    }

    private static void shortestDistance(int[][] matrix) {
        int nodes = matrix.length;

        //do before start to set diagonal and negative values
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int via = 0; via < nodes; via++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    matrix[i][j]=Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        //if it contains cycle ; check matrix for < 0 values
        //do before returning
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (matrix[i][j] == 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }

    }
}
