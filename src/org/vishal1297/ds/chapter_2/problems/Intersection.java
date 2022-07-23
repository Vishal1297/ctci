package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

public class Intersection {

    public static Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
        if (headA == null || headB == null) return null;
        Node<Integer> first = headA;
        Node<Integer> second = headB;
        while (first != second) {
            first = first == null ? headB : first.getNext();
            second = second == null ? headA : second.getNext();
        }
        return first;
    }
}
