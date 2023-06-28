package src.graph.mst;

public class Edge implements Comparable<Edge>{
    int src, dest, wt;
    public Edge(int src, int dest, int wt){
        this.dest = dest;
        this.wt = wt;
        this.src = src;
    }


    @Override
    public int compareTo(Edge o) {
        return this.wt - o.wt;
    }
}
