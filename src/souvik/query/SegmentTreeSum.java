package souvik.query;

import java.util.Random;
import java.util.stream.IntStream;

public class SegmentTreeSum {
    private final int[] tree;

    public SegmentTreeSum(int[] arr) {
        int n = arr.length;
        tree = new int[4*n+1];
        for (int i = 0; i < n; ++i) {
            update(i, arr[i]);
        }
    }

    public void update(int index, int value) {
        update(1, 0, tree.length/4 - 1, index, value);
    }

    private void update(int node, int left, int right, int i, int value) {
        if (i < left || i > right) return;
        if (left == right) {
            tree[node] = value;
            return;
        }
        int mid = left + (right - left) / 2;
        int leftNode = 2*node, rightNode = 2*node+1;
        update(leftNode, left, mid, i, value);
        update(rightNode, mid + 1, right, i, value);
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public long get(int lo, int hi) {
        return get(1, 0, tree.length/4 - 1, lo, hi);
    }

    private long get(int node, int left, int right, int lo, int hi) {
        if (lo > hi) return 0;
        if (lo == left && hi == right) return tree[node];
        int mid = left + (right - left) / 2;
        int leftNode = 2*node, rightNode = 2*node+1;
        long leftSum = get(leftNode, left, mid, lo, Math.min(hi, mid));
        long rightSum = get(rightNode, mid + 1, right, Math.max(lo, mid + 1), hi);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int n = 100000;
        SegmentTreeSum sum = new SegmentTreeSum(IntStream.range(0,n).toArray());
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int index = random.nextInt(n);
            int value = random.nextInt(n);
            sum.update(index,value);
            System.out.printf("Update: arr[%d] = %d%n", index, value);
            int left = random.nextInt(n);
            int right = random.nextInt(left,n);
            System.out.printf("Sum arr[%d:%d]: %d%n", left, right, sum.get(left,right));
        }
    }
}
