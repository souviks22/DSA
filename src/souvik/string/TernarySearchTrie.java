package souvik.string;

public class TernarySearchTrie {
    private Node root;

    public TernarySearchTrie() {
        root = null;
    }

    private static class Node {
        private final char letter;
        private Integer value;
        private Node left, mid, right;

        public Node(char letter) {
            this.letter = letter;
        }
    }

    public Integer get(String key) {
        return get(root, key, 0);
    }

    private Integer get(Node node, String key, int d) {
        if (node == null) return null;
        char c = key.charAt(d);
        if (c < node.letter) return get(node.left, key, d);
        if (c > node.letter) return get(node.right, key, d);
        if (d == key.length() - 1) return node.value;
        return get(node.mid, key, d + 1);
    }

    public void put(String key, int value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, int value, int d) {
        char c = key.charAt(d);
        if (node == null) node = new Node(c);
        if (c < node.letter) node.left = put(node.left, key, value, d);
        else if (c > node.letter) node.right = put(node.right, key, value, d);
        else if (d == key.length() - 1) node.value = value;
        else node.mid = put(node.mid, key, value, d + 1);
        return node;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int d) {
        if (root == null) return null;
        char c = key.charAt(d);
        if (c < node.letter) node.left = delete(node.left, key, d);
        else if (c > node.letter) node.right = delete(node.right, key, d);
        else if (d == key.length() - 1) node.value = null;
        else node.mid = delete(node.mid, key, d + 1);
        return node;
    }
}
