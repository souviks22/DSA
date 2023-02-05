package souvik.bst;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private final boolean RED = true;

    private class Node {
        public Key key;
        public Value value;
        public boolean color;
        public Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            color = RED;
            left = null;
            right = null;
        }
    }

    public RedBlackBST(Node root) {
        this.root = root;
    }

    public RedBlackBST() {
        this(null);
    }

    public Value find(Key key) {
        Node temp = root;
        while (temp != null) {
            int cmp = key.compareTo(temp.key);
            if (cmp < 0) temp = temp.left;
            else if (cmp > 0) temp = temp.right;
            else return temp.value;
        }
        return null;
    }

    private Node rotateLeft(Node node) {
        assert node.right.color == RED;
        Node rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
        rightNode.color = node.color;
        node.color = RED;
        return rightNode;
    }

    private Node rotateRight(Node node) {
        assert node.left.color == RED;
        Node leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        leftNode.color = node.color;
        node.color = RED;
        return leftNode;
    }

    private void flipColor(Node node) {
        assert node.color == !RED && node.left.color == RED && node.right.color == RED;
        node.color = RED;
        node.left.color = node.right.color = !RED;
    }

    private boolean isRed(Node node) {
        return node.color == RED;
    }

    public void insert(Key key, Value value) {
        this.root = insert(this.root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, key, value);
        else if (cmp > 0) node.right = insert(node.right, key, value);
        else node.value = value;
        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColor(node);
        return node;
    }
}
