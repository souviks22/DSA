package souvik.graphs.adjList;

import souvik.support.List;
import souvik.support.Queue;

public class BreadthFirstSearch {
    private final int source;
    private final boolean[] marked;
    private final Integer[] edgeTo;
    private final List<Integer> traversal;

    public BreadthFirstSearch(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.getVertex()];
        edgeTo = new Integer[graph.getVertex()];
        traversal = new List<>();
        bfs(graph);
    }

    private void bfs(Graph graph) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(source);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            marked[v] = true;
            traversal.push_back(v);
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
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