package souvik.shortest_path;

import souvik.graph.DirectedEdge;
import souvik.graph.WeightedDigraph;
import souvik.support.IndexMinPQ;
import souvik.support.Stack;

public class DijkstraSP {
    private final IndexMinPQ<Double> pq;
    private final DirectedEdge[] edgeTo;

    public DijkstraSP(WeightedDigraph weightedDigraph, int source) {
        if (hasNegativeEdge(weightedDigraph)) {
            throw new IllegalArgumentException("Graph should not contain negative edge(s).");
        }
        int V = weightedDigraph.vertices();
        pq = new IndexMinPQ<>(V);
        edgeTo = new DirectedEdge[V];
        for (int i = 0; i < V; i++) {
            if (i == source) pq.enqueue(i, 0.0);
            else pq.enqueue(i, Double.POSITIVE_INFINITY);
        }
        while (!pq.isEmpty()) {
            int v = pq.dequeue();
            for (DirectedEdge e : weightedDigraph.adj(v)) relax(e);
        }
    }

    private boolean hasNegativeEdge(WeightedDigraph weightedDigraph) {
        for (int i = 0; i < weightedDigraph.vertices(); i++) {
            for (DirectedEdge e : weightedDigraph.adj(i)) {
                if (e.weight() < 0) return true;
            }
        }
        return false;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (pq.keys(v) + e.weight() < pq.keys(w)) {
            pq.decreaseKey(w, pq.keys(v) + e.weight());
            edgeTo[w] = e;
        }
    }

    public double getDistTo(int v) {
        return pq.keys(v);
    }

    public Stack<DirectedEdge> shortestPathTo(int v) {
        if (getDistTo(v) == Double.POSITIVE_INFINITY) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
