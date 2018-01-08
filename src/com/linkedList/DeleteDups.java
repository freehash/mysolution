package com.linkedList;

import java.util.HashSet;

public class DeleteDups {
    public static void main(String args[]) {
        Node one = new Node();
        one.data = 1;

        Node two = new Node();
        two.data = 2;

        Node three = new Node();
        three.data = 3;

        Node four = new Node();
        four.data = 4;

        Node five = new Node();
        five.data = 5;

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Node head = one;


        deleteMiddle(three);

        System.out.println(head.data);

        System.out.println("--------");
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static void deleteDups(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = head;
        while(head != null) {
            if(set.contains(head.data)) {
                previous.next = head.next;
            }
            else {
                set.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    private static void deleteDupsWithoutBuffer(Node head) {
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
                else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    private static void deleteMiddle(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}

class Node {
    int data;
    Node next;

    Node(){}

    Node(int data) {
        this.data = data;
    }
}
