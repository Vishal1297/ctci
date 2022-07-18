package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

public class KthNodeFromLast {

    public static int findKth(Node<Integer> head, int k){
        if (head == null) return -1;
        int length = getLength(head);
        Node<Integer> temp = head;
        while (temp != null && (length - k) != 0){
            temp = temp.getNext();
            k++;
        }
        return temp == null ? -1 : temp.getData();
    }

    public static int getLength(Node<Integer> head){
        int length = 0;
        Node<Integer> temp = head;
        while (temp != null){
            temp = temp.getNext();
            length++;
        }
        return length;
    }

}
