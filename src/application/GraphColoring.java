package application;

import souvik.graph.GraphAL;
import souvik.support.Queue;

import java.util.Arrays;

public class GraphColoring {
    private final int[] colored;
    private final Queue<int[]> ways;

    public GraphColoring(GraphAL graphAL, int colors) {
        colored = new int[graphAL.vertices()];
        ways = new Queue<>();
        for (int i = 0; i < colors; i++) {
            colored[0] = i;
            explore(1, colors);
        }
    }

    private void explore(int level, int colors) {
        if (level == colored.length) {
            ways.enqueue(Arrays.copyOf(colored, colored.length));
            return;
        }
        for (int i = 0; i < colors; i++) {
            if (colored[level - 1] == i) continue;
            colored[level] = i;
            explore(level + 1, colors);
        }
    }

    public boolean isColorable() {
        return !ways.isEmpty();
    }

    public Iterable<int[]> waysToColor() {
        if (ways.isEmpty()) return null;
        return ways;
    }
}
