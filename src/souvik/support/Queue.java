package souvik.support;

import java.util.Iterator;

public class Queue<Key> implements Iterable<Key> {
    private Node front, back;

    private class Node {
        public Key key;
        public Node next;

        public Node(Key key) {
            this.key = key;
            next = null;
        }
    }

    public Queue() {
        front = back = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Key key) {
        if (isEmpty()) {
            front = back = new Node(key);
            return;
        }
        back.next = new Node(key);
        back = back.next;
    }

    public Key dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        if (front == back) {
            Key key = front.key;
            front = back = null;
            return key;
        }
        Key key = front.key;
        front = front.next;
        return key;
    }

    private class QueueIterator implements Iterator<Key> {
        private Node current;

        public QueueIterator() {
            current = front;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Key next() {
            Key key = current.key;
            current = current.next;
            return key;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return new QueueIterator();
    }
}
