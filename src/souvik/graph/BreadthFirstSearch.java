package souvik.graph;

import souvik.support.List;
import souvik.support.Queue;

public class BreadthFirstSearch {
    private final int source;
    private final boolean[] marked;
    private final Integer[] edgeTo;
    private final List<Integer> traversal;

    private BreadthFirstSearch(int V, int source) {
        this.source = source;
        marked = new boolean[V];
        edgeTo = new Integer[V];
        traversal = new List<>();
    }

    public BreadthFirstSearch(GraphAL graphAL, int source) {
        this(graphAL.vertices(), source);
        bfs(graphAL);
    }

    public BreadthFirstSearch(GraphAM graphAM, int source) {
        this(graphAM.vertices(), source);
        bfs(graphAM);
    }

    private void bfs(GraphAL graphAL) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(source);
        marked[source] = true;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            traversal.pushBack(v);
            for (int w : graphAL.adj(v)) {
                if (!marked[w]) {
                    marked[v] = true;
                    edgeTo[w] = v;
                    q.enqueue(w);
                }
            }
        }
    }

    private void bfs(GraphAM graphAM) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(source);
        marked[source] = true;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            traversal.pushBack(v);
            for (int w = 0; w < graphAM.vertices(); w++) {
                if (graphAM.adj(v)[w] && !marked[w]) {
                    marked[v] = true;
                    edgeTo[w] = v;
                    q.enqueue(w);
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
