package souvik.graph;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int from, to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public int other(int v) {
        if (this.from == v) return to;
        return this.from;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge that) {
        return Double.compare(this.weight, that.weight);
    }
}
