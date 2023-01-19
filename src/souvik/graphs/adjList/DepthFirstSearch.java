package souvik.graphs.adjList;

import souvik.support.List;
import souvik.support.Stack;

public class DepthFirstSearch {
    private final int source;
    private final boolean[] marked;
    private final Integer[] edgeTo;
    private final List<Integer> traversal;

    public DepthFirstSearch(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.getVertex()];
        edgeTo = new Integer[graph.getVertex()];
        traversal = new List<>();
        dfs(graph);
    }

    private void dfs(Graph graph) {
        Stack<Integer> s = new Stack<>();
        s.push(source);
        while (!s.isEmpty()) {
            int v = s.pop();
            marked[v] = true;
            traversal.push_back(v);
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    s.push(w);
                    edgeTo[w] = v;
                }
            }
        }
    }

    public List<Integer> traversal() {
        return traversal;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> path = new List<>();
        for (int i = v; i != source; i = edgeTo[i]) {
            path.push_front(i);
        }
        path.push_front(source);
        return path;
    }
}
