package org.vishal1297.ds.chapter_3.problems;

import java.util.Objects;

public class KStacksUsingArray<T extends Comparable<T>> {

    private final StackNode[] stacks;
    private final int[] stackPointers;
    private final Integer size;
    private final Integer totalStacks;

    private static final Integer INITIAL_SIZE = 10;
    private static final Integer INITIAL_STACK_COUNT = 5;

    public KStacksUsingArray() {
        this.size = INITIAL_SIZE;
        this.totalStacks = INITIAL_STACK_COUNT;
        this.stacks = new StackNode[this.size];
        this.stackPointers = new int[this.size];
    }

    public KStacksUsingArray(Integer stacks, Integer size) {
        if (size < 1) this.size = INITIAL_SIZE;
        else this.size = size;
        if (stacks < 1) this.totalStacks = INITIAL_STACK_COUNT;
        else this.totalStacks = stacks;
        this.stacks = new StackNode[this.size];
        this.stackPointers = new int[this.size];
    }

    public void push(Integer stackNumber, T data) {
        if (stackNumber < 1 || stackNumber > this.totalStacks)
            throw new IllegalArgumentException("Invalid stack number : " + stackNumber);
        if (stackPointers[stackNumber - 1] > INITIAL_SIZE) throw new IllegalStateException("Stack overflow.");
        pushToStack(data, stackNumber);
    }

    private void pushToStack(T data, Integer stackNumber) {
        StackNode top = stacks[stackNumber - 1];
        StackNode<T> node = new StackNode<>(data);
        node.setNext(top);
        stacks[stackNumber - 1] = node;
        stackPointers[stackNumber - 1] += 1;
    }

    public Object pop(Integer stackNumber) {
        if (stackNumber < 1 || stackNumber > this.totalStacks)
            throw new IllegalArgumentException("Invalid stack number : " + stackNumber);
        if (stackPointers[stackNumber - 1] <= 0) throw new IllegalStateException("Stack underflow.");
        if (stacks[stackNumber - 1] == null) throw new IllegalStateException("Stack is empty.");
        return popFromStack(stackNumber);
    }

    private Object popFromStack(Integer stackNumber) {
        StackNode temp = stacks[stackNumber - 1];
        Object popped = temp.getData();
        temp.setData(null);
        stacks[stackNumber - 1] = temp.getNext();
        stackPointers[stackNumber - 1] -= 1;
        return popped;
    }

    private Object peek(Integer stackNumber) {
        if (stackNumber < 1 || stackNumber > this.totalStacks)
            throw new IllegalArgumentException("Invalid stack number : " + stackNumber);
        if (stackPointers[stackNumber - 1] > INITIAL_SIZE) throw new IllegalStateException("Stack overflow.");
        return stacks[stackNumber - 1].getData();
    }

    public void print(Integer stackNumber){
        StackNode<T> temp = stacks[stackNumber - 1];;
        if (temp == null) return;
        System.out.println("Stack " + stackNumber + " elements : ");
        while (temp != null && temp.getNext() != null){
            if (temp.getData() != null) {
                System.out.print(temp.getData() + " => ");
                temp = temp.getNext();
            }
        }
        if (temp != null && temp.getData() != null) {
            System.out.print(temp.getData());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        KStacksUsingArray<Integer> impl = new KStacksUsingArray<>();
        impl.push(1, 10);
        impl.push(1, 111);

        impl.push(2, 12);

        System.out.println("Peek at stack " + 1 + " : " + impl.peek(1));
        System.out.println("Peek at stack " + 2 + " : " + impl.peek(2));

        System.out.println("Pop at stack " + 1 + " : " + impl.pop(1));
        System.out.println("Pop at stack " + 2 + " : " + impl.pop(2));

        impl.push(3, 100);
        impl.push(3, 200);

        System.out.println("Peek at stack " + 3 + " : " + impl.peek(3));
        System.out.println("Pop at stack " + 3 + " : " + impl.pop(3));

        impl.push(3, 400);

        impl.print(1);
        impl.print(2);
        impl.print(3);
    }

    static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode() {
        }

        public StackNode(T data, StackNode<T> next) {
            this.data = data;
            this.next = next;
        }

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(StackNode<T> next) {
            this.next = next;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public T getData() {
            return data;
        }
    }

}
