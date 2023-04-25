package souvik.string;

public class Trie<Value> {
    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        private Object value;
        private final Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        return (node == null) ? null : (Value) node.value;
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
}
