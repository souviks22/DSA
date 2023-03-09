package souvik.graph;

public class ConnectedComponents {
    private final boolean[] marked;
    private final int[] cc;
    private int count;

    public ConnectedComponents(GraphAL graphAL) {
        marked = new boolean[graphAL.vertices()];
        cc = new int[graphAL.vertices()];
        for (int v = 0; v < graphAL.vertices(); v++) {
            if (!marked[v]) {
                visit(graphAL, v);
                count++;
            }
        }
    }

    public ConnectedComponents(WeightedGraphAL weightedGraphAL) {
        marked = new boolean[weightedGraphAL.vertices()];
        cc = new int[weightedGraphAL.vertices()];
        for (int v = 0; v < weightedGraphAL.vertices(); v++) {
            if (!marked[v]) {
                visit(weightedGraphAL, v);
                count++;
            }
        }
    }

    private void visit(GraphAL graphAL, int v) {
        marked[v] = true;
        cc[v] = count;
        for (int w : graphAL.adj(v)) {
            if (!marked[w]) visit(graphAL, w);
        }
    }

    private void visit(WeightedGraphAL weightedGraphAL, int v) {
        marked[v] = true;
        cc[v] = count;
        for (Edge e : weightedGraphAL.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) visit(weightedGraphAL, w);
        }
    }

    public int id(int v) {
        return cc[v];
    }

    public boolean isConnected(int v, int w) {
        return cc[v] == cc[w];
    }

    public int count() {
        return count;
    }
}
