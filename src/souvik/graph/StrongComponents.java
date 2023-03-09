package souvik.graph;

import souvik.support.Stack;

public class StrongComponents {
    private final boolean[] marked;
    private final int[] scc;
    private int count;

    public StrongComponents(Digraph digraph) {
        marked = new boolean[digraph.vertices()];
        scc = new int[digraph.vertices()];
        Topology tp = new Topology(digraph.reverse());
        for (int v : tp.order()) {
            if (!marked[v]) {
                dfs(digraph, v);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            marked[v] = true;
            scc[v] = count;
            for (int w : digraph.adj(v)) {
                if (!marked[w]) {
                    stack.push(w);
                }
            }
        }
    }

    public StrongComponents(WeightedDigraph weightedDigraph) {
        marked = new boolean[weightedDigraph.vertices()];
        scc = new int[weightedDigraph.vertices()];
        Topology tp = new Topology(weightedDigraph.reverse());
        for (int v : tp.order()) {
            if (!marked[v]) {
                dfs(weightedDigraph, v);
                count++;
            }
        }
    }

    private void dfs(WeightedDigraph weightedDigraph, int source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            marked[v] = true;
            scc[v] = count;
            for (DirectedEdge e : weightedDigraph.adj(v)) {
                if (!marked[e.to()]) {
                    stack.push(e.to());
                }
            }
        }
    }

    public int id(int v) {
        return scc[v];
    }

    public boolean isConnected(int v, int w) {
        return scc[v] == scc[w];
    }

    public int count() {
        return count;
    }

}
