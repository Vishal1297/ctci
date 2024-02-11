package org.vishal1297.ds.chapter_1.impl;

import java.util.Iterator;
import java.util.function.Supplier;

public class ArrayListImpl<T> implements Iterable<T> {
    private T[] internalArr;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 4;
    private int current;

    private int currentIndex = 0;

    public ArrayListImpl() {
        this.capacity = DEFAULT_CAPACITY;
        this.current = 0;
        this.internalArr = (T[]) new Object[capacity];
    }

    public ArrayListImpl(Object[] newArr) {
        this.internalArr = (T[]) newArr;
        this.current = newArr.length;
        this.capacity = this.current;
        grow();
    }

    public int getSize() {
        return current;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < current; i++) {
            sb.append(internalArr[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public void add(T element) {
        if (element == null) return;
        if (this.current == this.capacity) {
            grow();
        }
        this.internalArr[current++] = element;
    }

    public void add(T value, Integer index) {
        if (index == this.capacity) {
            add(value);
        } else {
            internalArr[index] = value;
            current++;
        }
    }

    public void grow() {
        this.capacity *= 2;
        T[] newArr = (T[]) new Object[this.capacity];
        System.arraycopy(this.internalArr, 0, newArr, 0, current);
        this.internalArr = newArr;
    }

    public T get(Integer index) {
        if (index < 0 || index >= current) {
            return null;
        }
        return internalArr[index];
    }

    public T remove(Integer index) {
        if (index < 0 || index >= this.current) {
            return null;
        }
        T removed = this.internalArr[index];
        this.internalArr[index] = null;
        System.arraycopy(this.internalArr, index + 1, this.internalArr, index, this.current - index - 1);
        --current;
        return removed;
    }

    @Override
    public Iterator<T> iterator() {
        return newIterator(() -> currentIndex < this.current
                ? this.internalArr[currentIndex++] : null);
    }

    private Iterator<T> newIterator(Supplier<T> supplier) {
        return new Iterator<>() {
            private T nextElement = supplier.get();

            @Override
            public boolean hasNext() {
                if(nextElement != null){
                    return true;
                }
                currentIndex = 0;
                return false;
            }

            @Override
            public T next() {
                T currentElement = nextElement;
                nextElement = supplier.get();
                return currentElement;
            }

            @Override
            public void remove() {
                if (!hasNext()) {
                    throw new IllegalStateException();
                }
                // TODO: Remove element from list
            }
        };
    }

    public static void main(String[] args) {
        ArrayListImpl<String> list = new ArrayListImpl<>();
        list.add("a");
        list.add("b", 1);
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        list.remove(0);
        list.remove(0);
        list.remove(0);
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String curr = iterator.next();
            if (curr.equalsIgnoreCase("d")) {
                iterator.remove();
            }
            System.out.print(curr + " ");
        }
    }
}