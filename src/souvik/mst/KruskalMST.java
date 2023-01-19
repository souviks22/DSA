package souvik.mst;

import souvik.graph.Edge;
import souvik.graph.WeightedGraphAL;
import souvik.support.List;
import souvik.support.MinPriorityQueue;
import souvik.support.UnionFind;

public class KruskalMST {
    private final List<Edge> mst;
    private double weight;

    public KruskalMST(WeightedGraphAL graph) {
        mst = new List<>();
        int V = graph.getVertex();
        MinPriorityQueue<Edge> pq = new MinPriorityQueue<>();
        UnionFind uf = new UnionFind(V);
        for (int i = 0; i < V; i++) {
            for (Edge e : graph.adj(i)) {
                pq.enqueue(e);
            }
        }
        while (!pq.isEmpty() && mst.length() < V - 1) {
            Edge e = pq.dequeue();
            int v = e.either();
            int w = e.other(v);
            if (!uf.isConnected(v, w)) {
                mst.push_front(e);
                weight += e.getWeight();
                uf.union(v, w);
            }
            pq.dequeue();
        }
    }

    public List<Edge> mst() {
        return mst;
    }

    public double getWeight() {
        return weight;
    }
}
