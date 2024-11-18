package dp;

public class OnTheWayHome {
    public static void main(String[] args) {
        int n = 3, m = 4;
        System.out.println("No of ways to reach home for metrics n * m :" + onTheWayHome(n, m));
    }

    private static int onTheWayHome(int n, int m) {
        //n = rows & m= cols
        int[][] numWays = new int[n][m];
        //setting up base condition for last row & last column
        // as they will have only 1 way to reach home
        //filling up last column
        for (int i = 0; i < n; i++)
            numWays[i][m - 1] = 1;
        //filling up last row
        for (int i = 0; i < m; i++)
            numWays[n - 1][i] = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                numWays[i][j] = numWays[i][j+1] + numWays[i+1][j];
            }
        }
        return numWays[0][0];
    }
}
