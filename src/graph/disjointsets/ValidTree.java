package src.graph.disjointsets;

public class ValidTree {

//    Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false; // A valid tree must have exactly n-1 edges for n nodes.
        }

        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false; // Cycle detected
            }
        }

        // If there are no cycles and all nodes are connected, it's a valid tree.
        return true;
    }
}
class DSU {
    int[] parent;

    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            return true;
        } else {
            return false; // Cycle detected
        }
    }
}
