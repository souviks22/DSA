package souvik.query;

import java.util.Random;
import java.util.stream.IntStream;

public class FenwickTreeSum {
    private final long[] tree;

    public FenwickTreeSum(int[] arr) {
        int n = arr.length;
        tree = new long[n+1];
        for (int i = 0; i < n; ++i) {
            update(i, arr[i]);
        }
    }

    public FenwickTreeSum(int n) {
        this(new int[n]);
    }

    public void increase(int index, int delta) {
        for (int i = index+1; i < tree.length; i += i & -i) {
            tree[i] += delta;
        }
    }

    public void update(int index, int value) {
        int delta = value - (int) get(index, index);
        increase(index, delta);
    }

    public long get(int index) {
        long sum = 0;
        for (int i = index+1; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }

    public long get(int left, int right) {
        return get(right) - get(left-1);
    }

    public static void main(String[] args) {
        int n = 100000;
        FenwickTreeSum sum = new FenwickTreeSum(IntStream.range(0,n).toArray());
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
