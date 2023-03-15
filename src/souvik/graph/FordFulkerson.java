package souvik.graph;

import souvik.support.List;
import souvik.support.Queue;

public class FordFulkerson {
    private int maxFlow;
    private List<FlowEdge> minCut;
    private boolean[] marked;
    private FlowEdge[] edgeTo;

    public FordFulkerson(FlowNetwork flowNetwork, int s, int t) {
        while (hasAugmentingPath(flowNetwork, s, t)) {
            double bottleneckCapacity = Double.POSITIVE_INFINITY;
            for (int v = s; v != t; v = edgeTo[v].other(v)) {
                bottleneckCapacity = Math.min(bottleneckCapacity, edgeTo[v].residualCapacityTo(edgeTo[v].other(v)));
            }
            for (int v = s; v != t; v = edgeTo[v].other(v)) {
                edgeTo[v].augmentResidualCapacityTo(edgeTo[v].other(v), (int) bottleneckCapacity);
            }
            maxFlow += (int) bottleneckCapacity;
        }
        findMinCut(flowNetwork, s);
    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, int s, int t) {
        marked = new boolean[flowNetwork.vertices()];
        edgeTo = new FlowEdge[flowNetwork.vertices()];

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            marked[v] = true;
            for (FlowEdge e : flowNetwork.adj(v)) {
                int w = e.other(v);
                if (!marked[w] && e.residualCapacityTo(w) != 0) {
                    queue.enqueue(w);
                    edgeTo[w] = e;
                }
            }
        }
        return marked[t];
    }

    private void findMinCut(FlowNetwork flowNetwork, int s) {
        minCut = new List<>();
        marked = new boolean[flowNetwork.vertices()];
        dfs(flowNetwork, s);
    }

    private void dfs(FlowNetwork flowNetwork, int v) {
        marked[v] = true;
        for (FlowEdge e : flowNetwork.adj(v)) {
            int w = e.other(v);
            if (!marked[w] && e.residualCapacityTo(w) != 0) {
                minCut.pushFront(e);
                dfs(flowNetwork, w);
            }
        }
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public List<FlowEdge> getMinCut() {
        return minCut;
    }
}
