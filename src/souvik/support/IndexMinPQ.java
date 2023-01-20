package souvik.support;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private final Integer[] pq, qp;
    private final Key[] keys;
    private int size;

    public IndexMinPQ(int V, Key[] keys) {
        pq = new Integer[V];
        qp = new Integer[V];
        this.keys = keys;
    }

    private void swap(int i, int j) {
        int temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
        temp = qp[pq[i - 1]];
        qp[pq[i - 1]] = qp[pq[j - 1]];
        qp[pq[j - 1]] = temp;
    }

    private boolean greater(int i, int j) {
        return keys[pq[i - 1]].compareTo(keys[pq[j - 1]]) > 0;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        int i = k * 2;
        while (i <= size) {
            if (i < size && greater(i, i + 1)) i++;
            if (!greater(i / 2, i)) break;
            swap(i, i / 2);
            i *= 2;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int v) {
        pq[size++] = v;
        qp[v] = size;
        swim(size);
    }

    public int dequeue() {
        int key = pq[0];
        swap(1, size--);
        sink(1);
//        qp[pq[size]] = null;
//        pq[size] = null;
        return key;
    }

    public Key keys(int i) {
        return keys[i];
    }

    public void decreaseKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
    }

    public void increaseKey(int i, Key key) {
        keys[i] = key;
        sink(qp[i]);
    }
}
