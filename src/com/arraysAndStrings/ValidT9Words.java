package com.arraysAndStrings;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by hattur on 11/6/17.
 */
public class ValidT9Words {
    public static void main(String[] args) {
        HashSet<String> wordList = new HashSet<>();
        wordList.add("hello");
        wordList.add("tree");
        wordList.add("how");
        wordList.add("good");
        wordList.add("used");

        String number = "8733";

        ArrayList<String> validT9Words = getValidT9Words(number, wordList);
        System.out.println(validT9Words);
    }
    private static ArrayList<String> getValidT9Words(String number, HashSet<String> wordList) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", wordList, results);
        return results;
    }

    private static void getValidWords(String number, int index, String prefix,
                                      HashSet<String> wordList, ArrayList<String> results) {
        if(index == number.length() && wordList.contains(prefix)) {
            results.add(prefix);
            return;
        }

        if(index == number.length()) {
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);
        if(letters != null) {
            for(char letter : letters) {
                getValidWords(number, index + 1, prefix + letter, wordList, results);
            }
        }
    }

    private static char[] getT9Chars(char digit) {
        if(!Character.isDigit(digit)) {
            return null;
        }
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }

    static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j','k','l'}, {'m','n','o'},
            {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
}
