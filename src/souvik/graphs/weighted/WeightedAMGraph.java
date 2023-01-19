package souvik.graphs.weighted;

public class WeightedAMGraph {
    private final int vertex;
    private int edges;
    private final Double[][] adj;
    public WeightedAMGraph(int vertex){
        this.vertex = vertex;
        edges = 0;
        adj = new Double[vertex][vertex];
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v][w] = adj[w][v] = e.getWeight();
        edges++;
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
