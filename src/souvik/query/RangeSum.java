package souvik.query;

import java.util.Random;
import java.util.stream.IntStream;

public class RangeSum {
    private final FenwickTreeSum f1, f2;
    private final int[] prefix;

    public RangeSum(int[] arr) {
        int n = arr.length;
        f1 = new FenwickTreeSum(n);
        f2 = new FenwickTreeSum(n);
        prefix = new int[n+1];
        for (int i = 0; i < n; ++i) {
            prefix[i+1] = prefix[i] + arr[i];
        }
    }

    public void increase(int left, int right, int delta) {
        f1.increase(left, delta);
        f1.increase(right+1, -delta);
        f2.increase(left, (left-1)*delta);
        f2.increase(right+1, -right*delta);
    }

    public void decrease(int left, int right, int delta) {
        increase(left, right, -delta);
    }

    public long get(int index) {
        return prefix[index+1] + index * f1.get(index) - f2.get(index);
    }

    public long get(int left, int right) {
        return get(right) - get(left-1);
    }

    public static void main(String[] args) {
        int n = 5;
        RangeSum sum = new RangeSum(IntStream.range(0,n).toArray());
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int left = random.nextInt(n);
            int right = random.nextInt(left,n);
            int delta = random.nextInt(n);
            if (random.nextBoolean()) {
                sum.increase(left, right, delta);
                System.out.printf("Update: arr[%d:%d] increased by %d%n", left, right, delta);
            } else {
                sum.decrease(left, right, delta);
                System.out.printf("Update: arr[%d:%d] decreased by %d%n", left, right, delta);
            }
            left = random.nextInt(n);
            right = random.nextInt(left,n);
            System.out.printf("Sum arr[%d:%d]: %d%n", left, right, sum.get(left,right));
        }
    }
}
