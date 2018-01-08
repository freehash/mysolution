package com;

/**
 * Created by hattur on 6/8/17.
 */
public class CamelCase {

    static int numberOfWords(String s) {
        if(s == null || s.length() == 0) return 0;
        int counter = 0;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) {
                counter ++;
            }
        }
        return ++counter;
    }

    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        //String s = "";
        //String s = null;
        System.out.println(numberOfWords(s));
    }
}
