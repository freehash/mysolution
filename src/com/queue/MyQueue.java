package com.queue;

/**
 * Created by hattur on 10/15/17.
 */
public class MyQueue<T> {
    private static class QueNode<T> {
        private T data;
        private QueNode<T> next;

        public QueNode(T data) {
            this.data = data;
        }
    }

    private QueNode<T> first;
    private QueNode<T> last;

    public void add(T item) {
        QueNode<T> node = new QueNode<T>(item);
        if(last != null) {
            last.next = node;
        }
        last = node;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) {
            return null;
        }
        T data = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
