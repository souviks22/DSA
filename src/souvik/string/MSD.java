package souvik.string;

public class MSD {
    private static final int R = 256;

    private MSD() {
    }

    public static void sort(MyString[] arr) {
        MyString[] aux = new MyString[arr.length];
        sort(arr, aux, 0, arr.length - 1, 0);
    }

    private static void sort(MyString[] arr, MyString[] aux, int lo, int hi, int d) {
        if (lo >= hi) return;

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) count[arr[i].charAt(d) + 2]++;
        for (int i = 0; i < R + 1; i++) count[i + 1] += count[i];
        for (int i = lo; i <= hi; i++) aux[lo + count[arr[i].charAt(d) + 1]++] = arr[i];
        for (int i = lo; i <= hi; i++) arr[i] = aux[i];

        for (int i = 0; i < R; i++) {
            sort(arr, aux, lo + count[i], lo + count[i + 1] - 1, d + 1);
        }
    }
}
