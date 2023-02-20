package souvik.graph;

public class ConnectedComponents {
    private final int[] id;
    private final boolean[] marked;
    private int count;

    public ConnectedComponents(GraphAL graphAL) {
        id = new int[graphAL.vertices()];
        marked = new boolean[graphAL.vertices()];
    }
}
