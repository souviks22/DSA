package souvik.shortestPath;

import souvik.graph.DirectedEdge;
import souvik.graph.WeightedDigraph;
import souvik.support.IndexMinPQ;

public class DijkstraSP {
    private final int source;
    private final IndexMinPQ<Double> pq;

    public DijkstraSP(WeightedDigraph weightedDigraph, int source) {
        this.source = source;
        pq = new IndexMinPQ<>(weightedDigraph.getVertex());
        for (int i = 0; i < weightedDigraph.getVertex(); i++) pq.enqueue(i,Double.POSITIVE_INFINITY);
        while(!pq.isEmpty()){
            int v = pq.dequeue();
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (pq.keys(v) + e.getWeight() < pq.keys(w)) {
            pq.decreaseKey(w, pq.keys(v) + e.getWeight());
        }
    }
}
