package souvik.string;

import java.util.Arrays;

public class LSD {
    private static final int R = 256;

    private LSD() {
    }

    public static void sort(MyString[] arr) {
        int maxLength = Integer.MIN_VALUE;
        for (MyString str : arr) {
            if (str.length() > maxLength) maxLength = str.length();
        }
        for (int d = maxLength - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            MyString[] aux = Arrays.copyOf(arr, arr.length);
            for (MyString str : aux) count[str.charAt(d) + 1]++;
            for (int i = 0; i < R; i++) count[i + 1] += count[i];
            for (MyString str : aux) arr[count[str.charAt(d)]++] = str;
        }
    }
}
