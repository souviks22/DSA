package souvik.string;

public class LSD {
    private static final int R = 256;

    private LSD() {
    }

    public static void sort(MyString[] arr) {
        int maxLength = Integer.MIN_VALUE;
        for (MyString str : arr) {
            if (str.length() > maxLength) maxLength = str.length();
        }
        int[] count = new int[R + 1];
        MyString[] aux = new MyString[arr.length];
        for (int d = maxLength - 1; d >= 0; d--) {
            for (int i = 0; i < R + 1; i++) count[i] = 0;
            for (MyString str : arr) count[str.charAt(d) + 1]++;
            for (int i = 0; i < R; i++) count[i + 1] += count[i];
            for (MyString str : arr) aux[count[str.charAt(d)]++] = str;
            for (int i = 0; i < arr.length; i++) arr[i] = aux[i];
        }
    }
}
