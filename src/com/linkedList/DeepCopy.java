package com.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hattur on 10/28/17.
 */
public class DeepCopy {
    public static void main(String[] args) {
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

        Node newHead = deepCopy(head);

        RandomListNode root = new RandomListNode(1);
        RandomListNode twoRandom = new RandomListNode(2);
        RandomListNode threeRandom = new RandomListNode(3);
        RandomListNode fourRandom = new RandomListNode(4);

        root.next = twoRandom;
        twoRandom.next = threeRandom;
        threeRandom.next = fourRandom;

        twoRandom.random = fourRandom;
        threeRandom.random = twoRandom;

        RandomListNode randomListNode = copyRandomList(root);
        RandomListNode randomListNode1 = copyRandomUsingMap(root);

        System.out.println(randomListNode1);
    }


    public static RandomListNode copyRandomUsingMap(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode iter = head;
        while(iter != null) {
            map.put(iter, new RandomListNode(iter.label));
            iter = iter.next;
        }

        iter = head;
        while(iter != null) {
            RandomListNode randomListNode = map.get(iter);
            randomListNode.next = map.get(iter.next);
            randomListNode.random = map.get(iter.random);

            iter = iter.next;
        }

        return map.get(head);

    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

    private static Node deepCopy(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = new Node(head.data);
        Node next;
        Node prev = newHead;
        while (head.next != null) {  // Iterate till str.next != null, as we are creating
            next = new Node(head.next.data);
            prev.next = next;
            prev = next;
            head = head.next;  // Move to next node.
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}