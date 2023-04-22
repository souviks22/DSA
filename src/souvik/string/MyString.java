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

    public char charAt(int index) {
        return values[offset + index];
    }

    public int indexOf(char c) {
        for (int i = offset; i < offset + length; i++) {
            if (values[i] == c) return i;
        }
        return -1;
    }

    public MyString substring(int from, int to) {
        return new MyString(values, offset + from, to - length);
    }

    public MyString substring(int from) {
        return substring(from, offset + length);
    }

    public MyString concat(MyString that) {
        char[] con = new char[this.length + that.length];
        int i = 0;
        for (int j = 0; i < this.length; j++) con[i++] = this.charAt(j);
        for (int j = 0; i < that.length; j++) con[i++] = that.charAt(j);
        return new MyString(con);
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

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(charAt(i));
        }
        System.out.println();
    }

    public int compareTo(MyString that) {
        int len = Math.min(this.length, that.length);
        for (int i = 0; i < len; i++) {
            if (this.charAt(i) < that.charAt(i)) return -1;
            if (this.charAt(i) > that.charAt(i)) return 1;
        }
        return Integer.compare(this.length, that.length);
    }
}
