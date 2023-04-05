package src.graph;

public class SurroundedRegionsReplaceOsWithXsDFS {
    public static void main(String[] args) {
        char matrix[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'}
        };
//        char matrix[][] = {
//                {'O','O','O'},
//                {'O','O','O'},
//                {'O','O','O'}
//        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int visited[][] = new int[rows][cols];
        //find neighbours vertically and horizontally
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        //traverse first row and last row
        for (int col = 0; col < cols; col++) {
            //first row
            if (visited[0][col] != 1 && matrix[0][col] == 'O') {
                dfs(0, col, matrix, visited, neighbours, rows, cols);
            }
            //last row
            if (visited[rows - 1][col] != 1 && matrix[rows - 1][col] == 'O') {
                dfs(rows - 1, col, matrix, visited, neighbours, rows, cols);
            }
        }
        //Traverse first and last column
        for (int row = 0; row < rows; row++) {
            //first column
            if (visited[row][0] != 1 && matrix[row][0] == 'O') {
                dfs(row, 0, matrix, visited, neighbours, rows, cols);
            }
            //last row
            if (visited[row][cols - 1] != 1 && matrix[row][cols - 1] == 'O') {
                dfs(row, cols - 1, matrix, visited, neighbours, rows, cols);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }

        //print matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("Final Matrix: " + matrix);
        new SurroundedRegionsReplaceOsWithXsDFS().solve(matrix);

    }

    public static void dfs(int row, int col, char[][] matrix, int visited[][], int[][] neighbours, int rows, int cols) {
        visited[row][col] = 1;
        //check for neighbour top/right/bottom/left
        for (int i = 0; i < neighbours.length; i++) {
            int nrow = row + neighbours[i][0];
            int ncol = col + neighbours[i][1];
            if (
                    nrow >= 0 && nrow < rows &&
                            ncol >= 0 && ncol < cols &&
                            visited[nrow][ncol] == 0 &&
                            matrix[nrow][ncol] == 'O'
            ) {
                dfs(nrow, ncol, matrix, visited, neighbours, rows, cols);
            }
        }
    }
    private void dfs(int row,int col,char[][] board,int[][] vis,int delrow[],int delcol[]){
        int m=board.length;
        int n=board[0].length;
        vis[row][col]=1;
        //neighbours
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            //validation
            if(nrow>=0  && ncol>=0 && nrow<m && ncol<n && board[nrow][ncol]=='O' && vis[nrow][ncol]==0 )
                dfs(nrow,ncol,board,vis,delrow,delcol);
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis = new int[m][n];
        int delrow[]={-1,1,0,0};
        int delcol[]={0,0,-1,1};

        //l&r
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && vis[i][0]==0)
                dfs(i,0,board,vis,delrow,delcol);

            if(board[i][n-1]=='O' && vis[i][n-1]==0)
                dfs(i,n-1,board,vis,delrow,delcol);

        }

        // u&d
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && vis[0][j]==0)
                dfs(0,j,board,vis,delrow,delcol);

            if(board[m-1][j]=='O' && vis[m-1][j]==0)
                dfs(m-1,j,board,vis,delrow,delcol);

        }

        //filling remaining 0's

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                    board[i][j]='X';
            }
        }

    }
}
