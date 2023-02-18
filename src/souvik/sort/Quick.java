package souvik.sort;

public class Quick {
    private Quick() {
    }

    private static <Key extends Comparable<Key>> boolean less(Key[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private static <Key extends Comparable<Key>> void swap(Key[] arr, int i, int j) {
        Key temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static <Key extends Comparable<Key>> int partition(Key[] arr, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (true) {
            while (!less(arr, 0, i)) i++;
            while (!less(arr, j, 0)) j--;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, 0, j);
        return j;
    }

    private static <Key extends Comparable<Key>> void sort(Key[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    public static <Key extends Comparable<Key>> void sort(Key[] arr) {
        sort(arr, 0, arr.length - 1);
    }
}
