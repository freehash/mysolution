package com.sorting;

/**
 * Created by hattur on 10/16/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {8,4,16,9,20,-3,700};
        quickSort(data, 0, data.length - 1);
        print(data);
    }

    private static void quickSort(int[] data, int left, int right) {
        int pivotValue = data[(left + right)/2];
        int i = left;
        int j = right;

        while(i <= j) {
            while(data[i] < pivotValue) {
                i++;
            }

            while(data[j] > pivotValue) {
                j--;
            }

            if(i <= j) {
                swap(data, i , j);
                i++;
                j--;
            }
        }

        if(left < j) {
            quickSort(data, left, j);
        }
        if(i < right) {
            quickSort(data, i, right);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }


    private static void print(int[] arr) {
        for(int i = 0; i< arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
