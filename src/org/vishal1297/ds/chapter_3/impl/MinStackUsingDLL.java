package org.vishal1297.ds.chapter_3.impl;

public class MinStackUsingDLL {

    static class StackNode {
        StackNode prev;
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    StackNode head = null;
    StackNode prev = null;
    StackNode next = null;
    StackNode mid = null;
    StackNode minimum = null;

    int size = 0;

    public MinStackUsingDLL() {
        super();
    }

    public void push(int data) {
        StackNode node = new StackNode(data);

        if (size == 0) {
            head = node;
            mid = node;
        } else {
            head.next = node;
            node.prev = head;
            head = head.next;
            if (size % 2 != 0) {
                mid = mid.next;
            }
        }
        size++;

        if (minimum == null) {
            minimum = node;
        } else {
            if (minimum.data > data) {
                StackNode newNode = new StackNode(data);
                minimum.next = newNode;
                newNode.prev = minimum;
                minimum = minimum.next;
            }
        }
    }

    public int pop() {
        int data = -1;
        if (size == 0) {
            throw new IllegalStateException("Stack is empty.");
        } else {
            if (size == 1) {
                head = null;
                mid = null;
            } else {
                data = head.data;
                head = head.prev;
                head.next = null;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
            size--;

            if (minimum != null) {
                if (minimum.data == data) {
                    minimum = minimum.prev;
                    minimum.next = null;
                }
            }
        }
        return data;
    }

    public int getSize() {
        return size;
    }

    public int getMid() {
        if (mid == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        return mid.data;
    }

    public int getMinimum() {
        if (minimum == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        return minimum.data;
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        return head.data;
    }

    public void deleteMiddleElement() {
        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            } else if (size == 2) {
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            } else {
                mid.prev.next = mid.next;
                mid.next.prev = mid.prev;

                if (size % 2 == 0) {
                    mid = mid.prev;
                } else {
                    mid = mid.next;
                }
            }
            size--;
        }
    }

    public static void main(String[] args) {
        MinStackUsingDLL ms = new MinStackUsingDLL();
        ms.push(11);
        ms.push(22);
        ms.push(3);
        System.out.println("Middle Element : " + ms.getMid());
        ms.deleteMiddleElement();
        System.out.println("Top Element : " + ms.peek());
        System.out.println("Min Element : " + ms.getMinimum());
        ms.push(5);
        ms.push(44);

        System.out.println("Popped Element : " + ms.pop());
        System.out.println("Popped Element : " + ms.pop());
        System.out.println("Popped Element : " + ms.pop());
        System.out.println("Top Element: " + ms.peek());
        System.out.println("Middle Element : " + ms.getMid());
        System.out.println("Min Element : " + ms.getMinimum());

        ms.deleteMiddleElement();

        System.out.println("New Middle Element : " + ms.getMid());
    }
}