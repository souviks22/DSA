package souvik.graph;

import souvik.support.List;
import souvik.support.Stack;

public class DepthFirstSearch {
    private final int source;
    private final boolean[] marked;
    private final Integer[] edgeTo;
    private final List<Integer> traversal;

    private DepthFirstSearch(int V, int source) {
        this.source = source;
        marked = new boolean[V];
        edgeTo = new Integer[V];
        traversal = new List<>();
    }

    public DepthFirstSearch(GraphAL graphAL, int source) {
        this(graphAL.vertices(), source);
        dfs(graphAL);
    }

    public DepthFirstSearch(GraphAM graphAM, int source) {
        this(graphAM.vertices(), source);
        dfs(graphAM);
    }

    private void dfs(GraphAL graphAL) {
        Stack<Integer> s = new Stack<>();
        s.push(source);
        marked[source] = true;
        while (!s.isEmpty()) {
            int v = s.pop();
            traversal.pushBack(v);
            for (int w : graphAL.adj(v)) {
                if (!marked[w]) {
                    marked[v] = true;
                    edgeTo[w] = v;
                    s.push(w);
                }
            }
        }
    }

    private void dfs(GraphAM graphAM) {
        Stack<Integer> s = new Stack<>();
        s.push(source);
        marked[source] = true;
        while (!s.isEmpty()) {
            int v = s.pop();
            traversal.pushBack(v);
            for (int w = 0; w < graphAM.vertices(); w++) {
                if (graphAM.adj(v)[w] && !marked[w]) {
                    marked[v] = true;
                    edgeTo[w] = v;
                    s.push(w);
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
            path.pushFront(i);
        }
        path.pushFront(source);
        return path;
    }
}