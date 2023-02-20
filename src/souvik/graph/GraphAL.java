package souvik.graph;

import souvik.support.List;

public class GraphAL {
    private final int vertex;
    private int edges;
    private final List<Integer>[] adj;

    public GraphAL(int vertex) {
        this.vertex = vertex;
        adj = (List<Integer>[]) new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new List<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].pushFront(w);
        adj[w].pushFront(v);
        edges++;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }

    public int vertices() {
        return vertex;
    }

    public int edges() {
        return edges;
    }
}
