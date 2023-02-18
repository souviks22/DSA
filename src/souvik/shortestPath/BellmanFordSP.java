package souvik.shortestPath;

import souvik.graph.DirectedEdge;
import souvik.graph.WeightedDigraph;
import souvik.support.Stack;

public class BellmanFordSP {

    private final double[] distTo;
    private final DirectedEdge[] edgeTo;
    private final boolean hasNegativeCycle;

    public BellmanFordSP(WeightedDigraph weightedDigraph, int source) {
        int V = weightedDigraph.getVertex();
        distTo = new double[V];
        for (int i = 0; i < V; i++) distTo[i] = Double.POSITIVE_INFINITY;
        distTo[source] = 0;
        edgeTo = new DirectedEdge[V];
        for (int i = 0; i < V; i++) {
            for (int v = 0; v < V; v++) {
                for (DirectedEdge e : weightedDigraph.adj(v)) relax(e);
            }
        }
        hasNegativeCycle = isHasNegativeCycle(weightedDigraph);
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[v] + e.getWeight() < distTo[w]) {
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
        }
    }

    private boolean isHasNegativeCycle(WeightedDigraph weightedDigraph) {
        for (int v = 0; v < weightedDigraph.getVertex(); v++) {
            for (DirectedEdge e : weightedDigraph.adj(v)) {
                if (distTo[e.from()] + e.getWeight() < distTo[e.to()]) return true;
            }
        }
        return false;
    }

    public boolean hasNegativeCycle() {
        return hasNegativeCycle;
    }

    public double getDistTo(int v) {
        return distTo[v];
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
