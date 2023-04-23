package souvik.string;

public class QuickMSD {
    private static final int R = 256;

    private QuickMSD() {
    }

    private static void exchange(MyString[] arr, int i, int j) {
        MyString temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(MyString[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }

    private static void sort(MyString[] arr, int lo, int hi, int d) {
        if (lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        char p = arr[lo].charAt(d);
        while (i <= gt) {
            if (arr[i].charAt(d) < p) exchange(arr, i++, lt++);
            else if (arr[i].charAt(d) > p) exchange(arr, i, gt--);
            else i++;
        }
        sort(arr, lo, lt - 1, d);
        sort(arr, lt, gt, d + 1);
        sort(arr, gt + 1, hi, d);
    }
}
