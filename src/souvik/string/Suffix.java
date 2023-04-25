package souvik.string;

public class Suffix {
    private Suffix() {
    }

    public static MyString[] elements(MyString str) {
        MyString[] arr = new MyString[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i);
        }
        return arr;
    }

    private static int longestCommonPrefixLength(MyString str1, MyString str2) {
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) return i;
        }
        return len;
    }

    public static MyString longestCommonPrefix(MyString str1, MyString str2) {
        int len = longestCommonPrefixLength(str1, str2);
        if (len == 0) return null;
        return str1.substring(0, len);
    }

    public static MyString longestRepeatedSubstring(MyString str) {
        MyString[] arr = elements(str);
        QuickMSD.sort(arr);
        int maxlen = 0, index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int len = longestCommonPrefixLength(arr[i], arr[i + 1]);
            if (len > maxlen) {
                index = i;
                maxlen = len;
            }
        }
        return arr[index].substring(0, maxlen);
    }
}
