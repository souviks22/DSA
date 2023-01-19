package souvik.mst;

import souvik.graphs.weighted.Edge;
import souvik.graphs.weighted.WeightedALGraph;
import souvik.support.List;
import souvik.support.MinPriorityQueue;
import souvik.support.UnionFind;

public class MinimumSpanningTree {
    private final List<Edge> mst;
    private final MinPriorityQueue<Edge> pq;
    private final UnionFind uf;
    public MinimumSpanningTree(WeightedALGraph graph){
        mst = new List<>();
        pq = new MinPriorityQueue<>();
        uf = new UnionFind(graph.getVertex());
        for(int i=0; i< graph.getVertex(); i++){
            for(Edge e : graph.adj(i)){
                pq.enqueue(e);
            }
        }
    }
}
