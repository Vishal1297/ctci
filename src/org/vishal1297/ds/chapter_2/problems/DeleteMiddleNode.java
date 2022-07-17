package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

public class DeleteMiddleNode {

    public static Node<Integer> deleteMiddle(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> slowPtr = head;
        Node<Integer> fastPtr = head.getNext();
        while (fastPtr != null && fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        if (slowPtr.getNext() == null) {
            head = null;
        }else {
            slowPtr.setNext(slowPtr.getNext().getNext());
        }
        return head;
    }

}
