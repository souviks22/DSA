package souvik.support;

import java.util.Iterator;

public class List<Key> implements Iterable<Key> {
    private Node head;
    private int size;

    private class Node {
        public Key key;
        public Node next;

        public Node(Key key) {
            this.key = key;
            next = null;
        }
    }

    public List() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        return size;
    }

    public boolean contains(Key key) {
        Node temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) return true;
            temp = temp.next;
        }
        return false;
    }

    public void pushFront(Key key) {
        if (isEmpty()) {
            head = new Node(key);
        } else {
            Node temp = new Node(key);
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void pushBack(Key key) {
        if (isEmpty()) {
            head = new Node(key);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(key);
        }
        size++;
    }

    public Key popFront() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        Key key = head.key;
        head = head.next;
        size--;
        return key;
    }

    public Key popBack() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        if (this.size == 1) {
            Key key = head.key;
            head = null;
            size--;
            return key;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Key key = temp.next.key;
        temp.next = null;
        size--;
        return key;
    }

    private class ListIterator implements Iterator<Key> {
        private Node current;

        public ListIterator() {
            current = head;
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
        return new ListIterator();
    }

}
