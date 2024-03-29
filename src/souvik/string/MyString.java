package souvik.string;

public final class MyString implements Comparable<MyString> {
    private final char[] values;
    private final int offset, length;

    public MyString(char[] values, int offset, int length) {
        this.values = values;
        this.offset = offset;
        this.length = length;
    }

    public MyString(char... values) {
        this(values, 0, values.length);
    }

    public MyString(String str) {
        this(str.toCharArray());
    }

    public char charAt(int index) {
        if (index >= length) return '\0';
        return values[offset + index];
    }

    public int length() {
        return length;
    }

    public int indexOf(char c) {
        for (int i = 0; i < length; i++) {
            if (charAt(i) == c) return i;
        }
        return -1;
    }

    public MyString substring(int from, int to) {
        if (to > length) return null;
        return new MyString(values, offset + from, to - from);
    }

    public MyString substring(int from) {
        return substring(from, length);
    }

    public MyString concat(MyString that) {
        char[] con = new char[this.length + that.length];
        int i = 0;
        for (int j = 0; j < this.length; j++) con[i++] = this.charAt(j);
        for (int j = 0; j < that.length; j++) con[i++] = that.charAt(j);
        return new MyString(con);
    }

    public MyString concat(char... values) {
        return concat(new MyString(values));
    }

    public MyString concat(String str) {
        return concat(str.toCharArray());
    }

    public MyString lowercase() {
        char[] lo = new char[length];
        int i = 0;
        for (int j = 0; j < length; j++) lo[i++] = Character.toLowerCase(charAt(j));
        return new MyString(lo);
    }

    public MyString uppercase() {
        char[] up = new char[length];
        int i = 0;
        for (int j = 0; j < length; j++) up[i++] = Character.toUpperCase(charAt(j));
        return new MyString(up);
    }

    @Override
    public String toString() {
        return new String(values, offset, length);
    }

    @Override
    public int compareTo(MyString that) {
        int len = Math.min(this.length, that.length);
        for (int i = 0; i < len; i++) {
            if (this.charAt(i) < that.charAt(i)) return -1;
            if (this.charAt(i) > that.charAt(i)) return 1;
        }
        return Integer.compare(this.length, that.length);
    }
}
