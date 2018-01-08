package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hattur on 10/29/17.
 */
public class backtracking {

    public static void main(String[] args) {
        Integer[] columns = new Integer[8];
        List<Integer[]> results = new ArrayList<>();
        placeQueens(0, columns, (ArrayList<Integer[]>) results);
        System.out.println(results);

    }

    private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if(row == 8) {
            results.add(columns.clone());
        }
        else {
            for(int col = 0; col < 8; col++) {
                if(isValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private static boolean isValid(Integer[] columns, int row1, int col1) {
        for(int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];
            if(col1 == col2) {
                return false;
            }
            int columnDistance = Math.abs(col2 - col1);
            int rowDistance = row1 - row2;

            if(columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }
}
