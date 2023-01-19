package souvik.graphs.weightedAdjList;

public class Edge {
    private final int v, w;
    private final double weight;
    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int either(){
        return v;
    }
    public int other(int v){
        if(this.v == v) return w;
        return this.v;
    }
}
