package souvik.graph;

import souvik.support.List;

public class WeightedDigraph {
    private final int vertex;
    private int edges;
    private final List<DirectedEdge>[] adj;

    public WeightedDigraph(int vertex) {
        this.vertex = vertex;
        adj = (List<DirectedEdge>[]) new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new List<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].pushFront(e);
        edges++;
    }

    public List<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int vertices() {
        return vertex;
    }

    public int edges() {
        return edges;
    }
}
