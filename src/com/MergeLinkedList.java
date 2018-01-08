package com;

/**
 * Created by hattur on 7/27/17.
 */
public class MergeLinkedList {

    public static void main(String args[]) {
        Node one = new Node();
        one.data = 1;

        Node three = new Node();
        three.data = 3;

        Node five = new Node();
        five.data = 5;

        Node seven = new Node();
        seven.data = 7;

        one.next = three;
        three.next = five;
        five.next = seven;

        Node headA = one;


        Node two = new Node();
        two.data = 2;

        Node four = new Node();
        four.data = 4;

        Node six = new Node();
        six.data = 6;

        two.next = four;
        four.next = six;

        Node headB = two;

        Node head = mergeLists(headA, headB);

        System.out.println(head.data);

        System.out.println("--------");
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }


    }

    static Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if(headA == null) {
            return headB;
        }
        if(headB == null) {
            return headA;
        }

        Node head = null;
        Node tail = null;
        while(headA != null && headB != null) {
            Node node = new Node();

            if(headA.data <= headB.data) {
                System.out.println("A " + headA.data);
                node.data = headA.data;
                headA = headA.next;
            }
            else {
                System.out.println("B " + headB.data);
                node.data = headB.data;
                headB = headB.next;
            }

            if(head == null) {
                head = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
        }
        //System.out.println("headA = null");
        if(headA == null && headB != null) {
            System.out.println("headA = null");
            tail.next = headB;
        }

        else if (headB == null && headA != null) {
            //System.out.println("headB = null");
            tail.next = headA;
        }


        return head;
    }
}

class Node {
    int data;
    Node next;
}
