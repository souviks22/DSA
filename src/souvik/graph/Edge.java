package souvik.graph;

public class Edge implements Comparable<Edge> {
    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (this.v == v) return w;
        return this.v;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight > that.weight) return 1;
        if (this.weight < that.weight) return -1;
        return 0;
    }
}