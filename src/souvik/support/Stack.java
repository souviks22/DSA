package souvik.support;

import java.util.Iterator;

public class Stack<Key> implements Iterable<Key> {
    private Node top;

    private class Node {
        public Key key;
        public Node next;

        public Node(Key key) {
            this.key = key;
            next = null;
        }
    }

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Key key) {
        if (isEmpty()) {
            top = new Node(key);
            return;
        }
        Node temp = new Node(key);
        temp.next = top;
        top = temp;
    }

    public Key pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        Key key = top.key;
        top = top.next;
        return key;
    }

    private class StackIterator implements Iterator<Key> {
        private Node current;

        public StackIterator() {
            current = top;
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
        return new StackIterator();
    }
}
