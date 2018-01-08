package com;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        int n = 5;
        System.out.println(cs.nthCountAndSay(n));
    }

    private String nthCountAndSay(int n) {
        int times = 0;
        String output = "1";
        String prev = "1";
        if(n == 1) {
            return output;
        }
        else {
            while(times < n-1) {
                output = createNumberTimesString(prev);
                prev = output;
                times++;
            }
            return output;
        }
    }


    private String createNumberTimesString(String s) {
        StringBuilder sb = new StringBuilder();
        Character previousChar = null;
        Long count = 0L;
        for(int i = 0;i < s.length(); i++) {
            Character c = s.charAt(i);
            if(previousChar == null) {
                previousChar = c;
                count ++;
            }
            else if(c == previousChar) {
                count++;
            }
            else {
                buildOutput(sb, Character.getNumericValue(previousChar), count);
                previousChar = c;
                count = 1L;
            }
        }
        buildOutput(sb, Character.getNumericValue(previousChar), count);
        return sb.toString();
    }

    private void buildOutput(StringBuilder output, Integer number, Long times) {
        output.append(String.valueOf(times) + String.valueOf(number));
    }
}
