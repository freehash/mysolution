package com.strings;

/**
 * Created by hattur on 10/11/17.
 */
public class Substring {

    public static void main(String[] args) {
        //String str= "ereiahmstackerrankawe";
        String str= "ereiahmstadcdkdedrdrkdadnddadwde";
        String hacker= "hackerrank";
        String s= "hello";
        String p= "hello";
        //System.out.println(hasSubstring(str, hacker));
        System.out.println(firstOccurence(s, p));
    }

    private static boolean hasSubstring(String remainder, String remainderHackerrank) {
        int index = remainder.indexOf(remainderHackerrank.substring(0,1));
        if(index == -1) {
            return false;
        }
        if(remainderHackerrank.length() == 1) {
            return true;
        }
        return hasSubstring(remainder.substring(index+1), remainderHackerrank.substring(1));
    }

    private static int firstOccurence(String str, String pattern) {
        int len = str.length();
        int pat = pattern.length();
        for(int i = 0; i <= len - pat; i++) {
            if(str.substring(i, i+pat).equals(pattern)) {
                return i;
            }
        }
        return -1;
    }
}
