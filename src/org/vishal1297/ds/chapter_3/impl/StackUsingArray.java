package org.vishal1297.ds.chapter_3.impl;

public class StackUsingArray {

    private static final Integer INITIAL_SIZE = 10;
    private final Integer size;
    private Integer current = 0;
    private final Object[] stack;

    public StackUsingArray() {
        this.size = INITIAL_SIZE;
        this.stack = new Object[this.size];
    }

    public StackUsingArray(Integer size) {
        if (size < 1) this.size = INITIAL_SIZE;
        else this.size = size;
        this.stack = new Object[this.size];
    }

    public Boolean push(Object element) {
        if (this.size <= current) throw new IllegalStateException("Stack overflow.");
        System.out.println("Insert : " + element);
        stack[current] = element;
        current++;
        return true;
    }

    public Object pop() {
        if (current <= 0) throw new IllegalStateException("Stack underflow.");
        Object popped = stack[current - 1];
        stack[current - 1] = 0;
        current--;
        return popped;
    }

    public Object peek() {
        if (current <= 0) throw new IllegalStateException("Stack is empty.");
        return stack[current - 1];
    }

    public Integer getSize() {
        return size;
    }

    public Integer getCurrentSize() {
        return current;
    }

    public void print() {
        System.out.println("\nStack elements : ");
        for (int index = 0; index < current; index++)
            System.out.print(stack[index] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArray stackImpl = new StackUsingArray(8);
        stackImpl.push(10);
        System.out.println("Size : " + stackImpl.getSize());
        stackImpl.push(20);
        stackImpl.push(30);
        System.out.println("Peek : " + stackImpl.peek());
        stackImpl.push(40);
        stackImpl.push(50);
        System.out.println("Peek : " + stackImpl.peek());

        System.out.println("Pop : " + stackImpl.pop());
        System.out.println("Pop : " + stackImpl.pop());

        stackImpl.print();
    }
}
