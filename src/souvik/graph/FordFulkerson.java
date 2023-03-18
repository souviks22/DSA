package souvik.graph;

import souvik.support.List;
import souvik.support.Queue;

public class FordFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private int maxFlow;
    private List<FlowEdge> minCut;

    public FordFulkerson(FlowNetwork flowNetwork, int s, int t) {
        while (hasAugmentingPath(flowNetwork, s, t)) {
            double bottleneckCapacity = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottleneckCapacity = Math.min(bottleneckCapacity, edgeTo[v].residualCapacityTo(v));
            }
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].augmentResidualFlowTo(v, (int) bottleneckCapacity);
            }
            maxFlow += (int) bottleneckCapacity;
        }
        minCut = new List<>();
        for (int i = 0; i < flowNetwork.vertices(); i++) {
            if (edgeTo[i] == null) continue;
            minCut.pushFront(edgeTo[i]);
        }
    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, int s, int t) {
        marked = new boolean[flowNetwork.vertices()];
        edgeTo = new FlowEdge[flowNetwork.vertices()];

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (FlowEdge e : flowNetwork.adj(v)) {
                int w = e.other(v);
                if (!marked[w] && e.residualCapacityTo(w) > 0) {
                    marked[v] = true;
                    edgeTo[w] = e;
                    queue.enqueue(w);
                }
            }
        }
        return marked[t];
    }

    public boolean inMinCut(int v) {
        return marked[v];
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public List<FlowEdge> getMinCut() {
        return minCut;
    }
}
