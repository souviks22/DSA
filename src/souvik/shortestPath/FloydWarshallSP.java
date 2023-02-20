package souvik.shortestPath;

import souvik.graph.DirectedEdge;
import souvik.graph.WeightedDigraph;

public class FloydWarshallSP {
    private final double[][] distTo;

    public FloydWarshallSP(WeightedDigraph weightedDigraph) {
        int V = weightedDigraph.vertices();
        distTo = new double[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) distTo[i][j] = Double.POSITIVE_INFINITY;
        }
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : weightedDigraph.adj(v)) distTo[v][e.to()] = e.weight();
        }
        for (int k = 0; k < V; k++) {
            for (int v = 0; v < V; v++) {
                for (int w = 0; w < V; w++) {
                    if (distTo[v][k] + distTo[k][w] < distTo[v][w]) {
                        distTo[v][w] = distTo[v][k] + distTo[k][w];
                    }
                }
            }
        }
    }

    public double getDistBetween(int v, int w) {
        return distTo[v][w];
    }
}
