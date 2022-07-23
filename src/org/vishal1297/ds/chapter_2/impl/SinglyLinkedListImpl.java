package org.vishal1297.ds.chapter_2.impl;

import org.vishal1297.ds.chapter_2.problems.Intersection;
import org.vishal1297.ds.chapter_2.problems.Palindrome;

public class SinglyLinkedListImpl<T extends Comparable<T>> {

    private Node<T> head;
    private int current;

    public SinglyLinkedListImpl() {
    }

    public Node<T> getHead() {
        return head;
    }

    public void add(T element){
        if (head == null) head = new Node<>(element, null);
        else {
            Node<T> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node<>(element, null));
        }
        current++;
    }

    public void addAtFirst(T element){
        if (head == null) head = new Node<>(element, null);
        else {
            Node<T> node = head;
            head = new Node<>(element, node);
        }
        current++;
    }

    public void add(T element, int index){
        if (index < 0 || index > current) {
            throw new IllegalArgumentException("Invalid index");
        } else if (index == 0) {
            addAtFirst(element);
        }else {
            if (head == null) head = new Node<>(element, null);
            else {
                int currIndex = index;
                Node<T> temp = head;
                while (currIndex > 1){
                    temp = temp.getNext();
                    currIndex--;
                }
                Node<T> next = temp.getNext();
                temp.setNext(new Node<>(element, next));
            }
        }
    }

    public T remove(){
        if (head == null){
            throw new IllegalStateException("List is empty");
        }else {
            T elem = head.getData();
            head = head.getNext();
            return elem;
        }
    }

    public T remove(int index){
        if (index < 0) throw new IllegalArgumentException("Invalid index");
        else if (index == 0) return remove();
        else {
            if (head == null) throw new IllegalStateException("List is empty");
            else if (index >= current) throw new IllegalArgumentException("Invalid index");
            else {
                int currIndex = index;
                Node<T> temp = head;
                while (currIndex > 1){
                    temp = temp.getNext();
                    currIndex--;
                }
                T removed = temp.getNext().getData();
                Node<T> next = temp.getNext().getNext();
                temp.setNext(next);
                return removed;
            }
        }
    }

    public void clear() {
        this.head = null;
    }

    public T peek() {
        if (head == null) throw new IllegalStateException("List is empty");
        else {
            Node<T> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

    public T get(int index){
        if (index < 0) throw new IllegalArgumentException("Invalid index");
        else if (head == null) {
            throw new IllegalStateException("List is empty");
        } else if (index == 0) {
            return head.getData();
        }else {
            if (index >= current - 1) throw new IllegalArgumentException("Invalid index");
            else {
                int currIndex = index;
                Node<T> temp = head;
                while (currIndex > 0){
                    temp = temp.getNext();
                    currIndex--;
                }
                return temp.getData();
            }
        }
    }

    public T pollFirst(){
        if (head == null) throw new IllegalStateException("List is empty");
        else  {
            return head.getData();
        }
    }

    public int length() { return current - 1; }

    public void print(){
        Node<T> temp = head;
        if (temp == null) return;
        while (temp.getNext() != null){
            System.out.print(temp.getData() + " => ");
            temp = temp.getNext();
        }
        System.out.print(temp.getData());
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl<>();
        linkedList.add(1);
        linkedList.add(21);
        linkedList.add(21);
        linkedList.add(21);
        System.out.println("LinkedList :");
        linkedList.print();
        System.out.println("LinkedList :");
        linkedList.print();
    }
}
