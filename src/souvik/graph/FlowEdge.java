package souvik.graph;

public class FlowEdge {
    private final int v, w;
    private final int capacity;
    private int flow;

    public FlowEdge(int v, int w, int capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
        flow = 0;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int other(int s) {
        if (s == v) return w;
        else if (s == w) return v;
        else throw new IllegalArgumentException();
    }

    public int residualCapacityTo(int s) {
        if (s == v) return flow;
        else if (s == w) return capacity - flow;
        else throw new IllegalArgumentException();
    }

    public void augmentResidualCapacityTo(int s, int amount) {
        if (s == v) flow -= amount;
        else if (s == w) flow += amount;
        else throw new IllegalArgumentException();
    }
}
