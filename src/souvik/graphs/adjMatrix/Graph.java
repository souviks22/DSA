package souvik.graphs.adjMatrix;

public class Graph {
    private final int vertex;
    private int edges;
    private final boolean[][] adj;

    public Graph(int vertex) {
        this.vertex = vertex;
        edges = 0;
        adj = new boolean[vertex][vertex];
    }

    public void addEdge(int v, int w) {
        adj[v][w] = adj[w][v] = true;
        edges++;
    }

    public boolean[] adj(int v) {
        return adj[v];
    }

    public int getVertex() {
        return vertex;
    }

    public int getEdges() {
        return edges;
    }
}
