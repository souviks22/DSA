package souvik.mst;

import souvik.graph.Edge;
import souvik.graph.WeightedGraphAL;
import souvik.graph.WeightedGraphAM;
import souvik.support.List;

public class MaximumSpanningTree {
    KruskalMST kTree;
    PrimMST pTree;

    public MaximumSpanningTree(WeightedGraphAL weightedGraphAL) {
        int V = weightedGraphAL.getVertex();
        WeightedGraphAL negatedGraph = new WeightedGraphAL(V);
        for (int i = 0; i < V; i++) {
            for (Edge e : weightedGraphAL.adj(i)) {
                int v = e.either();
                int w = e.other(v);
                Edge negatedEdge = new Edge(v, w, -e.getWeight());
                if (!negatedGraph.hasEdge(negatedEdge)) negatedGraph.addEdge(negatedEdge);
            }
        }
        if (weightedGraphAL.getEdges() < V) kTree = new KruskalMST(negatedGraph);
        else pTree = new PrimMST(negatedGraph);
    }

    public MaximumSpanningTree(WeightedGraphAM weightedGraphAM) {
        int V = weightedGraphAM.getVertex();
        WeightedGraphAM negatedGraph = new WeightedGraphAM(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                Double weight = weightedGraphAM.adj(i)[j];
                if (weight == null) continue;
                Edge negatedEdge = new Edge(i, j, -weight);
                if (!negatedGraph.hasEdge(negatedEdge)) negatedGraph.addEdge(negatedEdge);
            }
        }
        if (weightedGraphAM.getEdges() < V) kTree = new KruskalMST(negatedGraph);
        else pTree = new PrimMST(negatedGraph);
    }

    public List<Edge> mst() {
        return (kTree == null) ? pTree.mst() : kTree.mst();
    }

    public double getWeight() {
        return (kTree == null) ? -pTree.getWeight() : -kTree.getWeight();
    }
}
