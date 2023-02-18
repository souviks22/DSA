package souvik.sort;

public class Merge {
    private static <Key extends Comparable<Key>> boolean less(Key[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private static <Key extends Comparable<Key>> void merge(Key[] arr, Key[] aux, int lo, int mid, int hi) {
        if (!less(arr, mid + 1, mid)) return;
        for (int i = lo; i <= hi; i++) aux[i] = arr[i];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux, j, i)) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    private static <Key extends Comparable<Key>> void sort(Key[] arr, Key[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    public static <Key extends Comparable<Key>> void sort(Key[] arr) {
        Key[] aux = (Key[]) new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }
}
