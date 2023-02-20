package souvik.graph;

public class GraphAM {
    private final int vertex;
    private int edges;
    private final boolean[][] adj;

    public GraphAM(int vertex) {
        this.vertex = vertex;
        adj = new boolean[vertex][vertex];
    }

    public void addEdge(int v, int w) {
        adj[v][w] = adj[w][v] = true;
        edges++;
    }

    public boolean[] adj(int v) {
        return adj[v];
    }

    public int vertices() {
        return vertex;
    }

    public int edges() {
        return edges;
    }
}
