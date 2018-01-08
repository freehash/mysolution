package com.sorting;

/**
 * Created by hattur on 10/16/17.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8,4,16,9,20,-3,700};
        insertionSort(arr);
        print(arr);
    }

    private static void insertionSort(int[] arr) {
        for(int which = 1; which < arr.length; which++) {
            int val = arr[which];
            for(int i = 0; i < which; i++) {
                if(arr[i] > arr[which]) {
                    System.arraycopy(arr, i, arr, i+1, which);
                    arr[i] = val;
                }
            }
        }
    }

    private static void print(int[] arr) {
        for(int i = 0; i< arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}


