package souvik.graph;

import souvik.support.List;

public class FlowNetwork {
    private final int vertex;
    private int edges;
    private final List<FlowEdge>[] adj;

    public FlowNetwork(int vertex) {
        this.vertex = vertex;
        adj = (List<FlowEdge>[]) new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new List<>();
        }
    }

    public void addEdge(int v, int w, int capacity) {
        FlowEdge flowEdge = new FlowEdge(v, w, capacity);
        adj[v].pushFront(flowEdge);
        adj[w].pushFront(flowEdge);
        edges++;
    }

    public List<FlowEdge> adj(int v) {
        return adj[v];
    }

    public int vertices() {
        return vertex;
    }

    public int edges() {
        return edges;
    }
}
