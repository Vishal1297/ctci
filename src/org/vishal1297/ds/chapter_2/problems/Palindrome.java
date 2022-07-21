package org.vishal1297.ds.chapter_2.problems;

import org.vishal1297.ds.chapter_2.impl.Node;

import java.util.Objects;

public class Palindrome {

    /**
     * Reverse only till middle & then compare
     */
    public static boolean isPalindrome(Node<Integer> head) {
        Node<Integer> slowPtr = head;
        Node<Integer> fastPtr = head;

        while (fastPtr != null && fastPtr.getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }

        slowPtr = reverse(slowPtr);
        fastPtr = head;

        while (slowPtr != null && fastPtr != null) {
            if (!Objects.equals(fastPtr.getData(), slowPtr.getData())) {
                return false;
            }
            fastPtr = fastPtr.getNext();
            slowPtr = slowPtr.getNext();
        }

        return true;
    }

    /**
     * Reverse all elements & then compare
     */
    public static boolean isPalindromeV1(Node<Integer> head) {
        Node<Integer> reversed = reverse(head);
        while (head != null && reversed != null) {
            if (!Objects.equals(head.getData(), reversed.getData())) {
                return false;
            }
            head = head.getNext();
            reversed = reversed.getNext();
        }
        return head == null && reversed == null;
    }

    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> newHead = null;
        while (head != null) {
            Node<Integer> curr = new Node<>(head.getData(), null);
            curr.setNext(newHead);
            newHead = curr;
            head = head.getNext();
        }
        return newHead;
    }
}
