package org.vishal1297.ds.chapter_1.impl;

public class StringBuilderImpl {

    private char[] buffer;
    private int capacity;
    private int length;

    public StringBuilderImpl() {
        this.capacity = 16;
        this.buffer = new char[capacity];
        this.length = 0;
    }

    public StringBuilderImpl(String str) {
        this.buffer = str.toCharArray();
        this.length = str.length();
        ensureCapacity(this.length);
    }

    @Override
    public String toString() {
        return new String(buffer, 0, this.length);
    }

    public void ensureCapacity(int requiredLength) {
        while (this.length + requiredLength > capacity) {
            expandBuffer();
        }
    }

    public void expandBuffer() {
        this.capacity *= 2;
        char[] tempBuffer = new char[this.capacity];
        System.arraycopy(buffer, 0, tempBuffer, 0, buffer.length);
        this.buffer = tempBuffer;
    }

    public StringBuilderImpl append(String str) {
        char[] charArr = str.toCharArray();
        ensureCapacity(charArr.length);
        for (char ch : charArr) {
            buffer[length++] = ch;
        }
        return this;
    }

    public StringBuilderImpl append(char ch) {
        ensureCapacity(this.length);
        buffer[length++] = ch;
        return this;
    }

    public StringBuilderImpl deleteCharAt(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        System.arraycopy(this.buffer, index + 1, this.buffer, index, this.length - index - 1);
        --this.length;
        this.buffer[length] = '\u0000';
        return this;
    }

    public Boolean isEmpty() {
        return length == 0;
    }

    public Integer size() {
        return length;
    }


    public static void main(String[] args) {
        StringBuilderImpl impl = new StringBuilderImpl();
        impl.append("abc").append('a');
        System.out.println(impl);
        impl.deleteCharAt(1);
        impl.deleteCharAt(1);
        impl.deleteCharAt(1);
        impl.deleteCharAt(0);
        System.out.println(impl.buffer[0]);
        System.out.println(impl.isEmpty());
        System.out.println(impl.size());
    }
}
