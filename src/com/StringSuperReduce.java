package com;

/**
 * Created by hattur on 6/8/17.
 */
public class StringSuperReduce {

    static String super_reduced_string(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 1;
        while (left < s.length()) {
            if (left == s.length() - 1) {
                append(sb, s.charAt(left));
                left++;
            } else if (s.charAt(left) == s.charAt(right)) {
                left = left + 2;
                right = left + 1;
            } else {
                append(sb, s.charAt(left));
                left = left + 1;
                right = left + 1;
            }

        }
        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return "Empty String";
        }
    }

    private static void append(StringBuilder sb, char c) {
        if (sb.length() == 0) {
            sb.append(c);
        } else {
            if (sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
    }

    public static void main(String[] args) {
        //String s = "aaabccddd"; //-> abd
        String s = "baab";
        String result = super_reduced_string(s);
        System.out.println(result);

    }
}
