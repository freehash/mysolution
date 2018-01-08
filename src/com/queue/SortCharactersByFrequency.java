package com.queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by hattur on 10/29/17.
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String input = "tree";
        System.out.println(frequencySort(input));
    }

    private static String frequencySort(String input) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, StringBuilder> map = new HashMap<>();
        PriorityQueue<StringBuilder> maxHeap = new PriorityQueue<>(new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder o1, StringBuilder o2) {
                if(o2.length() > o1.length()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for(int i = 0;i < input.length(); i++) {
            char key = input.charAt(i);
            if(map.containsKey(key)) {
                map.get(key).append(key);
            }
            else {
                map.put(key, new StringBuilder().append(key));
            }
        }

        maxHeap.addAll(map.values());

        while(!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }

        return sb.toString();
    }
}
