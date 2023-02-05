package souvik.support;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int size, capacity;

    public MaxPQ() {
        capacity = 1;
        pq = (Key[]) new Comparable[capacity];
    }

    private void resizePq(double factor) {
        capacity = (int) (capacity * factor);
        pq = Arrays.copyOf(pq, capacity);
    }

    private void swap(int i, int j) {
        Key temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        int i = k * 2;
        while (i <= size) {
            if (i < size && less(i, i + 1)) i++;
            if (!less(i / 2, i)) break;
            swap(i, i / 2);
            i *= 2;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Key key) {
        if (size == capacity) resizePq(2);
        pq[size++] = key;
        swim(size);
    }

    public Key dequeue() {
        if (size == capacity / 4) resizePq(0.5);
        Key key = pq[0];
        swap(1, size--);
        sink(1);
        pq[size] = null;
        return key;
    }
}
