package souvik.string;

import souvik.support.Queue;

public class Trie<Value> {
    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        private Object value;
        private final Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return (Value) node.value;
    }

    private Node get(Node node, String key, int d) {
        if (node == null) return null;
        if (d == key.length()) return node;
        return get(node.next[key.charAt(d)], key, d + 1);
    }

    public void put(String key, int value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, int value, int d) {
        if (node == null) node = new Node();
        if (d == key.length()) node.value = value;
        else node.next[key.charAt(d)] = put(node.next[key.charAt(d)], key, value, d + 1);
        return node;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int d) {
        if (node == null) return null;
        if (d == key.length()) node.value = null;
        else node.next[key.charAt(d)] = delete(node.next[key.charAt(d)], key, d + 1);
        return node;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new Queue<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node node, String prefix, Queue<String> queue) {
        if (node == null) return;
        if (node.value != null) queue.enqueue(prefix);
        for (char c = 0; c < R; c++) {
            collect(node.next[c], prefix + c, queue);
        }
    }

    public Iterable<String> keysStartWith(String prefix) {
        Queue<String> queue = new Queue<>();
        Node node = get(root, prefix, 0);
        if (node == null) return null;
        collect(node, prefix, queue);
        return queue;
    }

    public String longestKeyIn(String domain) {
        int len = search(root, domain, 0, 0);
        if (len == 0) return null;
        return domain.substring(0, len);
    }

    private int search(Node node, String domain, int d, int length) {
        if (node == null) return length;
        if (node.value != null) length = d;
        return search(node.next[domain.charAt(d)], domain, d + 1, length);
    }
}
