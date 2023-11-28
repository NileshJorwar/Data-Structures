package graph.practice;

public class SurroundedRegionsPractice {
    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };

        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };

        surroundedRegions(board);
    }

    private static void surroundedRegions(char[][] board) {

        //use DFS
        int rows = board.length;
        int cols = board[0].length;

        int[][] visited = new int[rows][cols];
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0) {
                        dfsForSurroundedRegions(board, i, j, visited, neighbours, rows, cols);

                    } else if (i == rows - 1 || j == cols - 1) {
                        dfsForSurroundedRegions(board, i, j, visited, neighbours, rows, cols);
                    }
                }
            }
        }

        //based on visited array, i can print board array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
                System.out.print("" + board[i][j]);
            }
            System.out.println();
        }

    }

    private static void dfsForSurroundedRegions(char[][] board, int row, int col, int[][] visited, int[][] neighbours, int rows, int cols) {
        visited[row][col] = 1;
        for (int k = 0; k < neighbours.length; k++) {
            int crow = neighbours[k][0] + row;
            int ccol = neighbours[k][1] + col;
            if (crow >= 0 &&
                    crow < rows &&
                    ccol >= 0 &&
                    ccol < cols &&
                    visited[crow][ccol] == 0 &&
                    board[crow][ccol] == 'O')
                dfsForSurroundedRegions(board, crow, ccol, visited, neighbours, rows, cols);
        }
    }
}
