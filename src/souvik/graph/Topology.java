package souvik.graph;

import souvik.support.Stack;

public class Topology {
    private final Stack<Integer> reversePostOrder;
    private final boolean[] marked;

    public Topology(GraphAL graph) {
        assert !hasCycle(graph);
        reversePostOrder = new Stack<>();
        marked = new boolean[graph.getVertex()];
        for (int v = 0; v < graph.getVertex(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(GraphAL graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
                reversePostOrder.push(w);
            }
        }
    }

    public boolean hasCycle(GraphAL graph) {
        boolean[] checked = new boolean[graph.getVertex()];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        while (!s.isEmpty()) {
            int v = s.pop();
            checked[v] = true;
            for (int w : graph.adj(v)) {
                if (checked[w]) return true;
                s.push(w);
            }
        }
        return false;
    }

    public Stack<Integer> order() {
        return reversePostOrder;
    }
}
