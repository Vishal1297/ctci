package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

public class Partition {

    public static Node<Integer> partition(Node<Integer> head, Integer partition) {
        Node<Integer> leftPtr = head;
        Node<Integer> rightPtr = head;
        while (leftPtr != null) {
            if (leftPtr.getData() >= partition) {
                leftPtr = leftPtr.getNext();
            } else if (leftPtr.getData() <= partition) {
                Integer temp = leftPtr.getData();
                leftPtr.setData(rightPtr.getData());
                rightPtr.setData(temp);

                leftPtr = leftPtr.getNext();
                rightPtr = rightPtr.getNext();
            }
        }
        return head;
    }

}
