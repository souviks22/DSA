package souvik.graph;

public class WeightedGraphAM {
    private final int vertex;
    private int edges;
    private final Double[][] adj;

    public WeightedGraphAM(int vertex) {
        this.vertex = vertex;
        adj = new Double[vertex][vertex];
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v][w] = adj[w][v] = e.getWeight();
        edges++;
    }

    public boolean hasEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        return adj[v][w] != null;
    }

    public Double[] adj(int v) {
        return adj[v];
    }

    public int getVertex() {
        return vertex;
    }

    public int getEdges() {
        return edges;
    }
}
