package com;

import java.util.HashSet;
import java.util.Set;

public class OneEdit {

    private boolean isOneEdit(String input1, String input2) {
        Set<Character> charset = new HashSet<>();
        if(input1.equals(input2)) {
            return true;
        }
        for(int i = 0; i < input1.length() ; i++) {
            char c = input1.charAt(i);
            charset.add(c);
        }

        int mismatch = 0;
        for(int j = 0; j < input2.length() ;j++) {
            char d = input2.charAt(j);
            if(!charset.contains(d)) {
                mismatch++;
                if(mismatch > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneEdit oneEdit = new OneEdit();
        //System.out.println(oneEdit.isOneEdit("pale", "ple"));
        //System.out.println(oneEdit.isOneEdit("pale", "ple"));
        System.out.println(oneEdit.isOneEdit("pale", "pales"));
        //System.out.println(oneEdit.isOneEdit("pale", "bale"));
        //System.out.println(oneEdit.isOneEdit("pale", "bake"));
        //System.out.println(oneEdit.isOneEdit("pale", "pale"));
    }
}
