package souvik.graph;

public class StrongComponents {
    private final boolean[] marked;
    private final int[] scc;
    private int count;

    public StrongComponents(Digraph digraph) {
        marked = new boolean[digraph.vertices()];
        scc = new int[digraph.vertices()];
        Topology tp = new Topology(digraph.reverse());
        for (int v : tp.order()) {
            if (!marked[v]) {
                visit(digraph, v);
                count++;
            }
        }
    }

    public StrongComponents(WeightedDigraph weightedDigraph) {
        marked = new boolean[weightedDigraph.vertices()];
        scc = new int[weightedDigraph.vertices()];
        Topology tp = new Topology(weightedDigraph.reverse());
        for (int v : tp.order()) {
            if (!marked[v]) {
                visit(weightedDigraph, v);
                count++;
            }
        }
    }

    private void visit(Digraph digraph, int v) {
        marked[v] = true;
        scc[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) visit(digraph, w);
        }
    }

    private void visit(WeightedDigraph weightedDigraph, int v) {
        marked[v] = true;
        scc[v] = count;
        for (DirectedEdge e : weightedDigraph.adj(v)) {
            int w = e.to();
            if (!marked[w]) visit(weightedDigraph, w);
        }
    }

    public int id(int v) {
        return scc[v];
    }

    public boolean isConnected(int v, int w) {
        return scc[v] == scc[w];
    }

    public int count() {
        return count;
    }

}
