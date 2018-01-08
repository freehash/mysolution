package com.sorting;

/**
 * Created by hattur on 10/16/17.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {-8,4,16,9,20,-3,700};
        selectionSort(arr);
        print(arr);
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            swap(i, findMinIndex(i, arr), arr);
        }
    }

    private static void swap(int i, int minIndex, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    static int findMinIndex(int index, int[] arr) {
        int minIndex = index;
        for(int i = index+1; i < arr.length; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void print(int[] arr) {
        for(int i = 0; i< arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}


