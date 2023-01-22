package souvik.mst;

import souvik.graph.Edge;
import souvik.graph.WeightedGraphAL;
import souvik.graph.WeightedGraphAM;
import souvik.support.IndexMinPQ;
import souvik.support.List;

public class PrimMST {
    private final List<Edge> mst;
    private double weight;
    private final IndexMinPQ<Edge> pq;

    private PrimMST(int V) {
        mst = new List<>();
        Edge[] edgeTo = new Edge[V];
        edgeTo[0] = new Edge(0, 0, 0);
        for (int i = 1; i < V; i++) {
            edgeTo[i] = new Edge(i, 0, Double.POSITIVE_INFINITY);
        }
        pq = new IndexMinPQ<>(V, edgeTo);
        for (int i = 0; i < V; i++) {
            pq.enqueue(i);
        }
    }

    public PrimMST(WeightedGraphAL weightedGraphAL) {
        this(weightedGraphAL.getVertex());
        while (!pq.isEmpty() && mst.length() < weightedGraphAL.getVertex() - 1) {
            int v = pq.dequeue();
            for (Edge e : weightedGraphAL.adj(v)) {
                int w = e.other(v);
                if (pq.keys(w).compareTo(e) > 0) {
                    pq.decreaseKey(w, e);
                }
            }
            if (v == 0) continue;
            Edge edge = pq.keys(v);
            mst.pushFront(edge);
            weight += edge.getWeight();
        }
    }

    public PrimMST(WeightedGraphAM weightedGraphAM) {
        this(weightedGraphAM.getVertex());
        while (!pq.isEmpty() && mst.length() < weightedGraphAM.getVertex() - 1) {
            int v = pq.dequeue();
            for (int w = 0; w < weightedGraphAM.getVertex(); w++) {
                Double weight = weightedGraphAM.adj(v)[w];
                if (weight == null) continue;
                if (pq.keys(w).getWeight() > weight) {
                    pq.decreaseKey(w, new Edge(w, v, weight));
                }
            }
            if (v == 0) continue;
            Edge edge = pq.keys(v);
            mst.pushFront(edge);
            weight += edge.getWeight();
        }
    }

    public List<Edge> mst() {
        return mst;
    }

    public double getWeight() {
        return weight;
    }
}