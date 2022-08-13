package org.vishal1297.ds.chapter_3.impl;

public class QueueUsingArray {

    private final int[] queue;
    private final int size;
    private final int DEFAULT_SIZE = 5;
    private int current = 0;
    private int front = -1;
    private int rear = -1;

    public QueueUsingArray() {
        this.size = this.DEFAULT_SIZE;
        this.queue = new int[this.size];
    }

    public QueueUsingArray(int size) {
        if (size < 1) size = this.DEFAULT_SIZE;
        this.size = size;
        this.queue = new int[this.size];
    }

    public void enQueue(int element) {
        if (this.rear + 1 >= this.size) {
            throw new IllegalStateException("Queue is full.");
        }
        this.queue[++rear] = element;
        if (front == -1) {
            front++;
        }
        current++;
    }

    public int deQueue() {
        if (this.front == -1) {
            throw new IllegalStateException("Queue is empty.");
        }
        int removed = this.queue[front++];
        current--;
        return removed;
    }

    public int first() {
        if (this.current == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return this.queue[front];
    }

    public int last() {
        if (this.current == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return this.queue[rear];
    }

    public int getSize() {
        return this.current;
    }

    public int getMaxSize() {
        return this.size;
    }

    public static void main(String[] args) {
        QueueUsingArray qImpl = new QueueUsingArray(5);
        qImpl.enQueue(2);
        qImpl.enQueue(999);
        qImpl.enQueue(200);
        System.out.println("First : " + qImpl.first());
        System.out.println("Last : " + qImpl.last());
        System.out.println("Current size : " + qImpl.getSize());

        System.out.println("De Queue : " + qImpl.deQueue());
        System.out.println("De Queue : " + qImpl.deQueue());
        System.out.println("De Queue : " + qImpl.deQueue());

        System.out.println("Current size : " + qImpl.getSize());

        qImpl.enQueue(345);
        qImpl.enQueue(777);

        System.out.println("First : " + qImpl.first());
        System.out.println("Last : " + qImpl.last());
        System.out.println("Current size : " + qImpl.getSize());
    }
}