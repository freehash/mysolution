package com.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hattur on 10/29/17.
 */
public class SmallestK {
    public static void main(String[] args) {

    }

    private static PriorityQueue<Integer> getKMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int a : arr) {
            if(heap.size() < k) {
                heap.add(a);
            }
            else {
                if(a < heap.peek()) {
                    heap.poll();
                    heap.add(a);
                }
            }
        }

        return heap;
    }
}
