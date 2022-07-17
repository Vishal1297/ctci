package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoveDuplicatesInLinkedList {

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> slowPtr = head;
        while (slowPtr != null && slowPtr.getNext() != null) {
            Node<Integer> fastPtr = slowPtr;
            while (fastPtr != null && fastPtr.getNext() != null) {
                if (Objects.equals(slowPtr.getData(), fastPtr.getNext().getData())) {
                    fastPtr.setNext(fastPtr.getNext().getNext());
                } else {
                    fastPtr = fastPtr.getNext();
                }
            }
            slowPtr = slowPtr.getNext();
        }
        return head;
    }

    public static Node<Integer> removeDuplicatesWithBuffer(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> temp = head;
        Map<Integer, Integer> buffer = new HashMap<>();
        while (temp != null && temp.getNext() != null) {
            buffer.put(temp.getData(), null);
            if (buffer.containsKey(temp.getNext().getData())) {
                temp.setNext(temp.getNext().getNext());
            } else {
                buffer.put(temp.getNext().getData(), null);
                temp = temp.getNext();
            }
        }
        return head;
    }

}
