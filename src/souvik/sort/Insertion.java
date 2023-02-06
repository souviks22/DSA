package souvik.sort;

public class Insertion {
    private static <Key extends Comparable<Key>> boolean less(Key[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private static <Key extends Comparable<Key>> void swap(Key[] arr, int i, int j) {
        Key temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <Key extends Comparable<Key>> void sort(Key[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr, j, j - 1)) swap(arr, j, j - 1);
                else break;
            }
        }
    }
}
