package com.arraysAndStrings;

/**
 * Created by hattur on 10/28/17.
 */
public class Ponds {
    public static void main(String[] args) {
        int[][] ponds = {
                            {1, 1, 1, 1, 0},
                            {1, 1, 0, 1, 0},
                            {1, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                        };
        int islandCount = 0;
        for(int i = 0; i < ponds.length; i++) {
            for(int j = 0; j < ponds[i].length; j++) {
                int size = visit(ponds, i, j);
                if(size > 0) {
                    islandCount ++;
                }
            }
        }

        System.out.println(islandCount);

    }

    static int visit(int[][] ponds, int i, int j) {
        int rowLength = ponds.length;
        int colLength = ponds[0].length;

        if(i >= rowLength || j >= colLength || i < 0 || j < 0 || ponds[i][j] != 1) {
            return 0;
        }
        ponds[i][j] = -1;
        int size = 1;
        size += visit(ponds, i-1, j);
        size += visit(ponds, i+1, j);
        size += visit(ponds, i, j-1);
        size += visit(ponds, i, j+1);

        return size;

    }
}
