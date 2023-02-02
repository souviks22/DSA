package souvik.bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        public Key key;
        public Value value;
        public Node left, right;
        public int size;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            size = 1;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public Value find(Key key) {
        Node temp = root;
        while (temp != null) {
            if (key.compareTo(temp.key) < 0) temp = temp.left;
            else if (key.compareTo(temp.key) > 0) temp = temp.right;
            else return temp.value;
        }
        return null;
    }

    public void insert(Key key, Value value) {
        this.root = insert(this.root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        if (key.compareTo(node.key) < 0) node.left = insert(node.left, key, value);
        else if (key.compareTo(node.key) > 0) node.right = insert(node.right, key, value);
        else node.value = value;
        node.size = size(node.left) + 1 + size(node.right);
        return node;
    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node node, Key key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) return floor(node.left, key);
        if (key.compareTo(node.key) == 0) return node.key;
        Key possibleFloor = floor(node.right, key);
        if (possibleFloor != null) return possibleFloor;
        return node.key;
    }

    public Key ceil(Key key) {
        return ceil(root, key);
    }

    private Key ceil(Node node, Key key) {
        if (node == null) return null;
        if (key.compareTo(node.key) > 0) return ceil(node.right, key);
        if (key.compareTo(node.key) == 0) return node.key;
        Key possibleCeil = ceil(node.left, key);
        if (possibleCeil != null) return possibleCeil;
        return node.key;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (key.compareTo(node.key) < 0) return rank(node.left, key);
        if (key.compareTo(node.key) > 0) return size(node.left) + rank(node.right, key);
        return size(node.left);
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(Key key) {
        this.root = remove(this.root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) node.left = remove(node.left, key);
        else if (key.compareTo(node.key) > 0) node.right = remove(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node minOnRight = findMin(node.right);
            minOnRight.left = node.left;
            minOnRight.right = removeMin(node.right);
            return minOnRight;
        }
        return node;
    }
}
