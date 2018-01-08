package com.linkedList;

/**
 * Created by hattur on 11/1/17.
 */
public class Merge2List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode prev = null;
        while(l1 != null && l2 != null) {
            ListNode node = null;
            if(l1.val <= l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if(head == null) {
                head = node;
                prev = node;
            }
            else {
                prev.next = node;
                prev = node;
            }
        }
        if(l1 != null) {
            while(l1 != null) {
                ListNode node = new ListNode(l1.val);
                prev.next = node;
                prev = node;
                l1 = l1.next;
            }
        }

        if(l2 != null) {
            while(l2 != null) {
                ListNode node = new ListNode(l2.val);
                prev.next = node;
                prev = node;
                l2 = l2.next;
            }
        }

        return head;
    }
}
