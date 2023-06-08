package src.graph.shortestpaths;

public class FindCityWithShortestNoOfNeighboursAtThreshold {
    public static void main(String[] args) {
//        int edges[][] = {
//                {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}
//        };
        int edges[][] = {
                {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}
        };

//        int n = 4;
        int n = 5;
//        int distanceThreshold = 4;
        int distanceThreshold = 2;
        int cityNo = findTheCity(n, edges, distanceThreshold);
//        int cityNo = findTheCity2(n, edges, distanceThreshold);
        System.out.println("City: " + cityNo);
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int distance[][] = new int[n][n];
        //setting distance array with infinite values

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            distance[u][v] = wt;
            distance[v][u] = wt;
        }
        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }

        System.out.println("Printing ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + distance[i][j]);
            }
            System.out.println();
        }



        //Floyd Warshall Algo
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][via] == Integer.MAX_VALUE || distance[via][j] == Integer.MAX_VALUE)
                        continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][via] + distance[via][j]);
                }
            }
        }

        System.out.println("Printing ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + distance[i][j]);
            }
            System.out.println();
        }

        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (distance[city][adjCity] <= distanceThreshold)
                    cnt++;
            }
            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }

        }
        return cityNo;
    }

    public static int findTheCity2(int n, int[][] edges, int distanceThreshold){
        int costs[][] = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) costs[i][j] = 0;
                else costs[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            costs[u][v] = cost;
            costs[v][u] = cost;
        }

        System.out.println("Printing ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + costs[i][j]);
            }
            System.out.println();
        }
        for (int k=0; k<n; k++) { //for every intermdiate node.
            for (int i=0; i<n; i++) { //for every source node.
                for (int j=0; j<n; j++) {//for every destination node.
                    if (costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE) {
                        costs[i][j] = Math.min(costs[i][j],
                                costs[i][k] + costs[k][j]
                        );
                    }
                }
            }
        }
        System.out.println("Printing ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + costs[i][j]);
            }
            System.out.println();
        }
        return 0;
    }
}
