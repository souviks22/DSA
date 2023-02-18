package souvik.sort;

import java.util.Random;

public class Quick {
    private Quick() {
    }

    private static <Key extends Comparable<Key>> boolean less(Key[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private static <Key extends Comparable<Key>> boolean greater(Key[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) > 0;
    }

    private static <Key extends Comparable<Key>> void swap(Key[] arr, int i, int j) {
        Key temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static <Key extends Comparable<Key>> void shuffle(Key[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, random.nextInt(i + 1));
        }
    }

    private static <Key extends Comparable<Key>> int partition(Key[] arr, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (true) {
            while (!less(arr, lo, i)) {
                if (++i == hi) break;
            }
            while (!less(arr, j, lo)) {
                if (--j == lo) break;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static <Key extends Comparable<Key>> void sort(Key[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    public static <Key extends Comparable<Key>> void sort(Key[] arr) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static <Key extends Comparable<Key>> Key select(Key[] arr, int k) {
        int i = 0, j = arr.length - 1;
        while (true) {
            int p = partition(arr, i, j);
            if (p < k) i = p + 1;
            else if (p > k) j = p - 1;
            else return arr[p];
        }
    }

    private static class Range {
        public int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static <Key extends Comparable<Key>> Range threeWayPartition(Key[] arr, int lo, int hi) {
        int k = lo, i = lo + 1, j = hi;
        while (i <= j) {
            if (less(arr, i, k)) swap(arr, i++, k++);
            else if (greater(arr, i, k)) swap(arr, i, j--);
            else i++;
        }
        return new Range(k, i);
    }

    private static <Key extends Comparable<Key>> void threeWaySort(Key[] arr, int lo, int hi) {
        if (lo >= hi) return;
        Range range = threeWayPartition(arr, lo, hi);
        threeWaySort(arr, lo, range.start - 1);
        threeWaySort(arr, range.end + 1, hi);
    }

    public static <Key extends Comparable<Key>> void threeWaySort(Key[] arr) {
        shuffle(arr);
        threeWaySort(arr, 0, arr.length - 1);
    }
}
