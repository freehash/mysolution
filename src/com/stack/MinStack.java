package com.stack;

/**
 * Created by hattur on 10/14/17.
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    /** initialize your data structure here. */
    private StackNode stackNode;
    private StackNode minStackNode;
    private StackNode top;
    private StackNode minTop;
    private int min;
    public MinStack() {
        top = null;
        minTop = null;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stackNode = new StackNode(x);
        stackNode.next = top;
        top = stackNode;

        if(x < min) {
            minStackNode = new StackNode(x);
            min = x;
        }
        else {
            minStackNode = new StackNode(min);
        }
        minStackNode.next = minTop;
        minTop = minStackNode;

    }

    public void pop()  {
        if(top != null) {
            minTop = minTop.next;
            top = top.next;
        }
    }

    public int top()  {
        return top.data;
    }

    public int getMin()  {
        return minTop.data;
    }

    private static class StackNode {
        private int data;
        private StackNode next;

        private StackNode(int data) {
            this.data = data;
        }

    }
}
