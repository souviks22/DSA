package souvik.graph;

import souvik.support.List;

public class WeightedGraphAL {
    private final int vertex;
    private int edges;
    private final List<Edge>[] adj;

    public WeightedGraphAL(int vertex) {
        this.vertex = vertex;
        adj = (List<Edge>[]) new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new List<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].pushFront(e);
        adj[w].pushFront(e);
        edges++;
    }

    public List<Edge> adj(int v) {
        return adj[v];
    }

    public int getVertex() {
        return vertex;
    }

    public int getEdges() {
        return edges;
    }
}
