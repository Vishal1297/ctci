package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

import java.util.HashMap;

public class LoopDetection {

    public Node<Integer> hasLoopDetection(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> slowPtr = head;
        boolean hasLoop = false;
        while (slowPtr != null) {
            Node<Integer> fastPtr = slowPtr.getNext();
            while (fastPtr != null && slowPtr != fastPtr) {
                fastPtr = fastPtr.getNext();
            }
            if (slowPtr == fastPtr) {
                hasLoop = true;
                break;
            }
            slowPtr = slowPtr.getNext();
        }
        return hasLoop ? slowPtr : null;
    }

    public Node<Integer> hasLoopDetectionV2(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> slowPtr = head;
        HashMap<Node<Integer>,Node<Integer>> map = new HashMap<>();
        while (slowPtr != null) {
            if (map.containsKey(slowPtr)){
                return map.get(slowPtr);
            }
            map.put(slowPtr, slowPtr);
            slowPtr = slowPtr.getNext();
        }
        return null;
    }

    public Node<Integer> hasLoopDetectionV3(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> slowPtr = head;
        Node<Integer> fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if (slowPtr == fastPtr) {
                return slowPtr;
            }
        }
        return null;
    }
}
