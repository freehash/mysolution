package com.recursion;

import java.util.ArrayList;

/**
 * Created by hattur on 10/17/17.
 */
public class Queens {
    public static void main(String[] args) {
        Integer[] columns = new Integer[8];
        ArrayList<Integer[]> results = new ArrayList<>();
        placeQueens(0, columns, results);
    }

    private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if(row == 8) {
            results.add(columns.clone());
        }
        else{
            for(int col = 0; col < 8; col++) {
                if(checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row+1, columns, results);
                }
            }
        }
    }

    private static boolean checkValid(Integer[] columns, int row1, int column1) {
        for(int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];
            if(column1 == column2) {
                return false;
            }
            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;
            if(columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }
}
