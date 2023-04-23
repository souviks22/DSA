package souvik.string;

import java.util.Arrays;

public class KeyIndexedCount {
    private KeyIndexedCount() {
    }

    public static void sort(char[] arr) {
        final int R = 256;
        int[] count = new int[R + 1];
        char[] aux = Arrays.copyOf(arr, arr.length);
        for (char c : aux) count[c + 1]++;
        for (int i = 0; i < R; i++) count[i + 1] += count[i];
        for (char c : aux) arr[count[c]++] = c;
    }

    public static char[] sort(String str) {
        char[] arr = str.toCharArray();
        sort(arr);
        return arr;
    }
}
