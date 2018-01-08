package com.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hattur on 10/11/17.
 */
public class Pangrams {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String s = "Wepromptlyjudgedantiqueivorybucklesforthenextpwrize".toLowerCase();
        Set<Character> alphabetSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            alphabetSet.add(s.charAt(i));
        }

        if(alphabetSet.size() == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }

    }
}
