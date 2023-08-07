package src.graph.disjointsets;

public class NoOperationsToMakeNwConnected {
    public static void main(String[] args) {
//        int n = 4;
//        int n = 6;
        int n = 12;
        int connections[][] = {
//                {0, 1}, {0, 2}, {1, 2}
//                {0,1},{0,2},{0,3},{1,2},{1,3}
                {1, 5}, {1, 7}, {1, 2}, {1, 4}, {3, 7}, {4, 7}, {3, 5}, {0, 6}, {0, 1}, {0, 4}, {2, 6}, {0, 3}, {0, 2}
        };
        int edges = makeConnected(n, connections);
        System.out.println("Operations required: " + edges);
    }

    private static int makeConnected(int n, int[][] connections) {
        //to find out different components use Disjoint Sets, get the count
        //find out extra edges while connecting components
        //after connecting comps, get the diff comps length
        //if extra edges > no of components -1, return edges because min edges required are total comps - 1
        DisjointSetsPractice disjointSetsPractice =
                new DisjointSetsPractice(n);
        int extraEdges = 0;
        for (int connection[] : connections) {
            int source = connection[0];
            int destination = connection[1];
            if (disjointSetsPractice.findUltimateParent(source) != disjointSetsPractice.findUltimateParent(destination)) {
                disjointSetsPractice.unionBySize(source, destination);
            } else {
                extraEdges++;
            }
        }

        int comps = 0;
        for (int i = 0; i < n; i++) {
            if (disjointSetsPractice.findUltimateParent(i) == i) {
                comps++;
            }
        }
        int ans = comps - 1;
        if (extraEdges >= ans) {
            return ans;
        }
        return -1;
    }
}
