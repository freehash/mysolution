package com.moderate;

/**
 * Created by hattur on 10/11/17.
 */
public class SmallestDifference {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,11,15};
        int[] array2 = {8,9,23,127,235};

        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        int[] diffArr = new int[2];

        while(a<array1.length && b < array2.length) {
            int difference = Math.abs(array1[a] - array2[b]);
            if(difference == 0) {
                System.out.println("array1 " + array1[a] + " " + "array2 " + array2[b] + " difference=" + difference);
                break;
            }
            if(difference < min) {
                min = difference;
                diffArr[0] = array1[a];
                diffArr[1] = array2[b];
            }
            if(array1[a] < array2[b]) {
                a++;
            }
            else {
                b++;
            }
        }
        System.out.println("array1 " + diffArr[0] + " " + "array2 " + diffArr[1] + " difference=" + min);

    }


}
