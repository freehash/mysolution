package com.arraysAndStrings;


import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

    private boolean allUniqueCharacters(String s) {
        Set<Character> characters = new HashSet<>();
        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            int val = s.charAt(i);
            if(!characters.add(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueChars(String str) {
        int checker = 0;
        for(int i = 0;i<str.length();i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;

    }

    public static void main(String[] args) {
        UniqueCharacters uc = new UniqueCharacters();
        String s = "abz";
        System.out.println(uc.isUniqueChars(s));
        System.out.println(uc.allUniqueCharacters(s));
    }
}

