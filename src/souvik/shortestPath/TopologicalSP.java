package souvik.shortestPath;

import souvik.graph.DirectedEdge;
import souvik.graph.Topology;
import souvik.graph.WeightedDigraph;
import souvik.support.Stack;

public class TopologicalSP {
    private final double[] distTo;
    private final DirectedEdge[] edgeTo;

    public TopologicalSP(WeightedDigraph weightedDigraph, int source) {
        assert !hasCycle(weightedDigraph);
        int V = weightedDigraph.getVertex();
        distTo = new double[V];
        for (int i = 0; i < V; i++) distTo[i] = Double.POSITIVE_INFINITY;
        distTo[source] = 0;
        edgeTo = new DirectedEdge[V];
        Topology tp = new Topology(weightedDigraph);
        for (int v : tp.order()) {
            for (DirectedEdge e : weightedDigraph.adj(v)) relax(e);
        }
    }

    private boolean hasCycle(WeightedDigraph weightedDigraph) {
        boolean[] checked = new boolean[weightedDigraph.getVertex()];
        Stack<Integer> s = new Stack<>();
        for (int v = 0; v < weightedDigraph.getVertex(); v++) {
            if (checked[v]) continue;
            checked[v] = true;
            boolean[] marked = new boolean[weightedDigraph.getVertex()];
            s.push(v);
            while (!s.isEmpty()) {
                int w = s.pop();
                if (!checked[w]) checked[w] = true;
                if (marked[w]) return true;
                marked[w] = true;
                for (DirectedEdge e : weightedDigraph.adj(v)) s.push(e.to());
            }
        }
        return false;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[v] + e.getWeight() < distTo[w]) {
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
        }
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
