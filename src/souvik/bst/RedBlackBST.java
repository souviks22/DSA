package souvik.bst;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private final boolean RED = true, BLACK = false;

    private class Node {
        public Key key;
        public Value value;
        public boolean color = RED;
        public Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
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
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = node.right.color = BLACK;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
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

    public static void main(String[] args) {
        int n = 10000;
        BinarySearchTree<Integer,String> bst = new BinarySearchTree<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; ++i) bst.insert(i,"string");
        long end = System.currentTimeMillis();
        System.out.println("BST : " + (end - start) + " ms");
        RedBlackBST<Integer,String> rbt = new RedBlackBST<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; ++i) rbt.insert(i,"string");
        end = System.currentTimeMillis();
        System.out.println("RBT : " + (end - start) + " ms");
    }
}
