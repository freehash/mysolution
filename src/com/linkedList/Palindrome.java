package com.linkedList;

import java.util.Stack;

/**
 * Created by hattur on 10/30/17.
 */
public class Palindrome {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node twotwo = new Node(2);
        Node oneone = new Node(1);
        Node zerozero = new Node(0);
        Node xyz = new Node(0);

        head.next = one;
        one.next = two;
        two.next = twotwo;
        twotwo.next = oneone;
        oneone.next = zerozero;
        zerozero.next = xyz;

        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    private static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();
            if(slow.data != pop) {
                return false;
            }
            slow = slow.next;
        }

        return stack.isEmpty() && slow == null;
    }
}
