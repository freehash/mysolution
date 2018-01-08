package com.design;

/**
 * Created by hattur on 11/5/17.
 */
public class CircularArray<T> {
    private T[] items;
    private int size;
    private int head = 0;

    public CircularArray(int size) {
        this.size = size;
        items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if(index < 0) {
            index += size;
        }
        return (head + index) % size;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(" out of bounds ");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public static void main(String[] args) {
        CircularArray<Integer> ca = new CircularArray<>(10);
        ca.set(1, 5);
        ca.rotate(2);
        System.out.println(ca.get(1));

        int sum = 12;
        while(sum > 0) {
            System.out.println(sum % 10);
            sum /= 10;
        }

        int numberOfDigits = (int)Math.floor(Math.log10(sum)) + 1;

        System.out.println(Math.floor(Math.log10(12)));
    }
}
