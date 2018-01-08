package com.linkedList;

/**
 * Created by hattur on 10/15/17.
 */
public class Intersection {
    public static void main(String[] args) {
        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next = headA;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ResultNode numNodesA = getTailAndSize(headA);
        ResultNode numNodesB = getTailAndSize(headB);
        int diff = Math.abs(numNodesA.count - numNodesB.count);

        ListNode nodeALast = numNodesA.listNode;
        ListNode nodeBLast = numNodesB.listNode;

        if(nodeALast != nodeBLast) {
            return null;
        }

        ListNode largerNode = numNodesA.count > numNodesB.count ? headA : headB;
        ListNode smallerNode = numNodesA.count > numNodesB.count ? headB : headA;

        int counter = 0;
        while(counter < diff) {
            largerNode = largerNode.next;
            counter++;
        }

        while(largerNode != smallerNode) {
            largerNode = largerNode.next;
            smallerNode = smallerNode.next;
        }

        return largerNode;
    }

    private static ResultNode getTailAndSize(ListNode head) {
        int numNodes = 1;
        ListNode current = head;
        while(current.next != null) {
            numNodes ++;
            current = current.next;
        }
        return new ResultNode(current, numNodes);
    }
}

class ResultNode {
    ListNode listNode;
    int count;
    ResultNode(ListNode listNode, int count) {
        this.listNode = listNode;
        this.count = count;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }