package com.linkedList;

/**
 * Created by hattur on 11/14/17.
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        head.next = two;
        two.next = three;
        //three.next = four;
        //four.next = five;
        //five.next = six;

        ListNode listNode = oddEvenList(head);
        System.out.println(listNode);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
        ListNode oddRunner = head;
        ListNode evenHead = head.next;
        ListNode prevEvenHead = evenHead;
        ListNode evenRunner = evenHead;

        while(evenRunner != null && evenRunner.next != null) {
            oddRunner.next = evenRunner.next;
            oddRunner = oddRunner.next;
            evenRunner = evenRunner.next.next;
            prevEvenHead.next = evenRunner;
            prevEvenHead = evenRunner;
        }

        oddRunner.next = evenHead;

        return head;
    }

}
