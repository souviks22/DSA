package souvik.bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        public Key key;
        public Value value;
        public Node left, right;
        public int size = 1;

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

    public void insert(Key key, Value value) {
        this.root = insert(this.root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, key, value);
        else if (cmp > 0) node.right = insert(node.right, key, value);
        else node.value = value;
        node.size = size(node.left) + 1 + size(node.right);
        return node;
    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return floor(node.left, key);
        Key right = floor(node.right, key);
        return right == null ? node.key : right;
    }

    public Key ceil(Key key) {
        return ceil(root, key);
    }

    private Key ceil(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return ceil(node.right, key);
        Key left = ceil(node.left, key);
        return left == null ? node.key : left;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return rank(node.left, key);
        if (cmp > 0) return 1 + size(node.left) + rank(node.right, key);
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
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = remove(node.left, key);
        else if (cmp > 0) node.right = remove(node.right, key);
        else if (node.left == null) return node.right;
        else if (node.right == null) return node.left;
        else {
            Node mini = findMin(node.right);
            mini.left = node.left;
            mini.right = removeMin(node.right);
            return mini;
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer,String> bst = new BinarySearchTree<>();
        bst.insert(5,"five");
        bst.insert(1,"one");
        bst.insert(2,"two");
        bst.insert(8,"eight");
        bst.insert(6,"six");
        System.out.println(bst.find(8));
        System.out.println(bst.floor(3));
        System.out.println(bst.ceil(3));
        System.out.println(bst.rank(3));
        bst.remove(8);
        System.out.println(bst.find(8));
    }
}
