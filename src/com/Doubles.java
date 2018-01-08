package com;

import java.util.*;



public class Doubles {

    public static void main(String[] args) {
        int[] data = {-2,3,1,0,2};
        //List<List<Integer>> doubles = findDoubles(data, 3);
        //System.out.println(doubles);
        Set<String> triples = findTriple(data, 3);
        //System.out.println(triples);
        List<List<Integer>> allTriples = convert(triples, data);
        System.out.println(allTriples);
    }

    private static List<List<Integer>> convert(Set<String> triples, int[] data) {
        List<List<Integer>> allTriples = new ArrayList<>();
        for(String s : triples) {
            allTriples.add(convertSingle(s, data));
        }
        return allTriples;
    }

    private static List<Integer> convertSingle(String s, int[] data) {
        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
            integers.add(data[i]);
        }
        return integers;
    }

    private static Set<String> findTriple(int[] data, int total) {
        Set<String> triples = new HashSet<>();
        for(int i = 0; i < data.length; i++) {
            List<int[]> doubles = findDoubles(data, total - data[i], i);
            if(doubles.size() > 0) {
                for(int[] doubleIncluded : doubles) {
                    doubleIncluded[i] = 1;

                    triples.add(convertToString(doubleIncluded));
                }
            }
        }

        return triples;
    }

    private static String convertToString(int[] included) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < included.length; i++) {
            sb.append(included[i]);
        }
        return sb.toString();
    }

    private static List<int[]> findDoubles(int[] data, int total, int excludedIndex) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        List<int[]> output = new ArrayList<>();

        for(int i = 0; i< data.length; i++) {
            int difference = total - data[i];
            if(i == excludedIndex) {
                continue;
            }
            if(numberMap.containsKey(difference)) {
                int[] includedIndex = new int[data.length];
                includedIndex[i] = 1;
                includedIndex[numberMap.get(difference)] = 1;
                output.add(includedIndex);
            }
            else{
                numberMap.put(data[i], i);
            }
        }
        return output;
    }
}
