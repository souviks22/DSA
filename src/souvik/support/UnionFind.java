package souvik.support;

public class UnionFind {
    private final Integer[] arr, size;
    private final int elements;

    public UnionFind(int elements) {
        this.elements = elements;
        arr = new Integer[elements];
        size = new Integer[elements];
        for (int i = 0; i < elements; i++) {
            arr[i] = i;
            size[i] = 1;
        }
    }

    private int root(int s) {
        while (s != arr[s]) {
            s = arr[s];
            arr[s] = arr[arr[s]];
        }
        return s;
    }

    public int find(int s) {
        if (s >= elements) throw new ArrayIndexOutOfBoundsException();
        return root(s);
    }

    public boolean isConnected(int v, int w) {
        return find(v) == find(w);
    }

    public void union(int v, int w) {
        int p = root(v), q = root(w);
        if(size[v] < size[w]){
            arr[p] = arr[q];
            size[q] += size[v];
        } else {
            arr[q] = arr[p];
            size[p] += size[q];
        }
    }
}
