package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hattur on 10/14/17.
 */
public class PowerSet {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> powerSet = getPowerSet(a, 0);
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        System.out.println(getPowerSet2(input));
    }

    static List<List<Integer>> getPowerSet(int[] numbers, int index) {
        List<List<Integer>> allSets = new ArrayList<>();
        if(numbers.length == index) {
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int current = numbers[index];
        List<List<Integer>> allpowerSets = getPowerSet(numbers, index + 1);
        List<List<Integer>> currentPowerSet = new ArrayList<>();
        currentPowerSet.addAll(allpowerSets);
        for(List<Integer> powerSet : allpowerSets) {
            List<Integer> curSet = new ArrayList<>();
            curSet.addAll(powerSet);
            curSet.add(current);
            currentPowerSet.add(curSet);
        }
        allSets.addAll(currentPowerSet);
        return allSets;
    }

    static List<List<Integer>> getPowerSet2(ArrayList<Integer> set) {
        List<List<Integer>> allSets = new ArrayList<>();
        int max = 1 << set.size();
        for(int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSets.add(subset);
        }
        return allSets;
    }

    private static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for(int k = x; k > 0; k >>= 1) {
            if((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index ++;
        }
        return subset;
    }


}
