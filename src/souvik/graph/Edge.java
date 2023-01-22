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
        return Double.compare(this.weight, that.weight);
    }

    public boolean equals(Edge that) {
        if (this.weight != that.weight) return false;
        int v = that.either();
        int w = that.other(v);
        if (this.v == v) return this.w == w;
        if (this.v == w) return this.w == v;
        return false;
    }
}