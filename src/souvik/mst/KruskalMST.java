package souvik.mst;

import souvik.graph.Edge;
import souvik.graph.WeightedGraphAL;
import souvik.graph.WeightedGraphAM;
import souvik.support.List;
import souvik.support.MinPQ;
import souvik.support.UnionFind;

public class KruskalMST {
    private final List<Edge> mst;
    private double weight;
    private final MinPQ<Edge> pq;
    private final UnionFind uf;

    private KruskalMST(int V) {
        mst = new List<>();
        pq = new MinPQ<>();
        uf = new UnionFind(V);
    }

    public KruskalMST(WeightedGraphAL weightedGraphAL) {
        this(weightedGraphAL.getVertex());
        for (int v = 0; v < weightedGraphAL.getVertex(); v++) {
            for (Edge e : weightedGraphAL.adj(v)) {
                pq.enqueue(e);
            }
        }
        growMST(weightedGraphAL.getVertex());
    }

    public KruskalMST(WeightedGraphAM weightedGraphAM) {
        this(weightedGraphAM.getVertex());
        int V = weightedGraphAM.getVertex();
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < V; w++) {
                Double weight = weightedGraphAM.adj(v)[w];
                if (weight != null) {
                    pq.enqueue(new Edge(v, w, weight));
                }
            }
        }
        growMST(weightedGraphAM.getVertex());
    }

    private void growMST(int V) {
        while (!pq.isEmpty() && mst.length() < V - 1) {
            Edge e = pq.dequeue();
            int v = e.either();
            int w = e.other(v);
            if (!uf.isConnected(v, w)) {
                mst.pushFront(e);
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