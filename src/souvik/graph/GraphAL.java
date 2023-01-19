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
        adj[v].push_front(w);
        adj[w].push_front(v);
        edges++;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }

    public int getVertex() {
        return vertex;
    }

    public int getEdges() {
        return edges;
    }
}
