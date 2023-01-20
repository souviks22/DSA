package souvik.graph;

import souvik.support.List;
import souvik.support.Stack;

public class DepthFirstSearch {
    private final int source;
    private final boolean[] marked;
    private final Integer[] edgeTo;
    private final List<Integer> traversal;

    private DepthFirstSearch(int vertex, int source) {
        this.source = source;
        marked = new boolean[vertex];
        edgeTo = new Integer[vertex];
        traversal = new List<>();
    }

    public DepthFirstSearch(GraphAL graphAL, int source) {
        this(graphAL.getVertex(), source);
        dfs(graphAL);
    }

    public DepthFirstSearch(GraphAM graphAM, int source) {
        this(graphAM.getVertex(), source);
        dfs(graphAM);
    }

    private void dfs(GraphAL graphAL) {
        Stack<Integer> s = new Stack<>();
        s.push(source);
        while (!s.isEmpty()) {
            int v = s.pop();
            marked[v] = true;
            traversal.pushBack(v);
            for (int w : graphAL.adj(v)) {
                if (!marked[w]) {
                    s.push(w);
                    edgeTo[w] = v;
                }
            }
        }
    }

    private void dfs(GraphAM graphAM) {
        Stack<Integer> s = new Stack<>();
        s.push(source);
        while (!s.isEmpty()) {
            int v = s.pop();
            marked[v] = true;
            traversal.pushBack(v);
            for (int w = 0; w < graphAM.getVertex(); w++) {
                if (graphAM.adj(v)[w] && !marked[w]) {
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
            path.pushFront(i);
        }
        path.pushFront(source);
        return path;
    }
}