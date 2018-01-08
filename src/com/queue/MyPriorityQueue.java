package com.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by hattur on 10/29/17.
 */
public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        heap.add(3);
        heap.add(1);
        heap.add(8);
        heap.add(26);

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());

    }
}
