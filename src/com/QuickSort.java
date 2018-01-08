package com;

public class QuickSort {

    void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int mid = (left + right)/2;
        int pivot = arr[mid];
        while(left <= right) {
            while(arr[left] < pivot) left++;

            while(arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void printarr(int[] arr) {
        for(int i = 0; i< arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        //int[] arr = {20, 45, 2, 56, 7, 10, 67, 38, 32, 1 , 25};
        int[] arr = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        sort.quickSort(arr, 0, 8);
        sort.printarr(arr);
    }
}
